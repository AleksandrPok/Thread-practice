import org.apache.log4j.Logger;

public class CustomRunnable implements Runnable {
    private static final Logger LOGGER = Logger.getLogger(CustomRunnable.class);
    private static final int MAX_COUNT = 100;
    private Counter counter;

    public CustomRunnable(Counter counter) {
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
