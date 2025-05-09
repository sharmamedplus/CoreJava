package com.java.threads.evenodd_reentrant;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantFairness {
    Lock lock = new ReentrantLock(true); // Here passing true means giving faireness
    public void accessResource(){
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName() + " acquired lock");
        }finally{
            System.out.println(Thread.currentThread().getName() + " released lock");
            lock.unlock();
        }
    }
    public static void main(String[] args) {
        ReentrantFairness fairness = new ReentrantFairness();
        Runnable task = () -> {fairness.accessResource();};

        Thread t1 = new Thread(task, "Thread1");
        Thread t2 = new Thread(task, "Thread2");
        Thread t3 = new Thread(task, "Thread3");

        t1.start();
        t2.start();
        t3.start();
    }
}
