package com.github.vaibhavsinha.eighttracks.db.repository;

import com.github.vaibhavsinha.eighttracks.db.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by vaibhav on 15/07/17.
 */
public interface TagRepository extends JpaRepository<Tag, Long> {
}
