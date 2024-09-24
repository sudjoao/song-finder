package com.sudjoao.song_finder.repository;

import com.sudjoao.song_finder.models.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
}
