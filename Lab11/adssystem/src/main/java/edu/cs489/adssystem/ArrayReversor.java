package edu.cs489.adssystem;

public class ArrayReversor {
    public static int[] reverseArray(int[][] inputArray) {
        int[] flattenedArray = ArrayFlattenerService.flattenArray(inputArray);

        int n = flattenedArray.length;
        int[] reversedArray = new int[n];
        for (int i = 0; i < n; i++) {
            reversedArray[i] = flattenedArray[n - 1 - i];
        }

        return reversedArray;
    }
}
