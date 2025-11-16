package algorithms;

import java.util.Arrays;
import java.util.Random;

public class BinarySearch {

    public static int binarySearch(int[] arr, int target) {
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) lo = mid + 1;
            else hi = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] sizes = {100, 500, 1000};
        Random rnd = new Random(42);

        System.out.println("Algorithm: Binary Search (array sorted first)");
        System.out.println("Input Size | Time (ms)");
        System.out.println("-----------------------");

        for (int n : sizes) {
            int[] data = new int[n];
            for (int i = 0; i < n; i++) data[i] = rnd.nextInt(10_000);

            // sort the array first (not timed as part of the search measurement)
            Arrays.sort(data);

            int target = data[n - 1]; // pick an existing element
            long start = System.nanoTime();
            int idx = binarySearch(data, target);
            long end = System.nanoTime();
            double ms = (end - start) / 1_000_000.0;

            System.out.printf("%-10d | %.6f (found at %d)%n", n, ms, idx);
        }
    }
}
