public class QuickToInsertionSort {

  private static int k = 1;
  private static int ARRAY_SIZE = 16;
  public static void main(String[] args)
    {
        TestInteger[] array = new TestInteger[ARRAY_SIZE];
        fillArray(array, ARRAY_SIZE);
        printTestIntegerArray(array);
        quickSort(array);
        printTestIntegerArray(array);
        System.out.println("\nCounter: " + TestInteger.getCounter());
    }
    public static void quickSort(TestInteger[] array)
    {
        quickSort(array, new TestInteger(0), new TestInteger(array.length-1));
    }
    public static void quickSort(TestInteger[] array, TestInteger low, TestInteger high)
    {
        if((low.compareTo(high) >= (-k + 1)) || (low.compareTo(new TestInteger(0)) < 0))
        {
            insertionSort(array, low, high);
            return;
        }
        else
        {
            TestInteger partition = partition(array, low, high);
            quickSort(array, low, new TestInteger(partition.value-1));
            quickSort(array, new TestInteger(partition.value+1), high);
        }
    }

    public static TestInteger partition(TestInteger[] array, TestInteger low, TestInteger high)
    {
        int middle = low.value + (high.value - low.value)/2;
        swap(array, middle, high.value);
        TestInteger pivot = array[high.value];
        int i = low.value - 1;
        for (int j = low.value; j < high.value; j++) {
            if (array[j].compareTo(pivot) <= 0) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high.value);
        return new TestInteger(i + 1);
    }

    public static void swap(TestInteger[] array, int left, int right)
    {
        TestInteger tempInt = array[right];
        array[right] = array[left];
        array[left] = tempInt;
    }

    public static void fillArray(TestInteger[] array, int size)
    {
        for(int i = 0; i < array.length; i++)
        {
            array[i] = new TestInteger((int)((Math.random() * 1000000) + 1));
        }
    }

    public static void printTestIntegerArray(TestInteger[] array)
    {
        System.out.println("\n");
        for(TestInteger value : array)
        {
            System.out.print(value.value + " ");
        }
    }

    public static void insertionSort(TestInteger[] array, TestInteger low, TestInteger high)
    {
        if(array.length >= 2)
        {
            for(int i = low.value+1; i <= high.value; i++)
            {
                TestInteger key = array[i];
                TestInteger j = new TestInteger(i - 1);
                while ((j.compareTo(low) >= 0) && ((array[j.value]).compareTo(key) > 0))
                {
                    array[j.value + 1] = array[j.value];
                    j = new TestInteger(j.value-1);
                }
                array[j.value+1] = key;
            }
        }
    }
}
