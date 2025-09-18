public class TestIntegerHelper
{
    public static void fillArray(TestInteger[] array, int range)
    {
        for(int i = 0; i < array.length; i++)
        {
            array[i] = new TestInteger((int)((Math.random() * range) + 1));
        }
    }

    public static void fillArrayLinearly(TestInteger[] array)
    {
        for(int i = 1; i <= array.length; i++)
        {
            array[i-1] = new TestInteger(i);
        }
    }

    public static void fillArrayReverseLinearly(TestInteger[] array)
    {
        for(int i = array.length-1; i >= 0; i--)
        {
            array[array.length-i-1] = new TestInteger(i);
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

    public static void fillArraySortedSequence(TestInteger[] array, int numSequences, int numElements, int numRange)
    {
        for(int i = 0; i < numSequences; i++)
        {
            int randomInteger = (int)(Math.random() * (numRange - numElements)) + 1;
            for(int j = 0; j < numElements; j++)
            {
                array[(i*numElements) + j] = new TestInteger((randomInteger - numElements) + j + 1);
            }
        }
    }
}
