package com.quest.InterviewQ.InterviewDay20;

import java.util.Comparator;

public class SortByTitleComparator implements Comparator<Track>
{

    @Override
    public int compare(Track t1, Track t2)
    {
        String title1 = t1.getTitle();
        String title2 = t2.getTitle();
        return title1.compareToIgnoreCase(title2); //ascending
    }
}
