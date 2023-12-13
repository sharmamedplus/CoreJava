package com.java.streams;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.*;

public class Stream_Of_And_Arrays_stream {
    public static void main(String[] args) {

        /*
        * Stream.of() is generic whereas Arrays.stream is not.
        *
        * only for primitive arrays of int[], long[], and double[] type Arrays.stream() method works,
        * and returns IntStream, LongStream and DoubleStream respectively.
        * For other primitive types like char[]... Arrays.stream() won’t work.
        *
        * On the other hand, Stream.of() returns a generic Stream of type T (Stream).
        * Hence, it can be used with any type
        *
        * For primitives arrays (like int[], long[] etc), Arrays.stream() and Stream.of()
        * have different return types.
        *
        * Example:
        *           Passing an integer array, the Stream.of() method returns Stream
        *           whereas Arrays.stream() returns an IntStream.
        *
        * int arr[] = { 1, 2, 3, 4, 5 };
        *   IntStream intStream = Arrays.stream(arr);
        *
        *   Stream<int[]> stream = Stream.of(arr);
        *   IntStream intStream = stream.flatMapToInt(Arrays::stream);
        *
        * char arr[] = { '1', '2', '3', '4', '5' };
        *   Arrays.stream(arr); --> error: no suitable method found for stream(char[]) Arrays.stream(arr);
        *
        * Java provides the Stream, IntStream, LongStream, and DoubleStream classes
        * to get streams over objects and the primitive int, long and double types.
        *
        * Java doesn’t provide char stream for primitive char.
        * Therefore, we can’t apply Arrays.stream() method to a char[] array.
        *
        * However, we can get an IntStream (a stream of ints) of characters and use that
        * to generate Stream<Characters>
        *
         */

        int int_arr[] = {1,2,3,4,5};
        IntStream stream = Arrays.stream(int_arr);

        String str_arr[] = {"Vijay","Sharma"};
        Stream<String> str_stream = Arrays.stream(str_arr);

        Arrays.stream(int_arr).forEach(System.out::print); // 12345
        Arrays.stream(str_arr).forEach(System.out::print); // VijaySharma

        Stream.of(int_arr).forEach(System.out::print); // [I@214c265e
        Stream.of(int_arr).flatMapToInt(Arrays::stream).forEach(System.out::print); // 12345
        Stream.of(str_stream).forEach(System.out::print);// VijaySharma

        char char_arr[] = { '1', '2', '3', '4', '5' };
        //Arrays.stream(char_arr); /* error: no suitable method found for stream(char[]) Arrays.stream(arr) */

        Stream<Character> charStream = new String(char_arr).chars().mapToObj(i -> (char)i);
        charStream.forEach(System.out::print); // 12345


        String[] str_arr2 = { "Geeks", "for", "Geeks" };
        Stream<String> stm = Arrays.stream(str_arr2);
        Stream<String> stm2 = Stream.of(str_arr2);

        IntStream int_stm = Arrays.stream(int_arr);
        IntStream int_stm2 = IntStream.of(int_arr);
        
        long[] arrL = { 3L, 5L, 6L, 8L, 9L };
        LongStream long_stm = Arrays.stream(arrL);
        LongStream long_stm2 = LongStream.of(arrL);

        double[] arrD = { 1, 2, 3, 4, 5 };
        DoubleStream stmD = Arrays.stream(arrD);
        DoubleStream stmD2 = DoubleStream.of(arrD);
    }
}
