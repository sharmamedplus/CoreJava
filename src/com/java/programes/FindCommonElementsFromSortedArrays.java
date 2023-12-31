package com.java.programes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindCommonElementsFromSortedArrays {

    public static List<Integer> findCommonElements(Integer[][] arrays) {

        List<Integer> commonElements = Arrays.asList(arrays[0]);

        for (int i = 1; i < arrays.length; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < arrays[i].length; j++) {
                int num = arrays[i][j];
                if (commonElements.contains(num)) {
                    temp.add(num);
                }
            }
            commonElements = temp;
        }
        return commonElements;
    }

    public static void main(String[] args) {
        Integer[][] arrays = {
                {1, 2, 3, 4, 6, 5},
                {2, 4, 6, 8},
                {2, 3, 4, 6, 7},
                {4, 5, 8,6, 9}
        };

        List<Integer> commonElements = findCommonElements(arrays);
        System.out.println("Common elements in the arrays: " + commonElements);
    }
}
