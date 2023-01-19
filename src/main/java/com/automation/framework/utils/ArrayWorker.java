package com.automation.framework.utils;


import java.util.Arrays;
import java.util.Objects;

public class ArrayWorker {

    public static boolean are2DArraysSame(String[][] array1, String[][] array2) {
        return Arrays.deepEquals(array1, array2);
    }

    public static String[] cleanArray(String[] array) {
        return Arrays.stream(array).filter(Objects::nonNull).toArray(String[]::new);
    }

    public static int[] convertStringArrayToArray(String stringArray) {
        stringArray = stringArray.replace("[", "").replace("]", "");
        return Arrays.stream(stringArray.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
