public class TestInteger implements Comparable<TestInteger>
{
    public int value;
    private static long counter;

    public TestInteger(int value)
    {
       this.value = value;
    }

    @Override
    public int compareTo(TestInteger other)
    {
        counter++;
        return this.value - other.value;
    }

    public static long getCounter()
    {
        return counter;
    }

    public static void resetCounter()
    {
        counter = 0;
    }
}
