package ReadCNN;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Solution {
    public static void main(String[] args) {
        Thread reader = new Thread(new Reader()); //RSS reader thread
        Thread writer = new Thread(new Writer()); //RSS writer thread

        ScheduledExecutorService runReader = Executors.newSingleThreadScheduledExecutor();
        ScheduledExecutorService runWriter = Executors.newSingleThreadScheduledExecutor();

        runReader.scheduleAtFixedRate(reader,0,10, TimeUnit.SECONDS);
        runWriter.scheduleAtFixedRate(writer,0, 1, TimeUnit.SECONDS);
    }
}
