package com.java.streams;

import com.java.Employee;
import com.java.EmployeeData;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindNthSalaryWhenSalaryDuplicate {
    public static void main(String[] args) {
        List<Employee> emps = EmployeeData.getEmployees();
        Employee newEmps = emps.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).skip(1).findFirst().get();
        emps.stream().map(Employee::getSalary).forEach(System.out::println);
        //System.out.println(newEmps);
        List<Employee> thirdHighest = emps.stream().collect(Collectors.groupingBy(Employee::getSalary))
                .entrySet().stream().sorted((e1, e2) -> e1.getKey() > e2.getKey() ? -1 : 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new))
                .entrySet().stream().skip(1).findFirst().get().getValue();

        System.out.println(thirdHighest);
    }
}
