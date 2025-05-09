package com.java.designpatterns.strategy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class AscendingSorting implements SortingStrategy{
    @Override
    public Integer[] sort(Integer[] arr) {
         Arrays.sort(arr);
         return arr;
    }
}
