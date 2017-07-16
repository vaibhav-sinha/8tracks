package com.github.vaibhavsinha.eighttracks.pojo;

import com.github.vaibhavsinha.eighttracks.db.entity.Playlist;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created by vaibhav on 15/07/17.
 */
@Data
@AllArgsConstructor
public class ExploreResponse implements Serializable {
    Set<String> tags;
    List<Playlist> playlists;
}
