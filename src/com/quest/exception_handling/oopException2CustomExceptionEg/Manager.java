package com.quest.exception_handling.oopException2CustomExceptionEg;

public class Manager extends Employee
{
    private Integer teamSize;

    public Manager(String name, Integer age, Double salary, Integer teamSize) throws InvalidInputException
    {
        super(name, age, salary);
        this.teamSize = teamSize;
        if(teamSize < 1)  //unchecked exception
        {
            throw new IllegalArgumentException("team size cannot be less than 1");
        }
    }

    @Override
    public String toString() {
        return "Team Size : " + teamSize;
    }
}