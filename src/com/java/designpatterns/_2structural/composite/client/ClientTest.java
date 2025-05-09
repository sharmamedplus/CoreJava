package com.java.designpatterns._2structural.composite.client;

import com.java.designpatterns._2structural.composite.component.leaf.AdminService;
import com.java.designpatterns._2structural.composite.component.leaf.EmployeeService;
import com.java.designpatterns._2structural.composite.composites.ServiceProvider;

public class ClientTest {
    public static void main(String[] args) {

        // First we have created the Component Interface (Service)
        // We require few Leaf(Services) for Component service so created Employee and Admin Service
        //    these services must be independent as they should not contain references of each other.
        //Created Composite class ServiceProvider here we processing, adding, removing services.

        ServiceProvider serviceProvider = new ServiceProvider();

        EmployeeService e1 = new EmployeeService();
        EmployeeService e2 = new EmployeeService();

        AdminService a1 = new AdminService();

        serviceProvider.addService(e1);
        serviceProvider.addService(e2);
        serviceProvider.addService(a1);

        serviceProvider.service("Registration Service");

        System.out.println("-----------------------------------------------");

        serviceProvider.removeService(e1);

        serviceProvider.addService(new AdminService());

        serviceProvider.service("Logout Service");

        System.out.println("-----------------------------------------------");

        serviceProvider.clearServices();

        serviceProvider.addService(new EmployeeService());

        serviceProvider.service("Update Service");

    }
}
