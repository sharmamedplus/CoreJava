package com.java.designpatterns._2structural.composite.component.leaf;

import com.java.designpatterns._2structural.composite.component.Service;

public class EmployeeService implements Service {
    @Override
    public void service(String serviceType) {
        System.out.println(serviceType + " For Employee");
    }
}
