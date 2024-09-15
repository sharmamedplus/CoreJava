package com.java.designpatterns._1creational._4builder;

public class Customer {

    private String name;

    public Customer(CustomerBuilder customerBuilder){
        this.name = customerBuilder.name;
    }

    public static CustomerBuilder builder(){
        return new CustomerBuilder();
    }
    public static class CustomerBuilder{
        private String name;

        public CustomerBuilder name(String name){
            this.name = name;
            return this;
        }

        public Customer build(){
            return new Customer(this);
        }
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
