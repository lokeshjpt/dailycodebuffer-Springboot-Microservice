package practice;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.IntStream;


public class ThreadPoolDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //completableFuture();
        forkJoinPool();
        System.out.println("End of main");
    }

    private static void parallelStream() {
        System.out.println("--------------------------------Parallel Stream--------------------------------------------------");
        IntStream.range(1, 10).parallel().forEach(x -> System.out.println(x + " -> "+ Thread.currentThread().getName()));
    }

    private static void forkJoinPool() {
        System.out.println("--------------------------------ForkJoinPool-------------------------------------------------");
        ForkJoinPool forkJoinPool = new ForkJoinPool(2);
        forkJoinPool.submit(()-> {
            IntStream.range(1, 10).parallel().forEach(x -> System.out.println(x + " -> "+ Thread.currentThread().getName()));
        }).join();
        forkJoinPool.shutdown();
    }

    private static void threadPoolExecutor() {
        System.out.println("----------------------------------ThreadPoolExecutors------------------------------------------------");
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor)Executors.newFixedThreadPool(4);
        IntStream.range(1, 100).forEach(x -> {
            threadPoolExecutor.execute(() -> System.out.println(x + " -- "+ Thread.currentThread().getName()));
        });
        threadPoolExecutor.shutdown();
    }

    private static void completableFuture() {
        System.out.println("----------------------------------CompletableFuture------------------------------------------------");
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor)Executors.newFixedThreadPool(2);
        List<CompletableFuture> futures = new ArrayList<>();
        IntStream.range(1, 10).forEach(x -> {
            CompletableFuture<String> future = CompletableFuture
            .supplyAsync(() -> x + " *** " + Thread.currentThread().getName(), threadPoolExecutor);
            futures.add(future);
        });
        futures.forEach(f -> {
            try {
                System.out.println(f.get(5, TimeUnit.SECONDS));
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (ExecutionException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (TimeoutException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });

        List<CompletableFuture> completableFutures = new ArrayList<>();
        IntStream.range(1, 1000).forEach(x -> {
            CompletableFuture<Void> future = CompletableFuture
            .runAsync(() -> System.out.println(x + " ############# " + Thread.currentThread().getName()), threadPoolExecutor);
            completableFutures.add(future);
        });
        completableFutures.forEach(f -> f.join());
        threadPoolExecutor.shutdown();
    }
}
