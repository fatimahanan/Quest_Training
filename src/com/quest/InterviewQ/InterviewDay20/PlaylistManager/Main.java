package com.quest.InterviewQ.InterviewDay20.PlaylistManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws DuplicateTrackException
    {
        Scanner sc = new Scanner(System.in);
//        HashMap<String, User> users = new HashMap<>(); //mapping username to user's playlist and other details
        UserManager userManager = new UserManager();
        User newUser=null;
        try
        {
            newUser = userManager.createUser("Hanan");
            newUser.createNewPlaylist("golden hits");
            newUser.createNewPlaylist("party songs");
            newUser.createNewPlaylist("country music");

            Playlist goldenHits = newUser.getPlaylistByName("golden hits");
            goldenHits.addTrack(new Track(1, "Dancing Queen", "ABBA", 4.20));
            goldenHits.addTrack(new Track(2, "Hey Jude", "The Beatles", 3.50));
            goldenHits.addTrack(new Track(3,"Yesterday","The Beatles",3.27));
            Playlist partySongs = newUser.getPlaylistByName("party songs");
            partySongs.addTrack(new Track(3, "We Found Love", "Rihanna", 3));
            Playlist countryMusic = newUser.getPlaylistByName("country music");
            countryMusic.addTrack(new Track(4, "Take me home, country roads", "John Dennver", 5.10));
            newUser.displayAllPlaylists();
            goldenHits.sortTracksBy("duration");
            System.out.println(goldenHits);
            goldenHits.rateTrack(1,5);
            System.out.println(goldenHits);
            goldenHits.searchTrack("The Beatles");
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
            System.out.println("\n1.  Create user");
            System.out.println("2.  Create playlist");
            System.out.println("3.  Delete playlist");
            System.out.println("4.  Get playlist by name"); //
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
            System.out.println("16. Select user an display all playlists");
            System.out.println("17. Exit");
            System.out.println("\nEnter your choice : ");
            int ch=sc.nextInt();
            switch(ch)
            {
                case 1: //create user
                    System.out.println("Enter username : ");
                    sc.nextLine();
                    String username = sc.nextLine();
                    if(!userManager.isUserExists(username))
                    {
                        newUser=userManager.createUser(username);
                        System.out.println("User created successfully...");
                        newUser=userManager.getUser(username);
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
                        sc.nextLine();
                        String createplaylistName = sc.nextLine();
                        newUser.createNewPlaylist(createplaylistName);
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
                        sc.nextLine();
                        String deleteplaylistName = sc.nextLine();
                        newUser.deletePlaylist(deleteplaylistName);
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
                        sc.nextLine();
                        String findPlaylistName = sc.nextLine();
                        Playlist foundPlaylist=newUser.getPlaylistByName(findPlaylistName);
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
                        System.out.println("\nPlaylists of user "+newUser.getUsername()+" : ");
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
                        sc.nextLine();
                        String ratingplaylistName = sc.nextLine();
                        Playlist ratingPlaylist=newUser.getPlaylistByName(ratingplaylistName);
                        if(ratingPlaylist!=null)
                        {
                            System.out.println("Enter track id to rate : ");
                            int rateTrackid = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Enter rating from 1-5 : ");
                            int rating=sc.nextInt();
                            sc.nextLine();
                            ratingPlaylist.rateTrack(rateTrackid,rating);
                        }
                        else
                        {
                            System.out.println("Playlist not found...");
                        }
                        break;
                    }
                    case 7: //mark favourite
                        if(newUser==null)
                        {
                            System.out.println("user not found, cannot mark favourite");
                        }
                        else
                        {
                            System.out.print("Enter playlist name: ");
                            sc.nextLine();
                            String playlistForFavorite = sc.nextLine();
                            Playlist favoritePlaylist = newUser.getPlaylistByName(playlistForFavorite);
                            boolean found=false;
                            if (favoritePlaylist != null) {
                                System.out.print("Enter track ID to mark as favorite: ");
                                int favoriteTrackId = sc.nextInt();
                                for (Track track : favoritePlaylist.getTracks()) {
                                    if (track.getId() == favoriteTrackId) {
                                        found=true;
                                        newUser.markFavorite(track);
                                        break;
                                    }
                                }
                                if(!found)
                                  System.out.println("Track not found...");
                            }
                        }
                        break;

                    case 8: //unmark fav
                        if(newUser==null)
                        {
                            System.out.println("User not found, cannot unmark favourite...");
                        }
                        else
                        {
                            System.out.print("Enter playlist name: ");
                            sc.nextLine();
                            String playlistForUnmark = sc.nextLine();
                            Playlist unmarkFavoritePlaylist = newUser.getPlaylistByName(playlistForUnmark);
                            boolean found=false;
                            if (unmarkFavoritePlaylist != null)
                            {
                                System.out.print("Enter track ID to unmark as favorite: ");
                                int unmarkTrackId = sc.nextInt();
                                for (Track track : unmarkFavoritePlaylist.getTracks())
                                {
                                    if (track.getId() == unmarkTrackId)
                                    {
                                        found=true;
                                        newUser.unmarkFavorite(track);
                                        break;
                                    }
                                }
                                if(!found)
                                    System.out.println("Track not found..");
                            }
                        }
                        break;

                    case 9: //displayAllFavouriteTrcaks
                        if(newUser==null)
                            System.out.println("User not found, cannot display favourite tracks...");
                        else
                            newUser.displayAllFavorites();
                        break;

                    case 10: //add new track
                        if(newUser==null)
                        {
                            System.out.println("User not found, cannot add new track...");
                        }
                        else
                        {
                            System.out.print("Enter playlist name to add track for : ");
                            sc.nextLine();
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
                                sc.nextLine();
                                addTrackPlaylist.addTrack(new Track(trackId, trackTitle, trackArtist, trackDuration));
                            }
                            else
                            {
                                System.out.println("Playlist not found...");
                            }
                        }
                        break;

                    case 11: //remove track
                        if(newUser==null)
                        {
                            System.out.println("User not found, cannot remove track...");
                        }
                        else
                        {
                            System.out.print("Enter playlist name to remove track: ");
                            sc.nextLine();
                            String removeTrackPlaylistName = sc.nextLine();
                            Playlist removeTrackPlaylist = newUser.getPlaylistByName(removeTrackPlaylistName);
                            if (removeTrackPlaylist != null)
                            {
                                System.out.print("Enter track ID to remove: ");
                                int removeTrackId = sc.nextInt();
                                Track trackToRemove = new Track(removeTrackId, "", "", 0);
                                if(trackToRemove!=null)
                                    removeTrackPlaylist.removeTrack(trackToRemove);
                                else
                                    System.out.println("Track not found...");
                            }
                            else
                            {
                                System.out.println("Playlist not found...");
                            }
                        }
                        break;

                    case 12: //search
                        if(newUser==null)
                            System.out.println("User not found, cannot search for track...");
                        else
                        {
                            System.out.print("Enter track name or artist to search: ");
                            sc.nextLine();
                            String searchKeyword1 = sc.nextLine();  // Get the search keyword
                            System.out.println("Enter playlist name in which track is present: ");
                            String toSearchInPlaylist = sc.nextLine();  // Get the playlist name
                            Playlist existsInPlaylist=newUser.playlistMap.get(toSearchInPlaylist);
                            ArrayList<Track> containsSearchElement=existsInPlaylist.searchTrack(searchKeyword1);
                            containsSearchElement.forEach(System.out::println);
                        }
                        break;

                    case 13://display all tracks of a certain playlist
                        if(newUser==null)
                            System.out.println("User not found, cannot search for playlist...");
                        else
                        {
                            System.out.print("Enter playlist name : ");
                            sc.nextLine();
                            String playlistNameToFind = sc.nextLine();
                            Playlist playlistToDisplay=newUser.playlistMap.get(playlistNameToFind);
                            System.out.println("Playlist : "+playlistNameToFind);
                            newUser.displayTracksOfPlaylist(playlistNameToFind);
                        }
                        break;

                    case 14: //sort track
                        if(newUser==null)
                            System.out.println("User not found, cannot search for track...");
                        else
                        {
                            System.out.print("Enter either 'duration' or 'title' to sort by : ");
                            sc.nextLine();
                            String sortBy = sc.nextLine();
                            for (Playlist playlistSort : newUser.playlistMap.values()) {
                                playlistSort.sortTracksBy(sortBy);
                            }
                        }
                        break;

                    case 15: //shuffle track
                        if(newUser==null)
                        {
                            System.out.println("User not found, cannot search for track...");
                        }
                        else {
                            System.out.print("Enter playlist name to shuffle tracks: ");
                            sc.nextLine();
                            String shufflePlaylistName = sc.nextLine();
                            Playlist shufflePlaylist = newUser.getPlaylistByName(shufflePlaylistName);
                            if (shufflePlaylist != null) {
                                shufflePlaylist.shuffleTracks();
                                System.out.println("Tracks shuffled in playlist: " + shufflePlaylistName);
                                shufflePlaylist.displayAllTracks();
                            }
                        }
                        break;

                    case 16: //select user
                        System.out.print("Enter username to select: ");
                        sc.nextLine();
                        String selectedUsername = sc.nextLine();
                        if (userManager.isUserExists(selectedUsername))
                        {
                            newUser = userManager.getUser(selectedUsername);
                            System.out.println("User " + selectedUsername + " selected.");
                            newUser.displayAllPlaylists();
                        }
                        else
                        {
                            System.out.println("User not found.");
                        }
                        break;

                    case 17: //display all users
                        userManager.displayAllUsers();
                        break;

                    case 18: //exit
                        System.out.print("exiting...");
                        return;
            }
        }

    }
}
