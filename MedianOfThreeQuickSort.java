public class MedianOfThreeQuickSort {
    private static int ARRAY_SIZE = 2000;
    private static int k = 16;
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
        int middle = 0;
        int comparisonVal = high.compareTo(low);
        if((k >= comparisonVal+1) && (comparisonVal >= 3))
        {

            int one = low.value + (int)(Math.random()*(high.value - low.value + 1));
            int two = low.value + (int)(Math.random()*(high.value - low.value + 1));
            int three = low.value + (int)(Math.random()*(high.value - low.value + 1));
            middle = medianOfThree(one, two, three);
        }
        else
        {
            middle = low.value + (high.value - low.value)/2;
        }
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

    public static int medianOfThree(int one, int two, int three)
    {
        TestInteger[] array = new TestInteger[3];
        array[0] = new TestInteger(one);
        array[1] = new TestInteger(two);
        array[2] = new TestInteger(three);

        if(array[0].compareTo(array[1]) > 0)
        {
            swap(array, 0, 1);
        }
        if(array[1].compareTo(array[2]) > 0)
        {
            swap(array, 1, 2);
        }
        if(array[0].compareTo(array[2]) > 0)
        {
            swap(array, 0, 2);
        }

        return array[1].value;
    }
}
