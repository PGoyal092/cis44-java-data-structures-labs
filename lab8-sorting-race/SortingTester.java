import java.util.Arrays;
import java.util.Random;

public class SortingTester {

    public static void main(String[] args) {
        int[] sizes = {1000, 5000, 10000, 25000, 50000, 100000};

        System.out.println("--- The Sorting Race ---");

        for (int n : sizes) {
            System.out.println("\n--- Testing for array size n = " + n + " ---");

            int[] randomArray = generateRandomArray(n);
            int[] sortedArray = generateSortedArray(n);
            int[] reverseArray = generateReverseSortedArray(n);

            System.out.println("Average Case (Random):");
            runAndTimeAllSorts(randomArray);

            System.out.println("Best Case (Already Sorted):");
            runAndTimeAllSorts(sortedArray);

            System.out.println("Worst Case (Reverse Sorted):");
            runAndTimeAllSorts(reverseArray);
        }
    }

    public static void runAndTimeAllSorts(int[] baseArray) {
        // Selection Sort
        int[] arr1 = Arrays.copyOf(baseArray, baseArray.length);
        long start = System.nanoTime();
        SortingAlgorithms.selectionSort(arr1);
        long end = System.nanoTime();
        System.out.printf("  Selection Sort: %.3f ms%n", (end - start) / 1_000_000.0);

        // Insertion Sort
        int[] arr2 = Arrays.copyOf(baseArray, baseArray.length);
        start = System.nanoTime();
        SortingAlgorithms.insertionSort(arr2);
        end = System.nanoTime();
        System.out.printf("  Insertion Sort: %.3f ms%n", (end - start) / 1_000_000.0);

        // Merge Sort
        int[] arr3 = Arrays.copyOf(baseArray, baseArray.length);
        start = System.nanoTime();
        SortingAlgorithms.mergeSort(arr3);
        end = System.nanoTime();
        System.out.printf("  Merge Sort: %.3f ms%n", (end - start) / 1_000_000.0);
    }

    // Test data generators
    public static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = rand.nextInt(size * 10);
        return arr;
    }

    public static int[] generateSortedArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = i;
        return arr;
    }

    public static int[] generateReverseSortedArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = size - i;
        return arr;
    }
}