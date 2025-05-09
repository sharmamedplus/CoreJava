package com.java.threads.synchronization;

public class BankSynchronization {
    public int balance;

    public BankSynchronization(int initialBalance){
        this.balance = initialBalance;
    }

    public synchronized void deposite(int amount)  {
        balance = balance + amount;
        System.out.println(Thread.currentThread().getName() + " Is running with updated Balance = "+ balance);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void withdraw(int amount)  {
        if(balance >= amount){
            balance = balance - amount;
        }
        System.out.println(Thread.currentThread().getName() + " Is running with updated Balance = "+ balance);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getBalance(){
        return balance;
    }

    public static void main(String[] args) {
        BankSynchronization bankSynchronization = new BankSynchronization(100);
        Thread t1 = new Thread(() -> {
                bankSynchronization.deposite(50);
            }, "deposite 1");

        Thread t2 = new Thread(() -> {
            bankSynchronization.deposite(50);
        }, "deposite 2");

        Thread t3 = new Thread(() -> {
            bankSynchronization.withdraw(50);
        }, "withdraw 1");

        Thread t4 = new Thread(() -> {
            bankSynchronization.withdraw(50);
        }, "withdraw 2");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
