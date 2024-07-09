package com.java.streams.student;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MaxMarkBySubject {
    public static void main(String[] args) {
        List<Student> students = Student.getStudents();
        Subject response = students.stream().map(Student::getSubjects).collect(Collectors.toList())
                .stream().flatMap(List::stream)
                .sorted(Comparator.comparingInt(Subject::getMark).reversed()).findFirst().get();
        System.out.println(response.getMark() + "  "+response.getSubjectName());

        // Sort by Marks
        Map<Integer, Subject> subjects = Student.getSubjectsMap();
        LinkedHashMap<Integer, Subject> subject = subjects.entrySet().stream()
                .sorted((entry1, entry2) -> entry1.getValue().getMark() >= entry2.getValue().getMark() ? 1 : -1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        System.out.println(subject);
    }
}
