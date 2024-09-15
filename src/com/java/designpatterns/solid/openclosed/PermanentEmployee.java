package com.java.designpatterns.solid.openclosed;

public class PermanentEmployee implements IEmployee{
    @Override
    public void calculateBonus(int salary) {
        System.out.println("Salary = "+ (salary * 10)/100);
    }

    @Override
    public Double getMinimumSalary() {
        return 0.0;
    }
}
