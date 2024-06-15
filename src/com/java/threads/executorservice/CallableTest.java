package com.java.threads.executorservice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableTest implements Callable<String> {

    @Override
    public String call() throws Exception {
        return Thread.currentThread().getName();
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        List<Future> results = new ArrayList<>();
        for(int i=0; i<20;i++){
            Future<String> future = executorService.submit(new CallableTest());
            results.add(future);
        }

        results.forEach(futureResult -> {
            try {
                System.out.println(futureResult.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
        executorService.shutdown();
    }
}
