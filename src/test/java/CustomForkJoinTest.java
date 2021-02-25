import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomForkJoinTest {
    private static List<Integer> list;
    private static CustomForkJoin customForkJoin;

    @BeforeAll
    public static void setUp() {
        list = new NumbersProducer().getIntegerList();
        customForkJoin = new CustomForkJoin(list);
    }

    @Test
    public void compute_Ok() {
        Integer expected = NumbersProducer.getIntegerList().stream()
                .reduce(Integer::sum).get();
        Integer actual = customForkJoin.compute();
        assertEquals(expected, actual, "Expected: " + expected + "Actual: " + actual);
    }
}