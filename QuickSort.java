public class QuickSort {
    public static int partition(TestInteger[] array, int left, int right, int pivot)
    {
        while(left <= right)
        {
            while(array[left].compareTo(array[pivot]) < 0) { left++; }
            while((right >= left) && (array[right].compareTo(array[pivot]) >= 0)) { right--; }
            if(right > left)
            {
                TestInteger temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }
        return left;
        //return 1;
    }
}
