package algorithms;

import java.util.Random;
import java.util.Arrays;

public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    swapped = true;
                }
            }
            if (!swapped) break; // array already sorted
        }
    }

    public static void main(String[] args) {
        int[] sizes = {100, 500, 1000};
        Random rnd = new Random(42);

        System.out.println("Algorithm: Bubble Sort");
        System.out.println("Input Size | Time (ms)");
        System.out.println("-----------------------");

        for (int n : sizes) {
            int[] original = new int[n];
            for (int i = 0; i < n; i++) original[i] = rnd.nextInt(50_000);

            int[] copy = Arrays.copyOf(original, original.length);
            long start = System.nanoTime();
            bubbleSort(copy);
            long end = System.nanoTime();

            double ms = (end - start) / 1_000_000.0;
            System.out.printf("%-10d | %.4f%n", n, ms);
        }
    }
}
