package com.java.streams.optional;

import com.java.Employee;

import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) {
        Employee employee = null;

        Optional<Employee> employees = Optional.ofNullable(employee);
        System.out.println(employees);

        employees = Optional.of(employee);
        System.out.println(employees);
    }
}
