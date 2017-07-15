package com.github.vaibhavsinha.eighttracks.service;

import com.github.vaibhavsinha.eighttracks.db.entity.Playlist;
import com.github.vaibhavsinha.eighttracks.db.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by vaibhav on 15/07/17.
 */
@Component
public class ExploreServiceImpl implements ExploreService {

    @Autowired
    PlaylistRepository playlistRepository;

    @Override
    public List<Playlist> findPlaylistsWithAllTags(List<String> tags, PageRequest pageRequest) {
        return playlistRepository.findByTags(tags, tags.size(), pageRequest.getOffset(), pageRequest.getPageSize());
    }
}
