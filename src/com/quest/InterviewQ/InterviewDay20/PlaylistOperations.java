package com.quest.InterviewQ.InterviewDay20;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public interface PlaylistOperations
{
    void addTrack(Track track) throws DuplicateTrackException;
    void removeTrack(Track track) throws NoSuchElementException;
    ArrayList<Track> searchTrack(String searchKeyword);             //searchKeyword (name/artist)
    void displayAllTracks();
    ArrayList<Track> sortTracksBy(String key);                                  //by duration/title
    ArrayList<Track> shuffleTracks();
    void rateTrack(int trackId,int rating);
}
