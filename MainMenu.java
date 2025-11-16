package algorithms;

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class MainMenu {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== Algorithm Analyzer Main Menu =====");
            System.out.println("1. Linear Search");
            System.out.println("2. Binary Search");
            System.out.println("3. Bubble Sort");
            System.out.println("4. Quick Sort");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    runLinearSearch();
                    break;
                case 2:
                    runBinarySearch();
                    break;
                case 3:
                    runBubbleSort();
                    break;
                case 4:
                    runQuickSort();
                    break;
                case 5:
                    System.out.println("Exiting program. Thank you!");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // ----------------------------------------------------------
    // Linear Search
    // ----------------------------------------------------------
    public static void runLinearSearch() {
        System.out.println("\n--- Running Linear Search ---");

        int[] sizes = {100, 500, 1000};
        Random rnd = new Random(42);

        System.out.println("Input Size | Time (ms)");
        System.out.println("--------------------------");

        for (int n : sizes) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = rnd.nextInt(10000);

            int target = arr[n - 1];

            long start = System.nanoTime();
            LinearSearch.linearSearch(arr, target);
            long end = System.nanoTime();

            double ms = (end - start) / 1_000_000.0;
            System.out.printf("%-10d | %.5f\n", n, ms);
        }
    }

    // ----------------------------------------------------------
    // Binary Search
    // ----------------------------------------------------------
    public static void runBinarySearch() {
        System.out.println("\n--- Running Binary Search ---");

        int[] sizes = {100, 500, 1000};
        Random rnd = new Random(42);

        System.out.println("Input Size | Time (ms)");
        System.out.println("--------------------------");

        for (int n : sizes) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = rnd.nextInt(10000);

            Arrays.sort(arr);
            int target = arr[n - 1];

            long start = System.nanoTime();
            BinarySearch.binarySearch(arr, target);
            long end = System.nanoTime();

            double ms = (end - start) / 1_000_000.0;
            System.out.printf("%-10d | %.6f\n", n, ms);
        }
    }

    // ----------------------------------------------------------
    // Bubble Sort
    // ----------------------------------------------------------
    public static void runBubbleSort() {
        System.out.println("\n--- Running Bubble Sort ---");

        int[] sizes = {100, 500, 1000};
        Random rnd = new Random(42);

        System.out.println("Input Size | Time (ms)");
        System.out.println("--------------------------");

        for (int n : sizes) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = rnd.nextInt(50000);

            int[] copy = Arrays.copyOf(arr, arr.length);

            long start = System.nanoTime();
            BubbleSort.bubbleSort(copy);
            long end = System.nanoTime();

            double ms = (end - start) / 1_000_000.0;
            System.out.printf("%-10d | %.4f\n", n, ms);
        }
    }

    // ----------------------------------------------------------
    // Quick Sort
    // ----------------------------------------------------------
    public static void runQuickSort() {
        System.out.println("\n--- Running Quick Sort ---");

        int[] sizes = {100, 500, 1000};
        Random rnd = new Random(42);

        System.out.println("Input Size | Time (ms)");
        System.out.println("--------------------------");

        for (int n : sizes) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = rnd.nextInt(50000);

            int[] copy = Arrays.copyOf(arr, arr.length);

            long start = System.nanoTime();
            QuickSort.quickSort(copy, 0, copy.length - 1);
            long end = System.nanoTime();

            double ms = (end - start) / 1_000_000.0;
            System.out.printf("%-10d | %.4f\n", n, ms);
        }
    }
}
