package com.java.coding.lloyds_interview;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

public class TestCode {
    public static void main(String[] args) {
        Integer a = 128;
        Integer b = 128;
        Integer c = 100;
        Integer d = 100;

        System.out.println(a == b);  // false
        System.out.println(c == d);  // true

        for(int i=0; i<1; i++){
            System.out.println(i+' ');
        }

        String str1, str2 = "petrol";
       // str1 = str1 + str2;     // error
       // System.out.println(str1);

        int[] arr = {3,4,2,6};
        Integer response = Arrays.stream(arr).boxed()
                .sorted(Comparator.comparingInt(Integer::intValue).reversed())
                .skip(1).findFirst().get();
        System.out.println(response);

        int[] arr2 = { 5, 4, 3, 2, 1, 6 };

        int num = 7;
        for(int i = 0; i<arr2.length; i++){
            for(int j = i + 1; j<arr2.length; j++){
                if(arr2[i] + arr2[j] == num){
                    System.out.println(arr2[i] + " "+ arr2[j]);
                }
            }
        }

    }
}

class A {
    public String type = "A";

    public A(){
        System.out.print("CodeA");
    }
}
class B extends  A{

    public B(){
        System.out.print("CodeB");
        type = "B";
    }

    public void go(){
        System.out.print(this.type + " "+ super.type);
    }

    public static void main(String[] args) {
        new B().go();  // CodeACodeB B B
    }
}
// Lambda , static,