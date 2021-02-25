import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import org.apache.commons.collections4.ListUtils;

public class CustomExecutor {
    private static final int THREADS = 10;
    private final List<Integer> list;

    public CustomExecutor(List<Integer> list) {
        this.list = list;
    }

    public int getSum() {
        ExecutorService executorService = Executors.newFixedThreadPool(THREADS);
        List<List<Integer>> listList = ListUtils.partition(list, list.size() / THREADS);
        List<Callable<Integer>> callables = listList.stream()
                .map(SumCalculator::new)
                .collect(Collectors.toList());
        try {
            List<Future<Integer>> futures = executorService.invokeAll(callables);
            int result = 0;
            for (Future<Integer> future : futures) {
                result += future.get();
            }
            executorService.shutdown();
            return result;
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException("Can't complete adding", e);
        }
    }
}
