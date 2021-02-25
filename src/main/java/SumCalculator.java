import java.util.List;
import java.util.concurrent.Callable;

public class SumCalculator implements Callable<Integer> {
    private final List<Integer> integerList;

    public SumCalculator(List<Integer> list) {
        this.integerList = list;
    }

    @Override
    public Integer call() throws Exception {
        return integerList.stream()
                .reduce(0, Integer::sum);
    }
}
