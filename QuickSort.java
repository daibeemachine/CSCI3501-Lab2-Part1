public class QuickSort {
    public static void main(String[] args)
    {
        TestInteger[] array = new TestInteger[16];
        fillArray(array, 16);
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
        if((low.compareTo(high) >= 0) || (low.compareTo(new TestInteger(0)) < 0))
        {
            return;
        }
        TestInteger partition = partition(array, low, high);
        quickSort(array, low, new TestInteger(partition.value-1));
        quickSort(array, new TestInteger(partition.value+1), high);


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
}
