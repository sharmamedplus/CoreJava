package com.java.threads.basic;

public class WaysOfCreatingThreads {
    public static void main(String[] args) {
        CallableTest callableTest = new CallableTest();
        new Thread(callableTest).start();
        new ThreadTest().start();
    }
}

class CallableTest implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}

class ThreadTest extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}