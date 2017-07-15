package com.github.vaibhavsinha.eighttracks.validations;

import com.github.vaibhavsinha.eighttracks.db.entity.Playlist;
import com.github.vaibhavsinha.eighttracks.db.repository.PlaylistRepository;
import com.github.vaibhavsinha.eighttracks.exception.ApiErrorResponse;
import com.github.vaibhavsinha.eighttracks.exception.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Created by vaibhav on 15/07/17.
 */
@Component
public class PlaylistRequestValidator {

    @Autowired
    PlaylistRepository playlistRepository;

    public void validatePlaylistCreateRequest(Playlist playlist) {
        validateIdIsNotPresent(playlist);
        validateNameIsPresent(playlist);
        validateNameIsUnique(playlist, null);
    }

    public Playlist validatePlaylistUpdateRequest(Playlist playlist, Long id) {
        Playlist existing = validatePlaylistExists(id);
        validateNameIsPresent(playlist);
        validateNameIsUnique(playlist, id);
        return existing;
    }

    public Playlist validatePlaylistDeleteRequest(Long id) {
        return validatePlaylistExists(id);
    }

    public Playlist validatePlaylistGetRequest(Long id) {
        return validatePlaylistExists(id);
    }

    private void validateNameIsPresent(Playlist playlist) {
        if(StringUtils.isEmpty(playlist.getName())) {
            throw new ApplicationException(ApiErrorResponse.ApiErrorResponseCode.INVALID_DATA, "name is a required field", HttpStatus.BAD_REQUEST);
        }
    }

    private void validateIdIsNotPresent(Playlist playlist) {
        if(playlist.getId() != null) {
            throw new ApplicationException(ApiErrorResponse.ApiErrorResponseCode.INVALID_DATA, "Cannot provide id in POST request. To update a playlist use PUT.", HttpStatus.BAD_REQUEST);
        }
    }

    private void validateNameIsUnique(Playlist playlist, Long id) {
        Playlist existing = playlistRepository.findByName(playlist.getName());
        if(existing != null && (id == null || !existing.getId().equals(id))) {
            throw new ApplicationException(ApiErrorResponse.ApiErrorResponseCode.INVALID_DATA, "Playlist by this name already exists", HttpStatus.BAD_REQUEST);
        }
    }

    private Playlist validatePlaylistExists(Long id) {
        Playlist existing = playlistRepository.findOne(id);
        if(existing == null) {
            throw new ApplicationException(ApiErrorResponse.ApiErrorResponseCode.NOT_FOUND, "Playlist by this id does not exist", HttpStatus.NOT_FOUND);
        }
        return existing;
    }
}
