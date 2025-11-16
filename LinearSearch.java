package algorithms;

import java.util.Random;

public class LinearSearch {
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] sizes = {100, 500, 1000};
        Random rnd = new Random(42); // fixed seed for reproducibility

        System.out.println("Algorithm: Linear Search");
        System.out.println("Input Size | Time (ms)");
        System.out.println("-----------------------");

        for (int n : sizes) {
            int[] data = new int[n];
            for (int i = 0; i < n; i++) data[i] = rnd.nextInt(10_000);

            int target = data[n - 1]; // choose an element that exists (worst-case-ish)
            long start = System.nanoTime();
            int idx = linearSearch(data, target);
            long end = System.nanoTime();
            double ms = (end - start) / 1_000_000.0;

            System.out.printf("%-10d | %.4f (found at %d)%n", n, ms, idx);
        }
    }
}
