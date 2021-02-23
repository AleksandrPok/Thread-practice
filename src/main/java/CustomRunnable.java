import org.apache.log4j.Logger;

public class CustomRunnable implements Runnable {
    private static final Logger LOGGER = Logger.getLogger(CustomRunnable.class);
    private Counter counter;

    public CustomRunnable(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        while (counter.getCount() < 100) {
            counter.setCount(counter.getCount() + 1);
            LOGGER.info(Thread.currentThread().getName() + " = " + counter.getCount());
        }
    }
}
