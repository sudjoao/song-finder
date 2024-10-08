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
    int durationInSeconds;
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(
            name = "song_artist",
            joinColumns = @JoinColumn(name = "song_id"),
            inverseJoinColumns = @JoinColumn(name = "artist_id")
    )
    List<Artist> artists;

    public Song() {}

    public Song(String name, int durationInSeconds, List<Artist> artists) {
        this.name = name;
        this.durationInSeconds = durationInSeconds;
        this.artists = artists;
    }

    @Override
    public String toString() {
        return "Song: " + name +
                " | Duration: " + (durationInSeconds / 60) + "m " + (durationInSeconds % 60) + "s" +
                " | Artists: " + artists.stream().map(Artist::getName).toList();
    }
}
