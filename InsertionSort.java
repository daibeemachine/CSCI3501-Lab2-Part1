public class InsertionSort {
  private static int ARRAY_SIZE = 20;
  public static void main(String[] args)
  {
      TestInteger[] array = new TestInteger[ARRAY_SIZE];
      fillArray(array, ARRAY_SIZE);
      printTestIntegerArray(array);
      insertionSort(array);
      printTestIntegerArray(array);
  }

  public static void insertionSort(TestInteger[] array)
  {
      if(array.length >= 2)
      {
          for(int i = 1; i < array.length; i++)
          {
              TestInteger key = array[i];
              TestInteger j = new TestInteger(i - 1);
              while ((j.compareTo(new TestInteger(0)) >= 0) && ((array[j.value]).compareTo(key) > 0))
              {
                  array[j.value + 1] = array[j.value];
                  j = new TestInteger(j.value-1);
              }
              array[j.value+1] = key;
          }
      }
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
