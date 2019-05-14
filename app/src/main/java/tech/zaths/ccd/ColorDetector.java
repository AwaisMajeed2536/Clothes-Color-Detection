package tech.zaths.ccd;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.AsyncTask;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class ColorDetector extends AsyncTask<Void, Integer, String> {

    private Bitmap bitmap;
    private ColorDetectorCallback callback;

    private ColorDetector(ColorDetectorCallback callback, Bitmap bitmap) {
        this.callback = callback;
        this.bitmap = bitmap;
    }

    static void detectColor(ColorDetectorCallback callback, Bitmap bitmap) {
        new ColorDetector(callback, bitmap).execute();
    }

    @Override
    protected String doInBackground(Void... voids) {
        Bitmap resizedBitmap = getResizedBitmap(bitmap);
        int width = resizedBitmap.getWidth();
        HashMap<String, Integer> foundColors = new HashMap<>();
        for (int i = 0; i < width; i++) {
            publishProgress(i * 100 / width);
            for (int j = 0; j < resizedBitmap.getHeight(); j++) {
                int pixel = resizedBitmap.getPixel(i, j);
                int redValue = Color.red(pixel);
                int blueValue = Color.blue(pixel);
                int greenValue = Color.green(pixel);
                String color = ColorUtils.getColorName(redValue, blueValue, greenValue);
                if (foundColors.get(color) == null)
                    foundColors.put(color, 1);
                else
                    foundColors.put(color, foundColors.get(color) + 1);
            }
        }
        Object[] a = foundColors.entrySet().toArray();
        Arrays.sort(a, new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((Map.Entry<String, Integer>) o2).getValue()
                        .compareTo(((Map.Entry<String, Integer>) o1).getValue());
            }
        });

        return ((Map.Entry<String, Integer>) a[0]).getKey();
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        callback.onProgress(values[0]);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        callback.onColorDetected(s);
    }

    private Bitmap getResizedBitmap(Bitmap image) {
        int width = image.getWidth();
        int height = image.getHeight();

        float bitmapRatio = (float) width / (float) height;
        if (bitmapRatio > 1) {
            width = 64;
            height = (int) (width / bitmapRatio);
        } else {
            height = 64;
            width = (int) (height * bitmapRatio);
        }

        return Bitmap.createScaledBitmap(image, width, height, true);
    }

    public interface ColorDetectorCallback {
        void onProgress(int progress);

        void onColorDetected(String color);
    }

    public static final long[] colors = {0, 255, 65280, 16711680, 16777215};
    public static final String[] colorNames = {"Black", "Blue", "Green", "Red", "White"};
}
