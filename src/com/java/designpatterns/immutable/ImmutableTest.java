package com.java.designpatterns.immutable;

import java.util.HashMap;
import java.util.Map;
/*
Immutable class in java means that once an object is created, we cannot change its content.
In Java, all the wrapper classes (like Integer, Boolean, Byte, Short) and String class is immutable.
We can create our own immutable class as well. Prior to going ahead do go through characteristics of
immutability in order to have a good understanding while implementing the same. Following are the requirements:

    The class must be declared as final so that child classes can’t be created.
    Data members in the class must be declared private so that direct access is not allowed.
    Data members in the class must be declared as final so that we can’t change the value of it after object creation.
    A parameterized constructor should initialize all the fields performing a deep copy so that data members can’t be modified with an object reference.
    Deep Copy of objects should be performed in the getter methods to return a copy rather than returning the actual object reference)

*/

final class Student {
    private final String name;
    private final Long rollNo;
    private final Map<String,String> data;

    public Student(String name, Long rollNo, Map<String,String> data){
        this.name = name;
        this.rollNo = rollNo;

        Map<String,String>  tempData = new HashMap<>();
        data.keySet().forEach(key->{
            tempData.put(key, data.get(key));
        });

        this.data = tempData;
    }

    public String getName() {
        return name;
    }

    public Long getRollNo() {
        return rollNo;
    }

    public Map<String, String> getData() {
        Map<String,String>  tempData = new HashMap<>();
        data.keySet().forEach(key->{
            tempData.put(key, data.get(key));
        });
        return tempData;
    }

}

public class ImmutableTest {
    public static void main(String[] args) {
        // Creating Map object with reference to HashMap
        Map<String, String> map = new HashMap<>();

        // Adding elements to Map object
        // using put() method
        map.put("1", "first");
        map.put("2", "second");

        Student s = new Student("ABC", 101l, map);

        // Calling the above methods 1,2,3 of class1
        // inside main() method in class2 and
        // executing the print statement over them
        System.out.println(s.getName());
        System.out.println(s.getRollNo());
        System.out.println(s.getData());

        // Uncommenting below line causes error
        // s.regNo = 102;

        map.put("3", "third");
        // Remains unchanged due to deep copy in constructor
        System.out.println(s.getData());
        s.getData().put("4", "fourth");
        // Remains unchanged due to deep copy in getter
        System.out.println(s.getData());
    }
}