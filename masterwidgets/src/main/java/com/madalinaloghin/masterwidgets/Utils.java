package com.madalinaloghin.masterwidgets;

import android.graphics.Color;
import android.support.annotation.ColorInt;

import java.util.Random;

/**
 * Created by dorunechifor.
 */
public class Utils {
    
    private static Random sRandomGenerator = new Random();
    
    private Utils() {
        //Utils class should not be instantiated
    }
    
    // Generates Random integer between these limits (both inclusive)
    public static int generateRandomIntegerBetween(final int lowerLimit, final int upperLimit) {
        return sRandomGenerator.nextInt(upperLimit + 1) + lowerLimit;
    }
    
    @ColorInt
    public static int generateRandomColor() {
        final int red = sRandomGenerator.nextInt(256);
        final int green = sRandomGenerator.nextInt(256);
        final int blue = sRandomGenerator.nextInt(256);
        return Color.rgb(red, green, blue);
    }
}
