package com.github.vaibhavsinha.eighttracks.db.entity;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.List;

/**
 * Created by vaibhav on 15/07/17.
 */
@Entity
@Data
public class Playlist extends AuditableEntity implements Serializable {

    @Column(unique = true)
    private String name;

    @ManyToMany
    private List<Tag> tags;

    private Integer likes;

    private Integer plays;

    private boolean deleted;
}
