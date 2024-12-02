package com.quest.exception_handling.oopException2CustomExceptionEg;

public class Employee
{
    private String name;
    private Integer age;
    private Double salary;

    public Employee(String name, Integer age, Double salary) throws InvalidInputException
    {
        this.name = name;
        this.age = age;
        this.salary = salary;
        if(age<18)
            throw new InvalidInputException("employee must be 18+");
        if(salary<0)
            throw new InvalidInputException("salary cannot be negative.");
    }

    public final void displayMethod()
    {
        System.out.println("*****************");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Salary: " + salary);
    }

}
