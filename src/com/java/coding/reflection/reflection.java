package com.java.coding.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class reflection {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = Test.class.getDeclaredMethod("m1");
        method.setAccessible(true);
        method.invoke(new Test());
    }
}

class Test{
    private void m1(){
        System.out.println("m1");
    }
}
