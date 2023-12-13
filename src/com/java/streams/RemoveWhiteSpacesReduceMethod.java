package com.java.streams;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RemoveWhiteSpacesReduceMethod {
    public static void main(String[] args) {

        /*
        * Many times, we need to perform operations where a stream reduces to single
        * resultant value, for example, maximum, minimum, sum, product, etc. Reducing
        * is the repeated process of combining all elements.
        *
        * reduce operation applies a binary operator to each element in the stream
        * where the first argument to the operator is the return value of the previous
        * application and second argument is the current stream element.
        *
        * Syntax :
        *           T reduce(T identity, BinaryOperator<T> accumulator);
        *
        *           Where, identity is initial value of type T and accumulator is a
        *           function for combining two values.
        *
        * sum(), min(), max(), count() etc. are some examples of reduce operations.
        * reduce() explicitly asks you to specify how to reduce the data that made it through the stream.
        *
        * */

        String str = "Vijay Kumar Sharma";
        System.out.println(Arrays.stream(str.split(" ")).reduce((s1,s2)-> s1+s2).get());

        /*
        * Largest word in String
        * */

        String str2 = "Vijay Supriya Aarsh Aaradhya";
        System.out.println(Arrays.stream(str2.split(" ")).reduce((word1,word2)-> word1.length() > word2.length() ? word1 : word2).get());

       /*
       * Sum of all elements
       * */

        Integer sum = Arrays.asList(5, 10, 20, -20).stream().reduce((num1, num2) -> num1 + num2).get();
        System.out.println(sum);

        /*
        * Square sum of all numbers
        *
        * */

        int squareSum = IntStream.range(2, 4).reduce((num1, num2) -> num1 * num2).getAsInt();
        System.out.println(squareSum);


    }
}
