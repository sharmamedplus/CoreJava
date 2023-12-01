package com.java.designpatterns.singleton;                                                                                                                                                                                                      ;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Singleton_ implements Serializable, Cloneable{
    //private static final Singleton singleton = new Singleton();

    private static final Singleton_ singleton = null;

    private Singleton_(){
        System.out.println("Creating Object.....");
    }

    /*public static Singleton getInstance(){
        return singleton;
    }*/

    public static Singleton_ getInstance(){
        if(null == singleton) {
            return new Singleton_();
        }
        return singleton;
    }

    @Override
    public Singleton_ clone() {
        try {
            Singleton_ clone = (Singleton_) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

public class SingletonBreakingTest {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException, IOException {
        Singleton_ s1 = Singleton_.getInstance();
        Singleton_ s2 = Singleton_.getInstance();

        print("s1", s1);
        print("s2", s2);

        // Reflection
        Class clazz = Class.forName("com.java.designpatterns.Singleton");
        Constructor<Singleton_> constructors = clazz.getDeclaredConstructor();
        constructors.setAccessible(true);
        Singleton_ s3 = constructors.newInstance();

        print("s3", s3);

        //Serialization and Deserialization
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("C:/Users/vijay/OneDrive/Desktop/Java Interview/s2.ser"));
        out.writeObject(s2);

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("C:/Users/vijay/OneDrive/Desktop/Java Interview/s2.ser"));
        Singleton_ s4 = (Singleton_)in.readObject();

        print("s4", s4);

        // clone

        Singleton_ s5 = s2.clone();
        print("s5", s5);

        // Multiple threads

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(SingletonBreakingTest::useSingleton);
        executorService.submit(SingletonBreakingTest::useSingleton);

        executorService.shutdown();
    }
    static void useSingleton(){
        Singleton_ singleton = Singleton_.getInstance();
        print("singleton :", singleton);
    }
    public static void print(String name, Singleton_ object){
        System.out.println(String.format("Object : %s, Hashcode : %d",name, object.hashCode()));
    }
}
