import java.util.Arrays;

public class TimSort
{
    public static void main(String[] args)
    {
        TestInteger[] array = createArray(20);
        Arrays.sort(array);
        for(TestInteger value : array)
        {
            System.out.println(value.value);
        }
        System.out.println(new TestInteger(0).getCounter());
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
}
