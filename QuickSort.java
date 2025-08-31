public class QuickSort {
    static TestInteger[] array = createArray(20);
    public static void main(String[] args)
    {
        printTestIntegerArray(array);
        quickSort(array, 0, array.length-1);
        printTestIntegerArray(array);
    }

    public static void quickSort(TestInteger[] array, int left, int right)
    {
        int pivot = (left + right)/2;
        array = swap(array, pivot, right);
        int partition = partition(array, left, right-1, array[right]);
        array = swap(array, partition, right);
        if((partition-left) > 1)
        {
            quickSort(array, left, right-1);
        }
        if(right-partition > 1)
        {
            quickSort(array, partition+1, right);
        }
    }

    public static int partition(TestInteger[] array, int left, int right, TestInteger pivot)
    {
        while(left <= right)
        {
            while(array[left].compareTo(pivot) < 0)
            {
                left++;
            }
            while(right >= left && array[right].compareTo(pivot) >= 0)
            {
                right--;
            }
            if(right > left)
            {
                swap(array, left, right);
            }
        }
        return left;
    }

    public static TestInteger[] swap(TestInteger[] array, int left, int right)
    {
        TestInteger tempInt = array[right];
        array[right] = array[left];
        array[left] = tempInt;
        return array;
    }

    public static TestInteger[] createArray(int size)
    {
        TestInteger[] array = new TestInteger[size];
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
