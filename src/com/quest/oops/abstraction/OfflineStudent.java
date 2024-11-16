package com.quest.oops.abstraction;

public class OfflineStudent extends Student
{
    @Override
    public void attendClass()
    {
        System.out.println("Attending offline class");
    }

    @Override
    public void submitAssignment()
    {
        System.out.println("Offline student submitted assignment");
    }
}
