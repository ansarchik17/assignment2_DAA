package assignment2_DAA.algorithms;

import assignment2_DAA.metrics.PerformanceTracker;

public class SelectionSort {

    public static void sort(int[] arr, PerformanceTracker tracker) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            tracker.incrementArrayAccesses();
            for (int j = i + 1; j < n; j++) {
                tracker.incrementComparisons();
                tracker.incrementArrayAccesses();
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int temp = arr[minIndex];
                tracker.incrementArrayAccesses();
                tracker.incrementSwaps();
                arr[minIndex] = arr[i];
                arr[i] = temp;
                tracker.incrementArrayAccesses();
            }
        }
    }
}

//A