package com.java.designpatterns;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.List.*;

public class ImportantConversions {
    public static void main(String[] args) {
        int[] nums = {9,7,9,6,2,4,5};
        List<Integer> numsList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.sort(numsList);
        System.out.println(numsList);


    }
}
