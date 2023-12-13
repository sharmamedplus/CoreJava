package com.java.oops;

public class A {

    public static void hi(){
        System.out.println("A hi");
    }

    public static void main(String[] args) {
        A.hi();
        B.hi();
    }
}

class B extends A {
    public static void hi(){
        System.out.println("B hi");
    }
}
