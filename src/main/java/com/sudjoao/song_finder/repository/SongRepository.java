package com.sudjoao.song_finder.repository;

import com.sudjoao.song_finder.models.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SongRepository extends JpaRepository<Song, Long> {
    @Query("SELECT s from Song s WHERE s.name ILIKE %:name%")
    List<Song> findByPartialName(String name);

    @Query("SELECT s from Song s WHERE s.durationInSeconds <= :duration")
    List<Song> findByDurationLessThan(int duration);
}
