package com.quest.interviewQ.InterviewDay20.PlaylistManager;

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
