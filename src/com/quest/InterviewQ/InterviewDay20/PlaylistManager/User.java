package com.quest.InterviewQ.InterviewDay20.PlaylistManager;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class User implements UserOperations
{
    private String username;
    HashMap<String, Playlist> playlistMap;
    private Set<Track> favouriteTracks;

    public User(String username) {
        this.username = username;
        this.playlistMap = new HashMap<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    @Override
    public void createNewPlaylist(String playlistName)
    {
        if(!playlistMap.containsKey(playlistName))
        {
            playlistMap.put(playlistName, new Playlist(playlistName));
            System.out.println("Playlist created: " + playlistName+"\n");
        }
        else
        {
            System.out.println("Playlist already exists...\n");
        }
    }


    @Override
    public void deletePlaylist(String playlistName)
    {
        if(playlistMap.containsKey(playlistName))
        {
            playlistMap.remove(playlistName); //removing by key(name)
            System.out.println("Playlist "+playlistName+" deleted successfully...\n");
        }
        else
            System.out.println("Playlist does not exist...\n");
    }

    @Override
    public Playlist getPlaylistByName(String playlistName)
    {
        Playlist retrievedPlaylist=null;
        if(playlistMap.containsKey(playlistName))
        {
            retrievedPlaylist = playlistMap.get(playlistName);
        }
        else
            return null;
        return retrievedPlaylist;
    }

    @Override
    public void displayAllPlaylists()
    {
        if(playlistMap.isEmpty())
            System.out.println("No playlists exist...\n");
        else
        {
            System.out.println("**********************************************************************************");
            System.out.println("Playlists of user "+username+" : ");
            for(Map.Entry<String, Playlist> entry : playlistMap.entrySet())
            {
                System.out.println("Playlist name["+entry.getKey() + "] : ");
                entry.getValue().displayAllTracks();
            }
            System.out.println("**********************************************************************************");
        }
    }

    @Override
    public void markFavorite(Track track) {
        favouriteTracks.add(track);
        System.out.println("Track added to favourites...");
    }

    @Override
    public void unmarkFavorite(Track track) {
        favouriteTracks.add(track);
        System.out.println("Track added to favourites...");
    }

    @Override
    public void displayAllFavorites() {
        if(favouriteTracks.isEmpty())
        {
            System.out.println("No favourite tracks exist...\n");
        }
        else
        {
            System.out.println("Favourite tracks : ");
            for (Track track : favouriteTracks)
            {
                System.out.println(track);
            }
        }
    }



}
