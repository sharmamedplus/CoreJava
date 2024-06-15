package com.java.designpatterns.composite.component.leaf;

import com.java.designpatterns.composite.component.Service;

public class AdminService implements Service {
    @Override
    public void service(String serviceType) {
        System.out.println(serviceType + " For Admin");
    }
}
