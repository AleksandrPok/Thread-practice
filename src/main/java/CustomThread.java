import org.apache.log4j.Logger;

public class CustomThread extends Thread {
    private static final Logger LOGGER = Logger.getLogger(CustomThread.class);
    private Counter counter;

    public CustomThread(Counter counter) {
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
