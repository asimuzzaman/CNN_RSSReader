import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/**
	Solution class
**/
public class Solution {
    public static void main(String[] args) {
        Thread reader = new Thread(new Reader()); //RSS reader thread which reads data from file and displays result
        Thread writer = new Thread(new Writer()); //RSS writer thread which writes data from feed to file

        //scheduler for specific time delay and interval
        ScheduledExecutorService runReader = Executors.newSingleThreadScheduledExecutor();
        ScheduledExecutorService runWriter = Executors.newSingleThreadScheduledExecutor();

        runWriter.scheduleAtFixedRate(writer,0, 15, TimeUnit.SECONDS);
        runReader.scheduleAtFixedRate(reader,0,20, TimeUnit.SECONDS);
    }
}
