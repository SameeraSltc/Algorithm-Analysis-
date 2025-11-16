package algorithms;

import java.util.Random;
import java.util.Arrays;

public class QuickSort {

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        int tmp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = tmp;
        return i + 1;
    }

    public static void main(String[] args) {
        int[] sizes = {100, 500, 1000};
        Random rnd = new Random(42);

        System.out.println("Algorithm: Quick Sort");
        System.out.println("Input Size | Time (ms)");
        System.out.println("-----------------------");

        for (int n : sizes) {
            int[] original = new int[n];
            for (int i = 0; i < n; i++) original[i] = rnd.nextInt(50_000);

            int[] copy = Arrays.copyOf(original, original.length);
            long start = System.nanoTime();
            quickSort(copy, 0, copy.length - 1);
            long end = System.nanoTime();

            double ms = (end - start) / 1_000_000.0;
            System.out.printf("%-10d | %.4f%n", n, ms);
        }
    }
}
