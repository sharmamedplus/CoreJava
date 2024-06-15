package com.java.mapflatmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MapTest {
    public static void main(String[] args) {
        Test t1 = new Test();
        t1.setId(1);
        t1.setName("T1");
        Test t2 = new Test();
        t2.setId(2);
        t2.setName("T2");
        Test t3 = new Test();
        t3.setId(3);
        t3.setName("T3");

        Map<Test, String> map = new HashMap<>();
        map.put(t1, "T1");
        map.put(t2, "T2");
        map.put(t3, "T3");

        map.entrySet().forEach(entry -> {
            System.out.println(entry.getKey().getId() + " "+ entry.getValue());
        });
    }
}

class Test {
    private int id;
    private String name;

    @Override
    public boolean equals(Object o) {
        return true;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Test test = (Test) o;
        return id == test.id && name.equals(test.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
