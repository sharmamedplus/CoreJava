package com.java.programes;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public  class MergeTwoList {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(2,4,5,6);
        List<Integer> list2 = Arrays.asList(3,1,5,4);

        Integer min = Stream.concat(list1.stream(), list2.stream()).collect(Collectors.toSet())
                .stream().min((n1,n2) -> n1-n2).get();
        System.out.println(min);
    }
}
