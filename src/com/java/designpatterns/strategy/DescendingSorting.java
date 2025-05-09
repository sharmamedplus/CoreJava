package com.java.designpatterns.strategy;

import java.util.Arrays;
import java.util.Collections;

public class DescendingSorting implements SortingStrategy{
    @Override
    public Integer[] sort(Integer arr[]) {
        Arrays.sort(arr, Collections.reverseOrder());
        return arr;
    }
}
