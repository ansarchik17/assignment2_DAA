package assignment2_DAA;

import assignment2_DAA.algorithms.SelectionSort;
import assignment2_DAA.metrics.PerformanceTracker;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SelectionSortTest {
    @Test
    public void testEmptyArray() {
        int[] arr = {};
        PerformanceTracker t = new PerformanceTracker();
        SelectionSort.sort(arr, t);
        assertArrayEquals(new int[]{}, arr);
    }
}
