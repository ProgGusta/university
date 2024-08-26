import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class sort_time_measurement {

    public static void generateList(int[] arr) {
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(10000);
        }
    }

    public static double measureSortTime(Runnable sortFunction) {
        long startTime = System.nanoTime();
        sortFunction.run();
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1e9;
    }

    public static void main(String[] args) throws IOException {
        int[] listSizes = {10, 100, 1000, 10000, 100000};
        FileWriter results = new FileWriter("java_sort_times.csv");

        for (int size : listSizes) {
            int[] arr = new int[size];
            generateList(arr);

            results.write(size + ",");

            // Measure Insertion Sort time
            final int[] copy1 = Arrays.copyOf(arr, arr.length);
            double time = measureSortTime(() -> InsertionSort.insertionSort(copy1));
            results.write(time + ",");

            // Measure Bubble Sort time
            final int[] copy2 = Arrays.copyOf(arr, arr.length);
            time = measureSortTime(() -> BubbleSort.bubbleSort(copy2));
            results.write(time + ",");

            // Measure Merge Sort time
            final int[] copy3 = Arrays.copyOf(arr, arr.length);
            time = measureSortTime(() -> MergeSort.mergeSort(copy3, 0, copy3.length - 1));
            results.write(time + ",");

            // Measure Quick Sort time
            final int[] copy4 = Arrays.copyOf(arr, arr.length);
            time = measureSortTime(() -> QuickSort.quickSort(copy4, 0, copy4.length - 1));
            results.write(time + "\n");
        }

        results.close();
    }
}
