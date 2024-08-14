package com.java.threads.producer_consumer;

public class PrintEvenOddNumbersWithTwoThreads {
    int counter = 1;
    static int N = 10;
    public void printEvenNumber() throws InterruptedException {
        //System.out.println("printEvenNumber thread "+Thread.currentThread().getName());
        synchronized (this){
            //System.out.println("in synchronized even "+Thread.currentThread().getName());
            while(counter < N){
                if(counter%2 == 1){
                    //System.out.println("Waiting thread even"+Thread.currentThread().getName());
                    wait();
                }
                System.out.println(Thread.currentThread().getName() + ": "+ counter);
                counter ++;
                //System.out.println("Notifying thread even "+Thread.currentThread().getName());
                notify();
            }
        }
    }
    public void printOddNumber() throws InterruptedException {
        //System.out.println("printOddNumber thread "+Thread.currentThread().getName());
        synchronized (this){
            //System.out.println("in synchronized odd "+Thread.currentThread().getName());
            while(counter < N){
                if(counter%2 == 0){
                    //System.out.println("Waiting thread odd "+Thread.currentThread().getName());
                    wait();
                }
                System.out.println(Thread.currentThread().getName() + ": "+ counter);
                counter ++;
                //System.out.println("Notifying thread odd "+Thread.currentThread().getName());
                notify();
            }
        }
    }

    public static void main(String[] args) {
        PrintEvenOddNumbersWithTwoThreads p = new PrintEvenOddNumbersWithTwoThreads();
        Runnable run1 = () -> {
            try {
                p.printEvenNumber();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        Runnable run2 = () -> {
            try {
                p.printOddNumber();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };


        Thread t1 = new Thread(run1);
        t1.setName("Even");
        t1.start();
        Thread t2 = new Thread(run2);
        t2.setName("Odd");
        t2.start();
    }
}
