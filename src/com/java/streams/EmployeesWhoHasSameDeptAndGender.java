package com.java.streams;

import com.java.Employee;
import com.java.EmployeeData;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EmployeesWhoHasSameDeptAndGender {
    public static void main(String[] args) {
        List<Employee> employees = EmployeeData.getEmployees();

        Map<String, List<Employee>> response =
                employees.stream()
                .collect(Collectors.groupingBy(
                        emp -> (emp.getDepartment() + emp.getGender()).toLowerCase(),
                        Collectors.mapping(Function.identity(), Collectors.toList())));

        System.out.println(response);
    }
}
