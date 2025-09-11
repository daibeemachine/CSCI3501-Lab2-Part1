import java.util.Arrays;
import java.util.Random;

public class SortingExperiment {
    // This is the main method to run the experiment 5 times
    public static void main(String[] args) {
        final int SIZE = 10000;
        final int RANGE = 1000000;
        TestInteger[] originalArray = createArray(SIZE, RANGE);
        TestInteger[] quickSortArray = originalArray;
        TestInteger[] timSortArray = originalArray;
        System.out.println("----------Experiment 1----------");
        for (int i = 1; i <= 5; i++) {
            System.out.println("---Run #" + i + " ---\n");
            printQuickSort(quickSortArray);
            System.out.println();
            printTimSort(timSortArray);
            System.out.println();
        }
        System.out.println("----------END----------");

        System.out.println("----------Experiment 2----------");
        for(int i = 1; i < 10000; i++)
        {
            originalArray[i-1].value = i;
        }
        quickSortArray = originalArray;
        timSortArray = originalArray;
        for (int i = 1; i <= 5; i++) {
            System.out.println("---Run #" + i + " ---\n");
            printQuickSort(quickSortArray);
            System.out.println();
            printTimSort(timSortArray);
            System.out.println();
        }
        System.out.println("----------END----------");

        System.out.println("----------Experiment 3----------");
        //Experiment 3
        originalArray = generateSortedSequence(10, 1000, RANGE);
        quickSortArray = originalArray;
        timSortArray = originalArray;
        for (int i = 1; i <= 5; i++) {
            System.out.println("---Run #" + i + " ---\n");
            printQuickSort(quickSortArray);
            System.out.println();
            printTimSort(timSortArray);
            System.out.println();
        }
        System.out.println("----------END----------");

        System.out.println("----------Experiment 4----------");
        originalArray = generateReverseSortedSequence(10, 1000, RANGE);
        quickSortArray = originalArray;
        timSortArray = originalArray;
        for (int i = 1; i <= 5; i++) {
            System.out.println("---Run #" + i + " ---\n");
            printQuickSort(quickSortArray);
            System.out.println();
            printTimSort(timSortArray);
            System.out.println();
        }
        System.out.println("----------END----------");
    }

    // Helper Method to create an array of random TestIntegers ---
    public static TestInteger[] createArray(int size, int range) {
        Random random = new Random();
        TestInteger[] array = new TestInteger[size];
        for(int i = 0; i < array.length; i++) {
            array[i] = new TestInteger(random.nextInt(range) + 1);
        }
        return array;
    }

    public static void printQuickSort(TestInteger[] quickSortArray)
    {
        System.out.println("---Quicksort" + " ---");
        long stopWatch = System.nanoTime();
        QuickSort.quickSort(quickSortArray);
        stopWatch = System.nanoTime() - stopWatch;
        System.out.println(
          stopWatch + " nanoseconds" +
          "\nCounter: " + TestInteger.getCounter()
        );
        TestInteger.resetCounter();
    }

    public static void printTimSort(TestInteger[] timSortArray)
    {
        System.out.println("---Timsort" + " ---");
        long stopWatch = System.nanoTime();
        Arrays.sort(timSortArray);
        stopWatch = System.nanoTime() - stopWatch;
        System.out.println(
          stopWatch + " nanoseconds" +
          "\nCounter: " + TestInteger.getCounter()
        );
        TestInteger.resetCounter();
    }

    public static TestInteger[] generateSortedSequence(int numSequences, int numElements, int numRange)
    {
        TestInteger[] array = new TestInteger[numSequences*numElements];
        for(int i = 0; i < numSequences; i++)
        {
            int randomInteger = (int)(Math.random() * (numRange - numElements)) + 1;
            for(int j = 0; j < numElements; j++)
            {
                array[(i*numElements) + j] = new TestInteger((randomInteger - numElements) + j + 1);
            }
        }
        return array;
    }

    public static TestInteger[] generateReverseSortedSequence(int numSequences, int numElements, int numRange)
    {
        TestInteger[] array = new TestInteger[numSequences*numElements];
        for(int i = 0; i < numSequences; i++)
        {
            int randomInteger = (int)(Math.random() * (numRange - numElements)) + 1;
            for(int j = 0; j < numElements; j++)
            {
                array[(i*numElements) + j] = new TestInteger(randomInteger + numElements - j + 1);
            }
        }
        return array;
    }
}

/*
    // logic for the single experiment run
    public static void runExperiment(TestInteger[] quickSortArray, TestInteger[] mergeSortArray) {

        printQuickSort(quickSortArray);
        TestInteger[] arrayForTimSort = new TestInteger[SIZE];
        System.arraycopy(originalArray, 0, arrayForTimSort, 0, SIZE);
        System.arraycopy(originalArray, 0, arrayForQuickSort, 0, SIZE);

        // Experiment 1: TimSort
        TestInteger.resetCounter(); // Reset Counter
        long startTimeTimSort = System.nanoTime();
        Arrays.sort(arrayForTimSort);
        long endTimeTimSort = System.nanoTime();
        long comparisonsTimSort = TestInteger.getCounter();
        long durationTimSort = endTimeTimSort - startTimeTimSort;

        System.out.println("TimSort (Arrays.sort) complete.");
        System.out.println("Time taken:" + durationTimSort + "nanoseconds");
        System.out.println("Number of comparisons: " + comparisonsTimSort);
        System.out.println();
*/

        //for(int i = 0; i < array.length; i++) {