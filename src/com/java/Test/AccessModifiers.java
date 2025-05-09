package com.java.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.stream.IntStream;

public class AccessModifiers {

    public static void main(String[] args) {
        IntStream.range(0,5).forEach(System.out::print);
        System.out.println();
        IntStream.rangeClosed(0,5).forEach(System.out::print);

        int arr[] = {4,5,3,6,7};

        //Arrays.stream(arr).boxed().map(String::valueOf).filter(Character::isDigit).forEach(System.out::print);

        System.out.println();
        System.out.println(Arrays.stream(arr).sum());

        LocalDate birtDate = LocalDate.of(1990, 7, 19);
        System.out.println(ChronoUnit.MONTHS.between(birtDate, LocalDate.now()));

        int a =10;
        int b = 20;
        a = (a + b) - (b = a);

        System.out.println(a + "  "+ b);

    }

}

class MyClass{
    public String name;
    private int age;

    public void public_() {
        System.out.println("public");
    }

    private void private_() {
        System.out.println("private");
    }

    protected void protected_() {
        System.out.println("protected");
    }

    void default_() {
        System.out.println("default");
    }
}


