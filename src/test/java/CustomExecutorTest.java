import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomExecutorTest {
    private static List<Integer> list;
    private static CustomExecutor customExecutor;

    @BeforeAll
    public static void setUp() {
        list = new NumbersProducer().getIntegerList();
        customExecutor = new CustomExecutor(list);
    }

    @Test
    public void getSum_Ok() {
        Integer expected = NumbersProducer.getIntegerList().stream()
                .reduce(Integer::sum).get();
        Integer actual = customExecutor.getSum();
        assertEquals(expected, actual, "Expected: " + expected + "Actual: " + actual);
    }
}