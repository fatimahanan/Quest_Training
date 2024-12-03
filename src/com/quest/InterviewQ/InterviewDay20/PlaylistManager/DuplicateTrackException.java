package com.quest.InterviewQ.InterviewDay20.PlaylistManager;

public class DuplicateTrackException extends Exception
{
    public DuplicateTrackException(String message)
    {
        super(message+"\n");
    }
}
