package CPS261ListPerformance;

public class Timer {
    private long startingTime; // milliseconds
    private long stoppingTime; // milliseconds;
    
    public void start()
    {
        startingTime = System.currentTimeMillis();
    }
    public void stop()
    {
        stoppingTime = System.currentTimeMillis();
    }
    
    public double time()
    {
        return (stoppingTime - startingTime)/1000.0;
    }

}