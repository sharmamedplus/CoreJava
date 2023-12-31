package com.java.programes;

import java.util.stream.IntStream;

public class Palindrom {
    public static void main(String[] args) {

        String name = "NAMAN";
        /*String temp  = name.replaceAll("\\s+", "").toLowerCase();

        boolean isPalindrom = IntStream.range(0, temp.length() / 2)
                .noneMatch(i -> temp.charAt(i) != temp.charAt(temp.length() - i - 1));*/

        //System.out.println(isPalindrom);
        boolean isPalindrom = true;
        for(int i = 0; i <= name.length()/2; i++){

            if(name.charAt(i) != name.charAt(name.length()-i-1)){
                isPalindrom = false;
            }
        }

        System.out.println(isPalindrom);

    }
}
