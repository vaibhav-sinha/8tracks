package com.github.vaibhavsinha.eighttracks.controller;

import com.github.vaibhavsinha.eighttracks.db.entity.Playlist;
import com.github.vaibhavsinha.eighttracks.db.repository.PlaylistRepository;
import com.github.vaibhavsinha.eighttracks.exception.ApiErrorResponse;
import com.github.vaibhavsinha.eighttracks.exception.ApplicationException;
import com.github.vaibhavsinha.eighttracks.pojo.PlaylistCreateOrUpdateRequest;
import com.github.vaibhavsinha.eighttracks.service.PlaylistService;
import com.github.vaibhavsinha.eighttracks.validations.PlaylistRequestValidator;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by vaibhav on 15/07/17.
 */
@RestController
@RequestMapping("/playlists")
public class PlaylistController {

    @Autowired
    PlaylistService playlistService;

    @Autowired
    Mapper mapper;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Playlist createPlaylist(@RequestBody PlaylistCreateOrUpdateRequest request) {
        return playlistService.createPlaylist(mapper.map(request, Playlist.class));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Playlist updatePlaylist(@PathVariable Long id, @RequestBody PlaylistCreateOrUpdateRequest request) {
        request.setId(id);
        return playlistService.updatePlaylist(mapper.map(request, Playlist.class));
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Playlist> listPlaylists(@RequestParam Integer page, @RequestParam Integer size, @RequestParam(required = false, defaultValue = "false") Boolean deleted) {
        return playlistService.listPlaylist(page, size, deleted);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Playlist getPlaylist(@PathVariable Long id, @RequestParam(required = false, defaultValue = "false") Boolean deleted) {
        return playlistService.getPlaylist(id, deleted);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Playlist deletePlaylist(@PathVariable Long id) {
        return playlistService.deletePlaylist(id);
    }

}
