package com.java.coding;

public class ReverseANumber {
    public static void main(String[] args) {
        int number = 123;
        int rev = 0;
        while(number != 0){
            rev = rev*10 + number % 10;
            number = number / 10;
        }
        System.out.println(rev);

        // fibonacci

        int n1 = 0, n2 = 1, sum = 0;
        System.out.print(n1 + " "+ n2);
        for(int i = 2; i<10; i++){
            sum = n1 + n2;
            System.out.print(" "+sum);
            n1 = n2;
            n2 = sum;
        }
    }
}
