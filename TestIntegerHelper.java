public class TestIntegerHelper
{
    public static void fillArray(TestInteger[] array)
    {
        for(int i = 0; i < array.length; i++)
        {
            array[i] = new TestInteger((int)((Math.random() * 1000000) + 1));
        }
    }

    public static void fillArrayLinearly(TestInteger[] array)
    {
        for(int i = 0; i < array.length; i++)
        {
            array[i] = new TestInteger(i);
        }
    }

    public static void fillArrayReverseLinearly(TestInteger[] array)
    {
        for(int i = array.length-1; i >= 0; i--)
        {
            array[array.length-i] = new TestInteger(i);
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
