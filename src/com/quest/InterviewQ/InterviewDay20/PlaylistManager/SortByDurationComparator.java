package com.quest.InterviewQ.InterviewDay20.PlaylistManager;

import java.util.Comparator;

public class SortByDurationComparator implements Comparator<Track>
{
    @Override
    public int compare(Track t1, Track t2) {
        double d1 = t1.getDuration();
        double d2 = t2.getDuration();
        //ascending
        if(d1 > d2)
            return 1;
        else if(d1 < d2)
            return -1;
        else //equal duration
            return 0;
    }
}
