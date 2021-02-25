import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class CustomForkJoin extends RecursiveTask<Integer> {
    private static final int THRESHOLD = 100000;
    private final List<Integer> integerList;

    public CustomForkJoin(List<Integer> integerList) {
        this.integerList = integerList;
    }

    @Override
    protected Integer compute() {
        if (integerList.size() > THRESHOLD) {
            return ForkJoinTask.invokeAll(createSubtasks()).stream()
                    .mapToInt(ForkJoinTask::join)
                    .sum();
        }
        return processing(integerList);
    }

    private Collection<CustomForkJoin> createSubtasks() {
        List<CustomForkJoin> splitTasks = new ArrayList<>();
        splitTasks.add(new CustomForkJoin(integerList.subList(0, integerList.size() / 2)));
        splitTasks.add(new CustomForkJoin(integerList.subList(integerList.size() / 2,
                integerList.size())));
        return splitTasks;
    }

    private Integer processing(List<Integer> list) {
        return list.stream()
                .reduce(0, Integer::sum);
    }
}
