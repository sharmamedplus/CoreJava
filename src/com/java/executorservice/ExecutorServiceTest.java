package com.java.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceTest {
    public static void main(String[] args) {
        //ExecutorService executorService = Executors.newFixedThreadPool(10);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i=0; i < 100;i++){
            executorService.submit(new FixedThreadPoolTest());
        }
    }
}

class FixedThreadPoolTest implements Runnable{

    @Override
    public void run() {
        System.out.println("Fixed Thread Pool : "+Thread.currentThread().getName());
    }
}