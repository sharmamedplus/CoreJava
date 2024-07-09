package com.java.functional.intrface;

public class InterfaceTesting {

}

interface I1 {
    void add();
}
interface I2 {
    void add();
}

class Impl implements I1, I2 {

    @Override
    public void add() {
        System.out.println("Impl");
    }

    public static void main(String[] args) {
        I1 impl = new Impl();
        impl.add();
    }
}
