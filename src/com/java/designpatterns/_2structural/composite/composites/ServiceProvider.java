package com.java.designpatterns._2structural.composite.composites;

import com.java.designpatterns._2structural.composite.component.Service;

import java.util.ArrayList;
import java.util.List;

public class ServiceProvider implements Service {

    List<Service> servicesList = new ArrayList<>();

    @Override
    public void service(String serviceType) {
        servicesList.forEach(service -> {
            service.service(serviceType);
        });
    }

    public void addService(Service service){
        servicesList.add(service);
    }

    public void removeService(Service service){
        servicesList.remove(service);
    }

    public void clearServices(){
        servicesList.clear();
    }
}
