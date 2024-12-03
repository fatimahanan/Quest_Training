package com.quest.InterviewQ.InterviewDay20.part2.topKfrequency;

import java.util.Comparator;
import java.util.Map;

public class SortByFreqComparator implements Comparator<Map.Entry<String, Integer>>
{

    @Override
    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2)
    {
        if(Integer.compare(o2.getValue(), o1.getValue())==0) //freq equal
            return o1.getKey().compareTo(o2.getKey()); //compare lexicographically
        else
            return Integer.compare(o2.getValue(), o1.getValue());  //comparing by freq
    }
}
