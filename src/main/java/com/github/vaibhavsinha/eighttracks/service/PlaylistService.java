package com.github.vaibhavsinha.eighttracks.service;

import com.github.vaibhavsinha.eighttracks.db.entity.Playlist;

import java.util.List;

/**
 * Created by vaibhav on 15/07/17.
 */
public interface PlaylistService {
    Playlist createPlaylist(Playlist playlist);
    Playlist updatePlaylist(Playlist playlist);
    List<Playlist> listPlaylist(Integer page, Integer size, boolean deleted);
    Playlist deletePlaylist(Long id);
    Playlist getPlaylist(Long id, boolean deleted);
}
