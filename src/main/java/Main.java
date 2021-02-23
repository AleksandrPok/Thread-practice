public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        CustomThread customThread = new CustomThread(counter);
        CustomRunnable customRunnable = new CustomRunnable(counter);
        customThread.start();
        new Thread(customRunnable).start();
    }
}
