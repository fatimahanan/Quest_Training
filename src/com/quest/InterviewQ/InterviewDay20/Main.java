package com.quest.InterviewQ.InterviewDay20;

import java.util.HashMap;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws DuplicateTrackException {
        Scanner sc = new Scanner(System.in);
        HashMap<String,User> users = new HashMap<>();
        User newUser=null;
        try
        {
            newUser = new User("Hanan");
            newUser.createNewPlaylist("golden hits");
            newUser.createNewPlaylist("party songs");
            newUser.createNewPlaylist("country music");

            Playlist goldenHits = newUser.getPlaylistByName("golden hits");
            goldenHits.addTrack(new Track(1, "Dancing Queen", "ABBA", 4.20));
            goldenHits.addTrack(new Track(2, "Hey Jude", "The Beatles", 3.50));
            Playlist partySongs = newUser.getPlaylistByName("party songs");
            partySongs.addTrack(new Track(3, "We Found Love", "Rihanna", 3));
            Playlist countryMusic = newUser.getPlaylistByName("country music");
            countryMusic.addTrack(new Track(4, "Take me home, country roads", "John Dennver", 5.10));
            newUser.displayAllPlaylists();
        }
        catch (DuplicateTrackException e)
        {
            System.out.println("Duplicate track");
            e.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        while(true)
        {
            System.out.println("1.  Create user");
            System.out.println("2.  Create playlist");
            System.out.println("3.  Delete playlist");
            System.out.println("4.  Get playlist by name");
            System.out.println("5.  Display all playlists");
            System.out.println("6.  Rate tracks of a playlist");
            System.out.println("7.  Mark favourite track");
            System.out.println("8.  Unmark favourite track");
            System.out.println("9.  Display favourites tracks of user");
            System.out.println("10. Add new track in playlist");
            System.out.println("11. Remove track from playlist");
            System.out.println("12. Search track by name/artist");
            System.out.println("13. Display all tracks");
            System.out.println("14. Sort tracks by duration/title");
            System.out.println("15. Shuffle tracks");
            System.out.println("16. Exit");
            System.out.println("\nEnter your choice : ");
            int ch=sc.nextInt();
            switch(ch)
            {
                case 1: //create user
                    System.out.println("Enter username : ");
                    String username = sc.nextLine();
                    sc.nextLine();
                    if(!users.containsKey(username))
                    {
                        newUser=new User(username);
                        users.put(username,newUser);
                        System.out.println("User created successfully...");
                    }
                    else
                    {
                        System.out.println("User already exists...");
                    }
                    break;

                case 2: //create playlist for user
                    if(newUser==null)
                    {
                        System.out.println("User not found, cannot create playlist...");
                    }
                    else
                    {
                        System.out.println("Enter playlist name : ");
                        String createplaylistName = sc.nextLine();
                        sc.nextLine();
                        newUser.createNewPlaylist(createplaylistName);
                        System.out.println("Playlist created successfully...");
                    }
                    break;

                case 3: //delete playlist
                    if(newUser==null)
                    {
                        System.out.println("User not found, cannot delete playlist...");
                    }
                    else
                    {
                        System.out.println("Enter playlist name to delete : ");
                        String deleteplaylistName = sc.nextLine();
                        newUser.deletePlaylist(deleteplaylistName);
                        System.out.println("Playlist deleted successfully...");
                    }
                    break;

                case 4: //get playlist by name
                    if(newUser==null)
                    {
                        System.out.println("User not found, cannot find playlist...");
                    }
                    else
                    {
                        System.out.println("Enter playlist name to find : ");
                        String findplaylistName = sc.nextLine();
                        Playlist foundPlaylist=newUser.getPlaylistByName(findplaylistName);
                        if(foundPlaylist!=null)
                            foundPlaylist.displayAllTracks();
                        else
                            System.out.println("Playlist not found...");
                    }
                    break;

                case 5: //display all playlists
                    if(newUser==null)
                    {
                        System.out.println("User not found, cannot find playlists...");
                    }
                    else
                    {
                        newUser.displayAllPlaylists();
                    }
                    break;

                case 6: //rate tracks of a playlist
                    if(newUser==null)
                    {
                        System.out.println("User not found, cannot find playlists...");
                    }
                    else
                    {
                        System.out.println("Enter playlist in which track is present : ");
                        String ratingplaylistName = sc.nextLine();
                        Playlist ratingPlaylist=newUser.getPlaylistByName(ratingplaylistName);
                        if(ratingPlaylist!=null)
                        {
                            System.out.println("Enter track id to rate : ");
                            int rateTrackid = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Enter rating from 1-5 : ");
                            int rating=sc.nextInt();
                            ratingPlaylist.rateTrack(rateTrackid,rating);
                        }
                        break;
                    }
                    case 7: //mark favourite
                        System.out.print("Enter playlist name: ");
                        String playlistForFavorite = sc.nextLine();
                        Playlist favoritePlaylist = newUser.getPlaylistByName(playlistForFavorite);
                        if (favoritePlaylist != null) {
                            System.out.print("Enter track ID to mark as favorite: ");
                            int favoriteTrackId = sc.nextInt();
                            for (Track track : favoritePlaylist.getTracks())
                            {
                                if (track.getId() == favoriteTrackId)
                                {
                                    newUser.markFavorite(track);
                                    break;
                                }
                            }
                        }
                        break;

                    case 8: //unmark fav
                        System.out.print("Enter playlist name: ");
                        String playlistForUnmark = sc.nextLine();
                        Playlist unmarkFavoritePlaylist = newUser.getPlaylistByName(playlistForUnmark);
                        if (unmarkFavoritePlaylist != null)
                        {
                            System.out.print("Enter track ID to unmark as favorite: ");
                            int unmarkTrackId = sc.nextInt();
                            for (Track track : unmarkFavoritePlaylist.getTracks())
                            {
                                if (track.getId() == unmarkTrackId) {
                                    newUser.unmarkFavorite(track);
                                    break;
                                }
                            }
                        }
                        break;

                    case 9: //displayAllFavouriteTrcaks
                        newUser.displayAllFavorites();
                        break;

                    case 10: //add new track
                        System.out.print("Enter playlist name to add track for : ");
                        String playlistForAdd = sc.nextLine();
                        Playlist addTrackPlaylist = newUser.getPlaylistByName(playlistForAdd);
                        if (addTrackPlaylist != null)
                        {
                            System.out.print("Enter track ID: ");
                            int trackId = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Enter track title: ");
                            String trackTitle = sc.nextLine();
                            System.out.print("Enter track artist: ");
                            String trackArtist = sc.nextLine();
                            System.out.print("Enter track duration: ");
                            double trackDuration = sc.nextDouble();
                            addTrackPlaylist.addTrack(new Track(trackId, trackTitle, trackArtist, trackDuration));
                        }
                        break;

                    case 11: //remove track
                        System.out.print("Enter playlist name to remove track: ");
                        String removeTrackPlaylistName = sc.nextLine();
                        Playlist removeTrackPlaylist = newUser.getPlaylistByName(removeTrackPlaylistName);
                        if (removeTrackPlaylist != null)
                        {
                            System.out.print("Enter track ID to remove: ");
                            int removeTrackId = sc.nextInt();
                            Track removeTrack=new Track(removeTrackId,"","",0);
                            removeTrackPlaylist.removeTrack(removeTrack);
                        }
                        break;

                    case 12: //search
                        System.out.print("Enter track name or artist to search: ");
                        String searchKeyword = sc.nextLine();
                        for (Playlist playlistSearch : newUser.playlistMap.values())
                        {
                            playlistSearch.searchTrack(searchKeyword);
                        }
                        break;

                    case 13://display
                        System.out.println("Displaying all tracks in all playlists:");
                        newUser.displayAllPlaylists();
                        break;

                    case 14: //sort track
                        System.out.print("Enter either 'duration' or 'title' to sort by: ");
                        String sortBy = sc.nextLine();
                        for (Playlist playlistSort : newUser.playlistMap.values()) {
                            playlistSort.sortTracksBy(sortBy);
                        }
                        break;

                    case 15: //shuffle track
                        System.out.print("Enter playlist name to shuffle tracks: ");
                        String shufflePlaylistName = sc.nextLine();
                        Playlist shufflePlaylist = newUser.getPlaylistByName(shufflePlaylistName);
                        if (shufflePlaylist != null)
                        {
                            shufflePlaylist.shuffleTracks();
                            System.out.println("Tracks shuffled in playlist: " + shufflePlaylistName);
                        }
                        break;

                    case 16:
                        System.out.print("Enter username to select: ");
                        String selectedUsername = sc.nextLine();
                        if (users.containsKey(selectedUsername))
                        {
                            newUser = users.get(selectedUsername);
                            System.out.println("User " + selectedUsername + " selected.");
                        } else {
                            System.out.println("User not found.");
                        }

                    case 17: //exit
                        System.out.print("exiting...");
                        break;
            }
        }

    }
}
