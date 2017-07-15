package com.github.vaibhavsinha.eighttracks.pojo;

import com.github.vaibhavsinha.eighttracks.db.entity.Playlist;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by vaibhav on 15/07/17.
 */
@Data
@AllArgsConstructor
public class ExploreResponse implements Serializable {
    List<String> tags;
    List<Playlist> playlists;
}
