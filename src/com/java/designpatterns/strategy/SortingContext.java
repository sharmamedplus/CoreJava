package com.java.designpatterns.strategy;

public class SortingContext {

    private SortingStrategy sortingStrategy;

    public SortingContext(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public void performSort(Integer[] arr){
        sortingStrategy.sort(arr);
    }
}
