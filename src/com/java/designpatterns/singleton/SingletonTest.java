package com.java.designpatterns.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

class Singleton implements Serializable, Cloneable {
    private static volatile Singleton singleton = null;

    // If creating object through Constructor then should allow only if instance is not created...
    public Singleton(){
        if(singleton != null){
            throw new RuntimeException("Please call global method");
        }
    }

    // When deserialization happens readResolve method gets called here we can change the behaviour so we will
    // return singleton instance
    private Object readResolve() throws ObjectStreamException {
        System.out.println("............readResolve..........");
        return singleton;
    }

    @Override
    public Singleton clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Can not clone");
    }

    public static Singleton getInstance(){
        if(singleton == null){
            synchronized (Singleton.class){
                if(singleton == null){ // Double check lock
                    return new Singleton();
                }
            }
        }
        return singleton;
    }

}
public class SingletonTest {


}
