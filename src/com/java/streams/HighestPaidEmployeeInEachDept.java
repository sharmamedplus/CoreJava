package com.java.streams;

import com.java.Employee;
import com.java.EmployeeData;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class HighestPaidEmployeeInEachDept {
    public static void main(String[] args) {
        List<Employee> employees = EmployeeData.getEmployees();

        Map<String, Employee> response = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)),
                        Optional::get)));

        System.out.println(response);
    }
}
