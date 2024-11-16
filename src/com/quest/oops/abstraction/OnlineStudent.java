package com.quest.oops.abstraction;

public class OnlineStudent extends Student
{
    OnlineStudent()
    {
        System.out.println("creating online student");
    }
    @Override
    public void attendClass()
    {
        System.out.println("Attending online class");
    }

    @Override
    public void submitAssignment()
    {
        System.out.println("Online student submitted assignment");
    }
}
