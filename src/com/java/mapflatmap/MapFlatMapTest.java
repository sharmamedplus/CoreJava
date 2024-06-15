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
                //.flatMap(Collection::stream)
                //.flatMap(List::stream)
                .flatMap(list -> list.stream())
                .map(Employee::getName)
                .collect(Collectors.toSet());

        List<String> response = List.of(List.of("Vijay", "Supriya"), List.of("AArsh", "Aradhya"))
                .stream().flatMap(list -> list.stream()).collect(Collectors.toList());

        System.out.println(response);

        List<List<String>> shapes = List.of(
                List.of("triangle", "rectangle", "square"), // sharp forms
                List.of("circle", "ellipse", "cylinder") // rounded forms
        );

        response = shapes.stream().flatMap(list -> list.stream()).collect(Collectors.toList());
        System.out.println(response);
    }
}
