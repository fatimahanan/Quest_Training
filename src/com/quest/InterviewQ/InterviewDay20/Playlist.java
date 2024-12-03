package com.quest.InterviewQ.InterviewDay20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;

public class Playlist implements PlaylistOperations
{
    private String name;
    private ArrayList<Track> tracks;

    public Playlist(String name) {
        this.name = name;
        this.tracks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Track> getTracks() {
        return tracks;
    }

    public void setTracks(Track tracks) {
        this.tracks.add(tracks);
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "name='" + name + '\'' +
                ", tracks=" + tracks +
                '}';
    }

    public void addTrack(Track track) throws DuplicateTrackException
    {
        if(tracks.contains(track))
            throw new DuplicateTrackException("Exception! Track already exists...");
        else
            tracks.add(track);
    }

    @Override
    public void removeTrack(Track track) throws NoSuchElementException
    {
        if(!tracks.contains(track))
            throw new NoSuchElementException("Exception! Track does not exist...");
        else
            tracks.remove(track);
    }

    @Override
    public ArrayList<Track> searchTrack(String searchKeyword)  //if matching with track name or artist
    {
        ArrayList<Track> matchingTracks = new ArrayList<>();
        for(Track track : tracks)
        {
            if(track.getTitle().equalsIgnoreCase(searchKeyword) || track.getArtist().equalsIgnoreCase(searchKeyword))
            {
                matchingTracks.add(track);
            }
        }
        if(matchingTracks.isEmpty())
        {
            System.out.println("Oops! No track found...");
        }
        return matchingTracks;
    }

    @Override
    public void displayAllTracks()
    {
        for(Track track : tracks)
        {
            System.out.println(track);
        }
    }

    @Override
    public ArrayList<Track> sortTracksBy(String key)
    {
        if(key.equalsIgnoreCase("title"))
            tracks.sort(new SortByTitleComparator());
        else if(key.equalsIgnoreCase("duration"))
            tracks.sort(new SortByDurationComparator());
        else
            System.out.println("Oops! Can only sort by title/duration...");
        return tracks;
    }

    @Override
    public ArrayList<Track> shuffleTracks()
    {
        Collections.shuffle(tracks);
        return tracks;
    }

    @Override
    public void rateTrack(int trackId, int rating)
    {
        if(rating<1 || rating>5)
        {
            System.out.println("Oops! Rating is out of range...");
            return;
        }
        for(Track track : tracks)
        {
            if(track.getId() == trackId)
            {
                track.setRating(rating);
                System.out.println("Rated " + track.getTitle()+" with "+rating+" star rating");
                return;
            }
        }
        System.out.println("Oops! Track not found...");
    }


}
