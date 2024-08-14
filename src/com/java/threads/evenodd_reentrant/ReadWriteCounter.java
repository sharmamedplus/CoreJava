package com.java.threads.evenodd_reentrant;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteCounter {
    final ReadWriteLock lock = new ReentrantReadWriteLock();
    Lock readLock = lock.readLock();
    Lock writeLock = lock.writeLock();
    int count = 0;

    public void increment(){
        writeLock.lock();
        try {
            count++;
        }finally {
            writeLock.unlock();
        }
    }

    public int getCounter(){
        readLock.lock();
        try {
            return count;
        }finally {
            readLock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        ReadWriteCounter counter = new ReadWriteCounter();

        Runnable readTask = () -> {
            for(int i=0; i<10; i++){
                System.out.println(Thread.currentThread().getName() + " read : "+ counter.getCounter());
            }
        };

        Runnable writeTask = () -> {
            for(int i=0; i<10; i++){
                counter.increment();
                System.out.println(Thread.currentThread().getName() + " Incremented ");
            }
        };

        Thread wirteThread = new Thread(writeTask);
        Thread readThread1 = new Thread(readTask);
        Thread readThread2 = new Thread(readTask);

        wirteThread.start();
        readThread1.start();
        readThread2.start();

        wirteThread.join();
        readThread1.join();
        readThread2.join();

        System.out.println("Final Count : "+counter.getCounter());
    }
}
