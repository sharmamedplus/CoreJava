package com.java.designpatterns.strategy;

import java.util.Arrays;

public class StrategyTest {
    public static void main(String[] args) {
        Integer[] arr = {2,3,1,4};

        SortingContext ascContext = new SortingContext(new AscendingSorting());
        ascContext.performSort(arr);
        Arrays.stream(arr).forEach(System.out::print);
        System.out.println();
        SortingContext descContext = new SortingContext(new DescendingSorting());
        descContext.performSort(arr);
        Arrays.stream(arr).forEach(System.out::print);

    }
}
