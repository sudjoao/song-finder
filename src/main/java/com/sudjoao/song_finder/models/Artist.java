package com.sudjoao.song_finder.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "artists")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    List<Gender> genderList;
    @ManyToMany
    List<Song> songList;


    public Artist() {
    }

    public Artist(String name, List<Gender> genderList) {
        this.name = name;
        this.genderList = genderList;
    }

}
