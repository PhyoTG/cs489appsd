package edu.cs489.adssystem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ArrayFlattenerTest {
    @Test
    public void testFlattenArrayLegitInput() {
        int[][] inputArray = {{1, 3}, {0}, {4, 5, 9}};
        int[] expectedOutput = {1, 3, 0, 4, 5, 9};
        assertArrayEquals(expectedOutput, ArrayFlattener.flattenArray(inputArray));
    }

    @Test
    public void testFlattenArrayNullInput() {
        int[][] inputArray = null;
        assertNull(ArrayFlattener.flattenArray(inputArray));
    }
}
