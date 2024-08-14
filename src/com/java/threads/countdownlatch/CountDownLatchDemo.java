package com.java.threads.countdownlatch;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchDemo {

    /*
    using a CountDownLatch we can cause a thread to block until other threads have completed a given task.

    Simply put, a CountDownLatch has a counter field, which you can decrement as we require. We can then
     use it to block a calling thread until it’s been counted down to zero.

    If we were doing some parallel processing, we could instantiate the CountDownLatch with the same value for the
    counter as a number of threads we want to work across. Then, we could just call countdown() after each thread finishes,
    guaranteeing that a dependent thread calling await() will block until the worker threads are finished.

    */

    public static void main(String[] args) throws InterruptedException {

        int numberOfServices = 3;
        CountDownLatch latch = new CountDownLatch(numberOfServices);
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfServices);
        executorService.submit(new DependentService(latch));
        executorService.submit(new DependentService(latch));
        executorService.submit(new DependentService(latch));
        latch.await();
        System.out.println("All services done");
        executorService.shutdown();
    }
}

class DependentService implements Callable<String> {

    private final CountDownLatch latch;

    public DependentService(CountDownLatch latch){
        this.latch = latch;
    }

    @Override
    public String call() throws Exception {
        try {
            System.out.println(Thread.currentThread().getName() + " Completed");
            return "OK";
        }finally {
            latch.countDown();  // Decreases the count of CountDownLatch
        }
    }
}
