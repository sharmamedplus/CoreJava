package com.java.threads.synchronization;

public class CounterTest extends Thread{

    private  Counter counter;
    public CounterTest(Counter counter){
        this.counter = counter;
    }

    public void run(){
        for(int i=0; i < 2000; i++)
            counter.increment();
    }
    public static void main(String[] args) throws InterruptedException {
        Counter counter1 = new Counter();
        CounterTest t1 = new CounterTest(counter1);
        CounterTest t2 = new CounterTest(counter1);

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println("Total counter : "+ counter1.getCounter()); // Total should be 4000
    }
}
