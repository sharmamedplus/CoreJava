package com.java.oops;

public class WrapperTest {
    public static void main(String[] args) {
        Integer i1 = 127;
        Integer i2 = 127;
        Integer i3 = 128;
        Integer i4 = 128;
        Integer i5 = 500;
        Integer i6 = 500;

        if(i1 == i2){
            System.out.println("i1 == i2");
        }else{
            System.out.println("i1 != i2");
        }

        if(i3 == i4){
            System.out.println("i3 == i4");
        }else{
            System.out.println("i3 != i4");
        }

        if(i5 == i6){
            System.out.println("i5 == i6");
        }else{
            System.out.println("i5 != i6");
        }
    }
}
