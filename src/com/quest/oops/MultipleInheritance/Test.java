package com.quest.oops.MultipleInheritance;

public class Test implements Interface1, Interface2
{

    @Override
    public void method1()
    {
        System.out.println("implementation of method1 of test class\n");
    }

    @Override
    public void method2()
    {
        System.out.println("implementation of method2 of test class\n");
    }

    @Override
    public void defaultMethod()
    {
        Interface1.super.defaultMethod();
        Interface2.super.defaultMethod();
        System.out.println("overriding... default method of test class");
    }
}
