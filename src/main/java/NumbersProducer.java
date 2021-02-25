import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumbersProducer {
    private static List<Integer> integerList;

    public NumbersProducer() {
        integerList = IntStream.range(1, 1000000)
                .boxed()
                .collect(Collectors.toList());
    }

    public static List<Integer> getIntegerList() {
        return integerList;
    }
}
