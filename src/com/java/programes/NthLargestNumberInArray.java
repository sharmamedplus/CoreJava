package com.java.programes;

import java.util.PriorityQueue;

public class NthLargestNumberInArray {
    public static void main(String[] args) {
        int arr[] = {4,2,1,3};
        PriorityQueue<Integer> nthLargest = new PriorityQueue<>();
        for(int num : arr){
            nthLargest.add(num);
            if(nthLargest.size() > 3){
                Integer gs = nthLargest.poll();
                System.out.println(gs);
            }
        }

        System.out.println(nthLargest.peek());
    }
}
