package com.sudjoao.song_finder.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "songs")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    int durationInMinutes;
    @ManyToMany
    List<Artist> artist;
}
