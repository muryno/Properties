package com.muryno.listedkey.AuthAtivities;

import android.graphics.Color;

import com.muryno.listedkey.R;

/**
 * Created by muraino harbeola on 8/28/2018.
 */

public enum PasswordStrength {

    WEAK(R.string.password_strength_weak, Color.RED),
    MEDIUM(R.string.password_strength_medium, Color.argb(255, 220, 185, 0)),
    STRONG(R.string.password_strength_strong, Color.YELLOW),
    VERY_STRONG(R.string.password_strength_very_strong, Color.GREEN);

    //--------REQUIREMENTS--------
    static int REQUIRED_LENGTH = 7;
    static int MAXIMUM_LENGTH = 14;
    static boolean REQUIRE_SPECIAL_CHARACTERS = true;
    static boolean REQUIRE_DIGITS = true;
    static boolean REQUIRE_LOWER_CASE = true;
    static boolean REQUIRE_UPPER_CASE = false;

    int resId;
    int color;

    PasswordStrength(int resId, int color) {
        this.resId = resId;
        this.color = color;
    }

    public CharSequence getText(android.content.Context ctx) {
        return ctx.getText(resId);
    }

    public int getColor() {
        return color;
    }

    public static PasswordStrength calculateStrength(String password) {
        int currentScore = 0;
        boolean sawUpper = false;
        boolean sawLower = false;
        boolean sawDigit = false;
        boolean sawSpecial = false;


        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);

            if (!sawSpecial && !Character.isLetterOrDigit(c)) {
                currentScore += 1;
                sawSpecial = true;
            } else {
                if (!sawDigit && Character.isDigit(c)) {
                    currentScore += 1;
                    sawDigit = true;
                } else {
                    if (!sawUpper || !sawLower) {
                        if (Character.isUpperCase(c))
                            sawUpper = true;
                        else
                            sawLower = true;
                        if (sawUpper && sawLower)
                            currentScore += 1;
                    }
                }
            }

        }

        if (password.length() > REQUIRED_LENGTH) {
            if ((REQUIRE_SPECIAL_CHARACTERS && !sawSpecial)
                    || (REQUIRE_UPPER_CASE && !sawUpper)
                    || (REQUIRE_LOWER_CASE && !sawLower)
                    || (REQUIRE_DIGITS && !sawDigit)) {
                currentScore = 1;
            }else{
                currentScore = 2;
                if (password.length() > MAXIMUM_LENGTH) {
                    currentScore = 3;
                }
            }
        }else{
            currentScore = 0;
        }

        switch (currentScore) {
            case 0:
                return WEAK;
            case 1:
                return MEDIUM;
            case 2:
                return STRONG;
            case 3:
                return VERY_STRONG;
            default:
        }

        return VERY_STRONG;
    }

}
