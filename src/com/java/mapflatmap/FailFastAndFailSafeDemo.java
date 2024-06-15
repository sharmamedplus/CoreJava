package com.java.mapflatmap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailFastAndFailSafeDemo {

    // fail fast iterator checks modcount. it checks whether if there is any modification
    // in original collection. if we add or remove any element in collection then its modcount
    // will be increased and it will not match with its expected mod count.

    public static void main(String[] args) {
       // List<String> fruits = new ArrayList<>();
        List<String> fruits = new CopyOnWriteArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");

        Iterator<String> iterator = fruits.iterator();
        while (iterator.hasNext()){
            String fruit = iterator.next();
            System.out.println(fruit);
            fruits.add("Mango");
        }
        System.out.println(fruits);
    }
}
