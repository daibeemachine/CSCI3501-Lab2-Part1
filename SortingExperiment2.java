public class SortingExperiment2
{
    public static void main(String[] args)
    {
      final int SIZE = 10000;
      final int RANGE = 1000000;
      TestInteger[] originalArray = new TestInteger[SIZE];
      TestIntegerHelper.fillArray(originalArray, RANGE);
      TestInteger[] quickSortArray = originalArray;
      TestInteger[] randomizedQuickSortArray = originalArray;
      TestInteger[] medianQuickSortArray = originalArray;
      TestInteger[] InsertionQuickSortArray = originalArray;
      printQuickSort(quickSortArray);
      printRandomizedQuickSort(randomizedQuickSortArray);
      printMedianOfThreeQuickSort(medianQuickSortArray);
      printQuickToInsertionSort(InsertionQuickSortArray);

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

    public static void printRandomizedQuickSort(TestInteger[] quickSortArray)
    {
        System.out.println("---Randomized Quicksort" + " ---");
        long stopWatch = System.nanoTime();
        RandomizedQuickSort.quickSort(quickSortArray);
        stopWatch = System.nanoTime() - stopWatch;
        System.out.println(
          stopWatch + " nanoseconds" +
          "\nCounter: " + TestInteger.getCounter()
        );
        TestInteger.resetCounter();
    }

    public static void printMedianOfThreeQuickSort(TestInteger[] quickSortArray)
    {
        System.out.println("---Median Quicksort" + " ---");
        long stopWatch = System.nanoTime();
        MedianOfThreeQuickSort.quickSort(quickSortArray);
        stopWatch = System.nanoTime() - stopWatch;
        System.out.println(
          stopWatch + " nanoseconds" +
          "\nCounter: " + TestInteger.getCounter()
        );
        TestInteger.resetCounter();
    }

    public static void printQuickToInsertionSort(TestInteger[] quickSortArray)
    {
        System.out.println("---Quicksort to Insertion sort" + " ---");
        long stopWatch = System.nanoTime();
        QuickToInsertionSort.quickSort(quickSortArray);
        stopWatch = System.nanoTime() - stopWatch;
        System.out.println(
          stopWatch + " nanoseconds" +
          "\nCounter: " + TestInteger.getCounter()
        );
        TestInteger.resetCounter();
    }
}
