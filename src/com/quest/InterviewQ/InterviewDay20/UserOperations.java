package com.quest.InterviewQ.InterviewDay20;

public interface UserOperations
{
    void createNewPlaylist(String playlistName);
    void deletePlaylist(String playlistName);
    Playlist getPlaylistByName(String playlistName);
    void displayAllPlaylists();
    void markFavorite(Track track);
    void unmarkFavorite(Track track);
    void displayAllFavorites();
}
