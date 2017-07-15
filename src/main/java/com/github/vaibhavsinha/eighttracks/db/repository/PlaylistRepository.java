package com.github.vaibhavsinha.eighttracks.db.repository;

import com.github.vaibhavsinha.eighttracks.db.entity.Playlist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by vaibhav on 15/07/17.
 */
public interface PlaylistRepository extends JpaRepository<Playlist, Long> {

    Playlist findByName(String name);
    Page<Playlist> findAll(Pageable pageable);
    Page<Playlist> findByDeleted(boolean deleted, Pageable pageable);
    Playlist findByIdAndDeleted(Long id, boolean deleted);
    @Query(value = "SELECT *, (likes * 2 + plays) as priority FROM playlist p where p.id in (select playlist_id from playlist_tags where tags_name in ?1 group by playlist_id having count(playlist_id) = ?2 ) order by priority DESC limit ?4 offset ?3", nativeQuery = true)
    List<Playlist> findByTags(List<String> tags, Integer size, Integer offset, Integer limit);
}
