package tech.zaths.ccd;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.camerakit.CameraKitView;
import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.LoaderCallbackInterface;
import org.opencv.android.OpenCVLoader;

public class MainActivity extends AppCompatActivity implements CameraKitView.ImageCallback, View.OnClickListener, ColorDetector.ColorDetectorCallback {

    private CameraKitView cameraKitView;
    private TextView progressTv;

    private BaseLoaderCallback mLoaderCallback = new BaseLoaderCallback(this) {
        @Override
        public void onManagerConnected(int status) {
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cameraKitView = findViewById(R.id.camera);
        findViewById(R.id.cameraClickable).setOnClickListener(this);
        progressTv = findViewById(R.id.progressTv);
    }

    @Override
    protected void onStart() {
        super.onStart();
        cameraKitView.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        cameraKitView.onResume();
        if (!OpenCVLoader.initDebug()) {
            OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION_3_0_0, this, mLoaderCallback);
        } else {
            mLoaderCallback.onManagerConnected(LoaderCallbackInterface.SUCCESS);
        }
    }

    @Override
    protected void onPause() {
        cameraKitView.onPause();
        super.onPause();
    }

    @Override
    protected void onStop() {
        cameraKitView.onStop();
        super.onStop();
    }

    @Override
    public void onImage(CameraKitView cameraKitView, byte[] bytes) {
        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        ColorDetector.detectColor(this, bitmap);
        progressTv.setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick(View v) {
        cameraKitView.captureImage(this);
    }

    @Override
    public void onProgress(int progress) {
        progressTv.setText(String.format("%d%%", progress));
    }

    @Override
    public void onColorDetected(String color) {
        progressTv.setVisibility(View.GONE);
        Toast.makeText(this, color, Toast.LENGTH_SHORT).show();
    }
}