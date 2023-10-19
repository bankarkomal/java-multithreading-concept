import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceExample {


    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // Create executor service using tread poolExecutor.
        // implementation of ExecutorService.
        ExecutorService executorService = new ThreadPoolExecutor(
                1,
                5,
                5000l,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<Runnable>());
        // Create callable task using lambda implementation,
        // of call method of callable interface.

        Callable<String> callableTask = () -> {
            System.out.println(Thread.currentThread().getName() + "call method called");
            TimeUnit.MILLISECONDS.sleep(5000);
            return "Task execution in call method completed";
        };
        // Submit single callable task to executor service that is returning a future
        Future<String> future = executorService.submit(callableTask);
        System.out.println(Thread.currentThread().getName() + "" + future.get());

        // create list of callable tasks

        List<Callable<String>> callableTaskList = new ArrayList<>();
        callableTaskList.add(callableTask);
        callableTaskList.add(callableTask);
        callableTaskList.add(callableTask);
        callableTaskList.add(callableTask);
        callableTaskList.add(callableTask);
        callableTaskList.add(callableTask);
        callableTaskList.add(callableTask);
        callableTaskList.add(callableTask);
        callableTaskList.add(callableTask);
        callableTaskList.add(callableTask);

        // submit the list of  callable task to invokeAny method that return a list
        // future represents a result of asynchronous tasks.
        List<Future<String>> futures = executorService.invokeAll(callableTaskList);
        futures.forEach(stringFuture -> {
            try {
                System.out.println(stringFuture.get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
                // shutdown the executorServices after completing  all task to reclaim memory.
            }
        });
        executorService.shutdown();
        System.out.println("Main thread is wating for 5s");

        TimeUnit.MILLISECONDS.sleep(5000);


        System.out.println(Thread.currentThread().getName() + "done execution");

    }

}
