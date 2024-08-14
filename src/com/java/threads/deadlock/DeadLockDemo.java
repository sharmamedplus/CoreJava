package com.java.threads.deadlock;

public class DeadLockDemo {

    public static void main(String[] args) {
        Object vijay_key = new Object();
        Object supriya_key = new Object();

        Thread vijay = new Thread(() -> {
            //synchronized (supriya_key){  deadlock situation
            synchronized (vijay_key){ // solution
                System.out.println("Vijay acquired Supriya's Key");
                System.out.println("Vijay sleeping for 3 sec");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Vijay woke up");
                //synchronized (vijay_key){  deadlock situation
                synchronized (supriya_key){
                    System.out.println("Vijay has got his Key");
                }
            }
        });

        Thread supriya = new Thread(() -> {
            synchronized (vijay_key){
                System.out.println("Supriya acquired Vijay's Key");
                System.out.println("Vijay sleeping for 3 sec");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Supriya woke up");
                synchronized (supriya_key){
                    System.out.println("Supriya has got her Key");
                }
            }
        });

        vijay.start();
        supriya.start();
    }
}
