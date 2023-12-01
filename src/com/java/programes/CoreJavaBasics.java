package com.java.programes;

import java.util.HashMap;
import java.util.Map;

public class CoreJavaBasics {
    public static void main(String[] args) {

        Map<StringBuilder, String> map = new HashMap<>();
        StringBuilder sb = new StringBuilder("Vijay");
        map.put(sb, "Sharma");
        sb.append("Kumar");
        System.out.println(map);
        System.out.println(map.get(sb));

        Map<String, String> map1 = new HashMap<>();
        String str = new String("Vijay");
        map1.put(str, "Sharma");
        str = str+"Kumar";
        System.out.println(map1);
        System.out.println(map1.get(str));


    }
}
