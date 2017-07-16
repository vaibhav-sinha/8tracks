package com.github.vaibhavsinha.eighttracks.service;

import com.github.vaibhavsinha.eighttracks.db.entity.Playlist;
import com.github.vaibhavsinha.eighttracks.db.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by vaibhav on 15/07/17.
 */
@Component
public class ExploreServiceImpl implements ExploreService {

    @Autowired
    PlaylistRepository playlistRepository;

    @Override
    public List<Playlist> findPlaylistsWithAllTags(List<String> tags, PageRequest pageRequest) {
        if(pageRequest == null) {
            return playlistRepository.findByTags(tags.stream().map(String::toUpperCase).collect(Collectors.toList()), tags.size());
        }
        else {
            return playlistRepository.findByTags(tags.stream().map(String::toUpperCase).collect(Collectors.toList()), tags.size(), pageRequest.getOffset(), pageRequest.getPageSize());
        }
    }
}
