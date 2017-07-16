package com.github.vaibhavsinha.eighttracks.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by vaibhav on 15/07/17.
 */
@Data
public class PlaylistCreateOrUpdateRequest implements Serializable {
    Long id;
    String name;
    List<String> tags;
    Integer likes;
    Integer plays;

    public List<String> getTags() {
        Set<String> set = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        set.addAll(tags);
        return new ArrayList<>(set);
    }
}
