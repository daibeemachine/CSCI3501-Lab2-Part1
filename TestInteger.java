public class TestInteger implements Comparable<TestInteger>
{
    private int value;
    private static long counter;

    public TestInteger(int value)
    {
       this.value = value; 
    }

    public int compareTo(TestInteger other)
    {
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
