import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException, TimeoutException, ExecutionException {
        ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        Callable<Integer> thread1 = new MyCallable<>();
        Callable<Integer> thread2 = new MyCallable<>();
        Callable<Integer> thread3 = new MyCallable<>();
        Callable<Integer> thread4 = new MyCallable<>();

        List<Callable<Integer>> list = new ArrayList<>();
        list.add(thread1);
        list.add(thread2);
        list.add(thread3);
        list.add(thread4);
        List<Future<Integer>> tasks = threadPool.invokeAll(list);
        System.out.println("выполнено задач: " + MyCallable.count);

        Integer task = threadPool.invokeAny(list);
        System.out.println("выполнено задач: " + MyCallable.count);

        threadPool.shutdown();
    }
}
