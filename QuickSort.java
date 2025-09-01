public class QuickSort {
    static TestInteger[] array = createArray(20);
    public static void main(String[] args)
    {
        printTestIntegerArray(array);
        quickSort(array, new TestInteger(0), new TestInteger(array.length-1));
        printTestIntegerArray(array);
        System.out.println("\nCounter: " + array[0].getCounter());
    }

    public static void quickSort(TestInteger[] array, TestInteger left, TestInteger right)
    {
        int pivot = (left.value + right.value)/2;
        swap(array, pivot, right.value);
        TestInteger partition = partition(array, new TestInteger(left.value), new TestInteger(right.value-1), array[right.value]);
        swap(array, partition.value, right.value);
        if((partition.compareTo(left)) > 1)
        {
            quickSort(array, left, new TestInteger(right.value-1));
        }
        if(right.compareTo(partition) > 1)
        {
            quickSort(array, new TestInteger(partition.value+1), right);
        }
    }

    public static TestInteger partition(TestInteger[] array, TestInteger left, TestInteger right, TestInteger pivot)
    {
        while(left.compareTo(right) <= 0)
        {
            while(array[left.value].compareTo(pivot) < 0)
            {
                left.value++;
            }
            while((right.compareTo(left) >= 0) && array[right.value].compareTo(pivot) >= 0)
            {
                right.value--;
            }
            if(right.compareTo(left) > 0)
            {
                swap(array, left.value, right.value);
            }
        }
        return left;
    }

    public static void swap(TestInteger[] array, int left, int right)
    {
        TestInteger tempInt = array[right];
        array[right] = array[left];
        array[left] = tempInt;
    }

    public static TestInteger[] createArray(int size)
    {
        array = new TestInteger[size];
        for(int i = 0; i < array.length; i++)
        {
            array[i] = new TestInteger((int)((Math.random() * 1000000) + 1));
        }
        return array;
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
