package com.java.designpatterns.string;

import java.util.Arrays;
import java.util.stream.IntStream;

public class StringTest {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        //Arrays.asList("Vijay","Supriya","Vijay2").stream().filter(e -> e.startsWith("V")).map(sb::append);
        String s = "1";
        IntStream.range(1,5).forEach(e->{
                sb.append(String.format("For Case :%s", s));
                sb.append("\n");
        });
        System.out.println(sb.toString());
    }
}
