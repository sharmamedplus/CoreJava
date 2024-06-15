package com.java.threads.executorservice;

import java.util.concurrent.*;

public class ExecutorServiceTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //ExecutorService executorService = Executors.newFixedThreadPool(10);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i=0; i < 2;i++){
            executorService.submit(new FixedThreadPoolTest());
            Future<String> response = executorService.submit(new CallableFixedThreadPoolTest());
            if(response.isDone())
                 System.out.println(response.get());
        }
    }
}

class FixedThreadPoolTest implements Runnable{

    @Override
    public void run() {
        System.out.println("Fixed Thread Pool : "+Thread.currentThread().getName());
    }
}

class CallableFixedThreadPoolTest implements Callable<String> {

    @Override
    public String call() {
        System.out.println("Callable Fixed Thread Pool : "+Thread.currentThread().getName());
        return "Vijay";
    }
}