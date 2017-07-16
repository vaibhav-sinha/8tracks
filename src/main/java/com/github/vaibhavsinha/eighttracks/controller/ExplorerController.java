package com.github.vaibhavsinha.eighttracks.controller;

import com.github.vaibhavsinha.eighttracks.db.entity.Playlist;
import com.github.vaibhavsinha.eighttracks.pojo.ExploreResponse;
import com.github.vaibhavsinha.eighttracks.service.ExploreService;
import com.github.vaibhavsinha.eighttracks.util.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * Created by vaibhav on 15/07/17.
 */
@RestController
public class ExplorerController {

    @Autowired
    ExploreService exploreService;

    @RequestMapping(value = "/explore", method = RequestMethod.GET)
    public ExploreResponse explore(@RequestParam("tag") String[] tags, @RequestParam Integer page, @RequestParam Integer size) {
        List<String> tagList = Arrays.asList(tags);
        PageRequest pageRequest = new PageRequest(page, size);
        List<Playlist> playlists = exploreService.findPlaylistsWithAllTags(tagList, pageRequest);
        List<Playlist> allPlaylists = exploreService.findPlaylistsWithAllTags(tagList, null);
        Set<String> tagSet = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        tagSet.addAll(tagList);
        Set<String> subTags = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        allPlaylists.forEach(playlist -> {
            playlist.getTags().forEach(tag -> {
                if(!tagSet.contains(tag.getName()) && !subTags.contains(tag.getName())) {
                    subTags.add(tag.getName());
                }
            });
        });
        return new ExploreResponse(subTags, playlists);
    }
}
