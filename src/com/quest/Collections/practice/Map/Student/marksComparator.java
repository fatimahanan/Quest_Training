package com.quest.Collections.practice.Map.Student;

import java.util.Comparator;
import java.util.Map;

public class marksComparator implements Comparator<Map.Entry<Student,Integer>>
{
    @Override
    public int compare(Map.Entry<Student, Integer> o1, Map.Entry<Student, Integer> o2)
    {
        int m1=o1.getValue();
        int m2=o2.getValue();
        if(m1<m2)
            return 1;
        else if(m1>m2)
            return -1;
        else
            return 0;
    }
}
