package com.java.threads.evenodd_reentrant;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class EvenOddThreadCondition extends Thread {
    int t;
    EvenOddThreadCondition(int t) {
        this.t=t;
    }
   EvenOddThreadCondition() {
        this.t=0;
    }
    ReentrantLock lock = new ReentrantLock();
    Condition even = lock.newCondition();
    Condition odd = lock.newCondition();
    int MAX_COUNT = 10;

    public void run() {
        while (t <= MAX_COUNT) {
            lock.lock();
            try {
                if (t % 2 == 1 && Thread.currentThread().getName().equals("even")) {
                    even.await();
                } else if (t % 2 == 0 && Thread.currentThread().getName().equals("odd")) {
                    odd.await();
                } else {
                    System.out.println(Thread.currentThread().getName() + " Thread " + t);
                    t+=1;
                    if (t % 2 == 0) {
                        even.signal();
                    } else if (t % 2 == 1) {
                        odd.signal();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        EvenOddThreadCondition obj = new EvenOddThreadCondition(5);
        Thread even = new Thread(obj, "even");
        Thread odd = new Thread(obj, "odd");
        even.start();
        odd.start();
    }
}
