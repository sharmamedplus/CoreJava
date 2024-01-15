package com.java.streams;

import com.java.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class FindFourthHighestSalaryEmployee {
    public static void main(String[] args) {
        List<Employee> emps = Arrays.asList(new Employee("Vijay1", 34, 40000),
                new Employee("Vijay2", 34, 40000),
                new Employee("Vijay3", 34, 30000),
                new Employee("Vijay4", 34, 20000),
                new Employee("Vijay5", 34, 10000));
        Employee fourthHighestSalary = emps.stream().filter(emp -> emp.getAge() > 20)
                .sorted(Comparator.comparingDouble(Employee::getSalary)).skip(3).findFirst().get();

        //System.out.println(fourthHighestSalary);

        List<Employee> emp = emps.stream().collect(Collectors.groupingBy(Employee::getSalary)).entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                //.sorted((entry1, entry2) -> entry1.getKey() > entry2.getKey() ? 1 : -1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new))
                .entrySet().stream().skip(3).findFirst().get().getValue();

        System.out.println(emp.stream().findFirst().get());
    }
}
