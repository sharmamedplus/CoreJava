package com.java.streams.student;

import java.util.*;

public class Student {
    String name;
    List<Subject> subjects;

    public Student(String name, List<Subject> subjects) {
        this.name = name;
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }


    public static List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student("Vijay",
                Arrays.asList(new Subject("Maths", 85),
                        new Subject("Hindi", 88))));
        students.add(new Student("Aarsh",
                Arrays.asList(new Subject("Maths", 80),
                        new Subject("Hindi", 90))));
        students.add(new Student("Supriya",
                Arrays.asList(new Subject("Maths", 50),
                        new Subject("Hindi", 80))));

        return students;
    }

    public static Map<Integer, Subject> getSubjectsMap(){
        Map<Integer, Subject> subjectMap = new HashMap<>();
        subjectMap.put(1, new Subject("Maths", 100));
        subjectMap.put(2, new Subject("Hindi", 90));
        subjectMap.put(3, new Subject("Science", 80));
        subjectMap.put(4, new Subject("English", 70));

        return subjectMap;
    }
}
