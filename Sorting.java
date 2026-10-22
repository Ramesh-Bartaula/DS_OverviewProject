import java.util.Arrays;
import java.util.Scanner;

public class Sorting{

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        int[] originalArray = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        System.out.println("=== Sorting Algorithms Menu ===");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Quick Sort");
        System.out.println("3. Merge Sort");
        System.out.print("Choose an option (1-3): ");

        int choice = scanner.nextInt();
        int[] arr = originalArray.clone(); // Copy original array to avoid modifying it beforehand

        System.out.println("\nOriginal array: " + Arrays.toString(originalArray));

        switch (choice) {
            case 1:
                bubbleSort(arr);
                System.out.println("\nFinal Sorted Array (Bubble Sort): " + Arrays.toString(arr));
                break;
            case 2:
                System.out.println("\n--- Starting Quick Sort ---");
                quickSort(arr, 0, arr.length - 1);
                System.out.println("\nFinal Sorted Array (Quick Sort):  " + Arrays.toString(arr));
                break;
            case 3:
                System.out.println("\n--- Starting Merge Sort ---");
                mergeSort(arr, 0, arr.length - 1);
                System.out.println("\nFinal Sorted Array (Merge Sort):  " + Arrays.toString(arr));
                break;
            default:
                System.out.println("Invalid option! Please select 1, 2, or 3.");
        }

        scanner.close();
    }

    // 1. Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        int step = 1;
        System.out.println("\n--- Starting Bubble Sort ---");
        
        for (int i = 0; i < n - 1; i++) {
            System.out.println("\nPass " + (i + 1) + ":");
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                    
                    System.out.printf("  Step %2d: Swapped %d and %d -> %s\n", 
                            step++, arr[j + 1], arr[j], Arrays.toString(arr));
                }
            }
            if (!swapped) {
                System.out.println("  No swaps performed. Array is fully sorted!");
                break;
            }
        }
    }

    // 2. Quick Sort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    // Partition helper for Quick Sort
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        System.out.printf("\nPartitioning range [%d..%d] using pivot = %d\n", low, high, pivot);
        System.out.println("  Current subarray state: " + Arrays.toString(arr));

        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                System.out.printf("  Step: Swapped arr[%d]=%d and arr[%d]=%d -> %s\n", 
                        i, arr[i], j, arr[j], Arrays.toString(arr));
            }
        }

        // Place pivot in correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        System.out.printf("  Placed pivot %d at index %d -> %s\n", pivot, i + 1, Arrays.toString(arr));

        return i + 1;
    }

    // 3. Merge Sort
    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            
            System.out.printf("Splitting range [%d..%d] into [%d..%d] and [%d..%d]\n", 
                    l, r, l, m, m + 1, r);
            
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    // Merge helper for Merge Sort
    public static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        System.out.printf("\nMerging Left %s and Right %s into index range [%d..%d]\n", 
                Arrays.toString(L), Arrays.toString(R), l, r);

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }

        System.out.println("  Subarray state after merge: " + Arrays.toString(arr));
    }
}

