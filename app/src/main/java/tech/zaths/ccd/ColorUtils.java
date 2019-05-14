package tech.zaths.ccd;

public class ColorUtils {

    public static String getColorName(int r, int g, int b) {
        if (r <= 24) {
            if (g <= 24) {
                if (b <= 24) {
                    return "Black";
                } else if (b <= 80) {
                    return "Dark Blue";
                } else if (b <= 190) {
                    return "Blue";
                } else if (b <= 255) {
                    return "Light Blue";
                }
            } else if (g <= 80) {
                if (b <= 24) {
                    return "Dark Green";
                } else if (b <= 80) {
                    return "Bluish Green";
                } else if (b <= 190) {
                    return "Greenish Blue";
                } else if (b <= 255) {
                    return "Blue";
                }
            } else if (g <= 190) {
                if (b <= 24) {
                    return "Dark Green";
                } else if (b <= 80) {
                    return "Pale Green";
                } else if (b <= 190) {
                    return "Ferozi";
                } else if (b <= 255) {
                    return "Dark Ferozi";
                }
            } else if (g <= 255) {
                if (b <= 24) {
                    return "Green";
                } else if (b <= 80) {
                    return "Apple Green";
                } else if (b <= 190) {
                    return "Sea Green";
                } else if (b <= 255) {
                    return "Mint";
                }
            }
        } else if (r <= 80) {
            if (g <= 24) {
                if (b <= 24) {
                    return "Maroon";
                } else if (b <= 80) {
                    return "Purple";
                } else if (b <= 190) {
                    return "Blue";
                } else if (b <= 255) {
                    return "Royal Blue";
                }
            } else if (g <= 80) {
                if (b <= 24) {
                    return "Army";
                } else if (b <= 80) {
                    return "Dark Grey";
                } else if (b <= 190) {
                    return "Dark Space";
                } else if (b <= 255) {
                    return "Thin Blue";
                }
            } else if (g <= 190) {
                if (b <= 24) {
                    return "Kelly";
                } else if (b <= 80) {
                    return "Apple Green";
                } else if (b <= 190) {
                    return "Pine";
                } else if (b <= 255) {
                    return "Azure";
                }
            } else if (g <= 255) {
                if (b <= 24) {
                    return "Green";
                } else if (b <= 80) {
                    return "Pale Green";
                } else if (b <= 190) {
                    return "Emerald";
                } else if (b <= 255) {
                    return "Sky Green";
                }
            }
        } else if (r <= 190) {
            if (g <= 24) {
                if (b <= 24) {
                    return "Maroon";
                } else if (b <= 80) {
                    return "Carmine";
                } else if (b <= 190) {
                    return "Electric";
                } else if (b <= 255) {
                    return "Light Purple";
                }
            } else if (g <= 80) {
                if (b <= 24) {
                    return "Brown";
                } else if (b <= 80) {
                    return "Red Wood";
                } else if (b <= 190) {
                    return "Purple";
                } else if (b <= 255) {
                    return "Light Purple";
                }
            } else if (g <= 190) {
                if (b <= 24) {
                    return "Dim Green";
                } else if (b <= 80) {
                    return "Grayish Green";
                } else if (b <= 190) {
                    return "Greenish Gray";
                } else if (b <= 255) {
                    return "Bluish Gray";
                }
            } else if (g <= 255) {
                if (b <= 24) {
                    return "Green";
                } else if (b <= 80) {
                    return "Dim Green";
                } else if (b <= 190) {
                    return "Apple Green";
                } else if (b <= 255) {
                    return "Light Ferozi";
                }
            }
        } else if (r <= 255) {
            if (g <= 24) {
                if (b <= 24) {
                    return "Dark Red";
                } else if (b <= 80) {
                    return "Dark Pink";
                } else if (b <= 190) {
                    return "Pink";
                } else if (b <= 255) {
                    return "Pinkish Purple";
                }
            } else if (g <= 80) {
                if (b <= 24) {
                    return "Sangria";
                } else if (b <= 80) {
                    return "Brick";
                } else if (b <= 190) {
                    return "Purple";
                } else if (b <= 255) {
                    return "Purplish Pink";
                }
            } else if (g <= 190) {
                if (b <= 24) {
                    return "Dark Yellow";
                } else if (b <= 80) {
                    return "Skin";
                } else if (b <= 190) {
                    return "Pale Pink";
                } else if (b <= 255) {
                    return "Light Purple";
                }
            } else if (g <= 255) {
                if (b <= 24) {
                    return "Yellow";
                } else if (b <= 80) {
                    return "Light Yellow";
                } else if (b <= 190) {
                    return "Gray";
                } else if (b <= 255) {
                    return "White";
                }
            }
        }
        return "Black";
    }
}
