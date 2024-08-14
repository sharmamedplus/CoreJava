package com.java.designpatterns._1creational._4builder;

public class Employee{

    private String name;
    private String lastName;

    public Employee(EmployeeBuilder builder){
        this.name = builder.name;
        this.lastName = builder.lastName;
    }

    public static EmployeeBuilder builder(){
        return new EmployeeBuilder();
    }

    public static class EmployeeBuilder {
        private String name;
        private String lastName;

        public EmployeeBuilder name(String name) {
            this.name = name;
            return this;
        }

        public EmployeeBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Employee build(){
            return new Employee(this);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public static void main(String[] args) {
        System.out.println(Employee.builder().name("Vijay").lastName("Sharma").build());
    }
}


