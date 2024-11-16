package com.quest.oops.abstraction;

public class StudentFactory
{
    public static Student getStudent(String studentType)
    {
        if(studentType.equalsIgnoreCase("online"))
        {
            Student onlineStudent=new OnlineStudent();
            return onlineStudent;
        }
        else if(studentType.equalsIgnoreCase("offline"))
        {
            Student offlineStudent=new OfflineStudent();
            return offlineStudent;
        }
        else if(studentType.equalsIgnoreCase("regular"))
        {
            Student regularStudent=new RegularStudent();
            return regularStudent;
        }
        else
            return null;
    }
}
