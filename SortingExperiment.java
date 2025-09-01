import java.util.Arrays;
import java.util.Random;

public class SortingExperiment {
    
    // This is the main method to run the experiment 5 times
    public static void main(String[] args) {
        
        for (int i = 1; i <= 5; i++) {
            System.out.println("---Run #" + i + " ---");
            runExperiment();
            System.out.println();
            
        }
    }
    // logic for the single experiment run
    public static void runExperiment() {
        final int SIZE = 10000;
        final int RANGE = 1000000;

        // generating 10,000 random TestIntegers
        TestInteger[] originalArray = createArray(SIZE, RANGE);

        // Creating two copies of the array, one for TimSort and one for QuickSort
        TestInteger[] arrayForTimSort = new TestInteger[SIZE];
        TestInteger[] arrayForQuickSort = new TestInteger[SIZE];
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
}
