package com.java.strings;

public class StringTest {
    public static void main(String[] args) {
        String s1 = "Vijay";
        String s2 = "Vijay";
        String s3 = new String("Vijay");
        String s4 = s3;


        System.out.println(s1 == s2); // true
        System.out.println(s1 == s3); // false
        System.out.println(s4 == s3); // true

        StringBuilder name = new StringBuilder("Vijay  Sharma ");
        String response = name.substring(0, name.lastIndexOf(" Sharma "));
        System.out.println(String.format("Hi %d ", 500));

    }
}
