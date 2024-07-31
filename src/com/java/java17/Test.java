package com.java.java17;

import java.util.Optional;

public  class Test {
    public static void main(String[] args) {
        Optional<String> response = Optional.empty();
        response.ifPresentOrElse(res -> System.out.println(res),
                () -> System.out.println("No Value"));
    }
}
