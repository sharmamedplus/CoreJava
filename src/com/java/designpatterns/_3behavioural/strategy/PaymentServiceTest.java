package com.java.designpatterns._3behavioural.strategy;


/*
Strategy design pattern is one of the behavioral design pattern.
Strategy pattern is used when we have multiple algorithm for a specific task and
client decides the actual implementation to be used at runtime.

One of the best example of strategy pattern is Collections.sort() method that takes
Comparator parameter. Based on the different implementations of Comparator interfaces,
the Objects are getting sorted in different ways.

*/

interface PaymentStrategy {
    public void pay(int amount);
}

class CreditCardStrategy implements PaymentStrategy{

    @Override
    public void pay(int amount) {
        System.out.println("Paying with Credit card : "+amount);
    }
}

class DebitCardStrategy implements PaymentStrategy{

    @Override
    public void pay(int amount) {
        System.out.println("Paying with Debit card : "+amount);
    }
}

class ShoppingCart {
    public void doPayment(PaymentStrategy strategy, int amount){
        strategy.pay(amount);
    }
}

public class PaymentServiceTest {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.doPayment(new CreditCardStrategy(), 100);
        cart.doPayment(new DebitCardStrategy(), 100);
    }
}