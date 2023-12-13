package com.java.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsJoinning {
    public static void main(String[] args) {

        /*
        * Program 1: Using joining() with an array of characters
        * */

        char ch[] = {'V','i','j','a','y','K','u','m','a','r','S','h','a','r','m','a'};
        String combinedString = Stream.of(ch).map(ch_arr -> new String(ch_arr)).collect(Collectors.joining());
        System.out.println(combinedString);

        List<Character> ch_obj_arr = Arrays.asList('V','i','j','a','y','K','u','m','a','r','S','h','a','r','m','a');
        String combinedString2 = ch_obj_arr.stream().map(String::valueOf).collect(Collectors.joining());
        System.out.println(combinedString2);

        List<String> str = Arrays.asList("Geeks", "for", "Geeks");
        String chString = str.stream().collect(Collectors.joining());

        /*
            public static Collector<CharSequence, ?, String>
                    joining(CharSequence delimiter,
                            CharSequence prefix,
                            CharSequence suffix)
            )
        */

        String chString2 = str.stream().collect(Collectors.joining(", ", "[", "]"));
    }
}
