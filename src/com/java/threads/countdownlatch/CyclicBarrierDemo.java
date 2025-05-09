package com.java.threads.countdownlatch;

import java.util.concurrent.*;

public class CyclicBarrierDemo {

   /*
    CyclicBarriers are used in programs in which we have a fixed number of threads that must wait
    for each other to reach a common point before continuing execution.

    The constructor for a CyclicBarrier is simple. It takes a single integer that denotes the number
    of threads that need to call the await() method on the barrier instance to signify reaching the
    common execution point.

    There’s an operation that a fixed number of threads perform and store the corresponding results in a list.
    When all threads finish performing their action, one of them (typically the last one that trips the barrier)
    starts processing the data that was fetched by each of these.

   */

    public static void main(String[] args) {
        int numberOfService = 3;
        CyclicBarrier barrier = new CyclicBarrier(numberOfService);
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfService);
        executorService.submit(new Task(barrier));
        executorService.submit(new Task(barrier));
        executorService.submit(new Task(barrier));
        System.out.println("main");
        executorService.shutdown();
    }
}

class Task implements Callable<String> {

    private final CyclicBarrier barrier;

    public Task(CyclicBarrier barrier){
        this.barrier = barrier;
    }

    @Override
    public String call() throws BrokenBarrierException, InterruptedException {
        System.out.println(Thread.currentThread().getName() + " Task completed");
        barrier.await();
        return "OK";
    }
}
