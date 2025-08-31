public class TestInteger implements Comparable<TestInteger>
{
    public int value;
    private static long counter;

    public TestInteger(int value)
    {
       this.value = value;
    }

    public int compareTo(TestInteger other)
    {
        counter++;
        return this.value - other.value;
    }

    public long getCounter()
    {
        return counter;
    }

    public void resetCounter()
    {
        counter = 0;
    }
}
