package com.quest.oops.MultipleInheritance;

public interface Interface1
{
    void method1();
    void method2();
    default void defaultMethod()
    {
        System.out.println("inside default method of interface1");
    }
}