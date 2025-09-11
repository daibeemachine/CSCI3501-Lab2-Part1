import java.util.Random;

public class HybridQuickSort {
    private static final int INSERTION_SORT_THRESHOLD = 10;

    public static void main(String[] args) {
        TestInteger[] array = new TestInteger[20];
        fillArray(array);
        System.out.println("Original array:");
        printTestIntegerArray(array);

        quickSort(array, new TestInteger(0), new TestInteger(array.length - 1));
        insertionSort(array); // Final pass to finish sorting

        System.out.println("\nSorted array:");
        printTestIntegerArray(array);
        System.out.println("\nTotal comparisons: " + TestInteger.getCounter());
    }

    private static void fillArray(TestInteger[] array) {
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = new TestInteger(rand.nextInt(100)); // Random values 0–99
        }
    }

    private static void printTestIntegerArray(TestInteger[] array) {
        for (TestInteger ti : array) {
            System.out.print(ti.value + " ");
        }
        System.out.println();
    }

    private static void quickSort(TestInteger[] array, TestInteger left, TestInteger right) {
        if (right.value - left.value + 1 <= INSERTION_SORT_THRESHOLD) {
            return; // Skip small subarrays
        }

        int pivotIndex = (left.value + right.value) / 2;
        swap(array, pivotIndex, right.value);
        TestInteger partition = partition(array, new TestInteger(left.value), new TestInteger(right.value - 1), array[right.value]);
        swap(array, partition.value, right.value);

        if (partition.compareTo(left) > 0) {
            quickSort(array, left, new TestInteger(partition.value - 1));
        }
        if (right.compareTo(partition) > 0) {
            quickSort(array, new TestInteger(partition.value + 1), right);
        }
    }

    private static TestInteger partition(TestInteger[] array, TestInteger left, TestInteger right, TestInteger pivot) {
        while (left.compareTo(right) <= 0) {
            while (array[left.value].compareTo(pivot) < 0) {
                left = new TestInteger(left.value + 1);
            }
            while (array[right.value].compareTo(pivot) > 0) {
                right = new TestInteger(right.value - 1);
            }
            if (left.compareTo(right) <= 0) {
                swap(array, left.value, right.value);
                left = new TestInteger(left.value + 1);
                right = new TestInteger(right.value - 1);
            }
        }
        return left;
    }

    private static void swap(TestInteger[] array, int i, int j) {
        TestInteger temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static void insertionSort(TestInteger[] array) {
        for (int i = 1; i < array.length; i++) {
            TestInteger key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j].compareTo(key) > 0) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }
}