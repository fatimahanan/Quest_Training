package com.quest.oops.abstraction;

public class AbstractionExample
{
    public static void main(String[] args)
    {
        Student online = new OfflineStudent();
        Student offline= new OnlineStudent();
        Student regular= new RegularStudent();
        online.study();
        online.attendClass();
        online.submitAssignment();
        offline.attendClass();
        offline.submitAssignment();
        regular.attendClass();
        regular.submitAssignment();
        System.out.println();
//        Student onlineStudent=StudentFactory.getStudent("online");
//        Student offlineStudent=StudentFactory.getStudent("offline");
//        Student regularStudent=StudentFactory.getStudent("regular");
//        onlineStudent.attendClass();
//        offlineStudent.attendClass();
//        regularStudent.attendClass();
    }
}
