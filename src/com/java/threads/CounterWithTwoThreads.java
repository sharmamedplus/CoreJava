package com.java.threads;

import java.util.concurrent.atomic.AtomicInteger;

public class CounterWithTwoThreads {

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread t1 = new Thread(counter);
        Thread t2 = new Thread(counter);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(counter.getCounter());

    }
}

class Counter extends Thread{
    //AtomicInteger counter = new AtomicInteger();
    int counter = 0;
    public void run(){
        synchronized (this) {
            for (int i = 0; i < 10000; i++) {
                //counter.getAndIncrement();
                counter++;
            }
        }
    }

    public  int getCounter(){
        //return counter.get();
        return counter;
    }

}
