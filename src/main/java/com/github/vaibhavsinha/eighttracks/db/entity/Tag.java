package com.github.vaibhavsinha.eighttracks.db.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by vaibhav on 15/07/17.
 */
@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Tag {

    @Id
    @NonNull
    private String name;

}
