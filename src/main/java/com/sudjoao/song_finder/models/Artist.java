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
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "artists")
    List<Song> songList;


    public Artist() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Gender> getGenderList() {
        return genderList;
    }

    public List<Song> getSongList() {
        return songList;
    }

    public Artist(String name, List<Gender> genderList) {
        this.name = name;
        this.genderList = genderList;
    }

    @Override
    public String toString() {
        return "Artist: " + name +
                " | Genres: " + genderList.size() +
                " | Songs: " + songList.size();
    }
}
