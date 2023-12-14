package com.java.mapflatmap;

import com.java.Employee;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapFlatMapTest {
    public static void main(String[] args) {
        Map<String, List<Employee>> map = new HashMap<>();

        map.values().stream()
                .flatMap(Collection::stream)
                .map(Employee::getName)
                .collect(Collectors.toSet());
    }
}
