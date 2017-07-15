package com.github.vaibhavsinha.eighttracks.service;

import com.github.vaibhavsinha.eighttracks.db.entity.Playlist;
import com.github.vaibhavsinha.eighttracks.db.entity.Tag;
import com.github.vaibhavsinha.eighttracks.db.repository.PlaylistRepository;
import com.github.vaibhavsinha.eighttracks.db.repository.TagRepository;
import com.github.vaibhavsinha.eighttracks.exception.ApiErrorResponse;
import com.github.vaibhavsinha.eighttracks.exception.ApplicationException;
import com.github.vaibhavsinha.eighttracks.validations.PlaylistRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by vaibhav on 15/07/17.
 */
@Component
public class PlaylistServiceImpl implements PlaylistService {

    @Autowired
    PlaylistRepository playlistRepository;

    @Autowired
    TagRepository tagRepository;

    @Autowired
    PlaylistRequestValidator playlistRequestValidator;


    @Override
    public Playlist createPlaylist(Playlist playlist) {
        playlistRequestValidator.validatePlaylistCreateRequest(playlist);
        List<Tag> tags = tagRepository.save(playlist.getTags());
        playlist.setTags(tags);
        playlist.setDeleted(false);
        playlist.setLikes(0);
        playlist.setPlays(0);
        playlist = playlistRepository.save(playlist);
        return playlist;
    }

    @Override
    public Playlist updatePlaylist(Playlist playlist) {
        Playlist existing = playlistRequestValidator.validatePlaylistUpdateRequest(playlist, playlist.getId());
        List<Tag> tags = tagRepository.save(playlist.getTags());
        playlist.setTags(tags);
        return playlistRepository.save(playlist);
    }

    @Override
    public List<Playlist> listPlaylist(Integer page, Integer size, boolean deleted) {
        PageRequest pageRequest = new PageRequest(page, size);
        Page<Playlist> playlistPage;
        if(!deleted) {
            playlistPage = playlistRepository.findByDeleted(false, pageRequest);
        }
        else {
            playlistPage = playlistRepository.findAll(pageRequest);
        }
        return playlistPage.getContent();
    }

    @Override
    public Playlist deletePlaylist(Long id) {
        Playlist playlist = playlistRequestValidator.validatePlaylistDeleteRequest(id);
        playlist.setDeleted(true);
        return playlistRepository.save(playlist);
    }

    @Override
    public Playlist getPlaylist(Long id, boolean deleted) {
        Playlist existing;
        if(!deleted) {
            existing = playlistRepository.findByIdAndDeleted(id, false);
        }
        else {
            existing = playlistRepository.findOne(id);
        }
        if(existing == null) {
            throw new ApplicationException(ApiErrorResponse.ApiErrorResponseCode.NOT_FOUND, "Playlist does not exist", HttpStatus.NOT_FOUND);
        }
        return existing;
    }
}
