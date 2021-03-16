import java.util.concurrent.Callable;

public class MyCallable<I extends Number> implements Callable<Integer> {
    static int count = 0;


    @Override
    public Integer call() throws Exception {
        count = 0;
        for (int i = 1; i <= 5; i++) {
            System.out.println("Задача " + i + " выполнена");
            count++;
        }
        return count;
    }
}