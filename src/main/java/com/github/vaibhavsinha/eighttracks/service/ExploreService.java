package com.github.vaibhavsinha.eighttracks.service;

import com.github.vaibhavsinha.eighttracks.db.entity.Playlist;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * Created by vaibhav on 15/07/17.
 */
public interface ExploreService {
    List<Playlist> findPlaylistsWithAllTags(List<String> tags, PageRequest pageRequest);
}
