package com.github.vaibhavsinha.eighttracks.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

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
}
