package com.java.designpatterns.functionalinterface;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class InbuildFucntionInterfacesTest {
    public static void main(String[] args) {

        Predicate predicate = (number) -> {
            return 10 > Integer.parseInt(String.valueOf(number));
        };
        System.out.println(predicate.test(15));
//===========================================================================
        Consumer consumer = (input) -> {
            System.out.println("The Input is : "+input);
        };

        consumer.accept(10);
        // Use your consumer
        Arrays.asList(1,2,3,4,5).stream().forEach(consumer);
//============================================================================

       // Producer
    }
}
