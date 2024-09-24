package com.sudjoao.song_finder.repository;

import com.sudjoao.song_finder.models.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {
}
