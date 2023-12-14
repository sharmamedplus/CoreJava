package com.java.threads;

public class PrintWithThreeThreadsSequentially extends Thread{

    private String threadName ;
    PrintWithThreeThreadsSequentially(String threadName){
        this.threadName = threadName;
    }

    @Override
    public void run() {
        for(int i = 1; i <= 5; i++){
            System.out.println(threadName + ": "+ i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        PrintWithThreeThreadsSequentially t1 = new PrintWithThreeThreadsSequentially("A");
        PrintWithThreeThreadsSequentially t2 = new PrintWithThreeThreadsSequentially("B");
        t2.start();
        t2.join();
        t1.start();
        t1.join();
    }
}
