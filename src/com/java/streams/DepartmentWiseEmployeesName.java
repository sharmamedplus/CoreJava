package com.java.streams;

import com.java.Employee;
import com.java.EmployeeData;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DepartmentWiseEmployeesName {
    public static void main(String[] args) {
        List<Employee> employees = EmployeeData.getEmployees();
        Map<String, String> response = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.mapping(Employee::getName, Collectors.joining(",", "", ""))));

        System.out.println(response);

        Map<String, List<String>> response2 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.mapping(Employee::getName, Collectors.toList())));

        System.out.println(response2);

        int arr[] = {3,4,5,6,2};
        String []arr2 = {"Vijay", "Supriya", "Arsh"};
        Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        HashMap<String, String> map = new HashMap<String, String>();
        map.put("1", "Vijay");
        map.put("2", "Supriya");
        map.put("3", "Arsh");

        Stream<Map.Entry<String, String>> re = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue());
        re.forEach(entry -> System.out.print(entry.getValue()));
    }
}
