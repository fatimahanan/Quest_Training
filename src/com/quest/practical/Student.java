package com.quest.practical;

public class Student
{

    private String rollNumber;
    private String name;
    private String standard;

    public Student(String rollNumber, String name, String standard) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.standard = standard;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNumber='" + rollNumber + '\'' +
                ", name='" + name + '\'' +
                ", standard='" + standard + '\'' +
                '}';
    }
}

