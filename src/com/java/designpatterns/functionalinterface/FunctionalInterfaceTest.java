package com.java.designpatterns.functionalinterface;

@FunctionalInterface
interface Calculator {
    int sum(int i1, int i2);
}

public class FunctionalInterfaceTest {
    public static void main(String[] args) {
        Calculator calculator = (i1, i2) -> {
            return i1 + i2;
        };
        System.out.println(calculator.sum(5,6));
    }
}
