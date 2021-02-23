import org.apache.log4j.Logger;

public class CustomThread extends Thread {
    private static final Logger LOGGER = Logger.getLogger(CustomThread.class);
    private static final int MAX_COUNT = 100;
    private Counter counter;

    public CustomThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        while (counter.getCount() < MAX_COUNT) {
            int value = counter.getCount() + 1;
            counter.setCount(value);
            LOGGER.info(Thread.currentThread().getName() + " = " + counter.getCount());
        }
    }
}
