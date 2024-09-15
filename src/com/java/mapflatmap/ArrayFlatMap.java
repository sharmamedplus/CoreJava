package com.java.mapflatmap;

import java.util.Arrays;
import java.util.stream.Stream;

public class ArrayFlatMap {
    public static void main(String[] args) {
        String[] arrayOfWords = {"Eazy", "Bytes"};
        Stream<String> streamOfWords = Arrays.stream(arrayOfWords);
        Stream<String []> streamOfLetters = streamOfWords.map(word -> word.split(""));
        streamOfLetters.flatMap(Arrays::stream).forEach(System.out::println);
    }
}
