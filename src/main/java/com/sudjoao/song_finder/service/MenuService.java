package com.sudjoao.song_finder.service;

import com.sudjoao.song_finder.models.Artist;
import com.sudjoao.song_finder.models.Gender;
import com.sudjoao.song_finder.models.Song;
import com.sudjoao.song_finder.repository.ArtistRepository;
import com.sudjoao.song_finder.repository.SongRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class MenuService {
    Scanner scanner = new Scanner(System.in);
    ArtistRepository artistRepository;
    SongRepository songRepository;

    public MenuService(ArtistRepository artistRepository, SongRepository songRepository) {
        this.artistRepository = artistRepository;
        this.songRepository = songRepository;
    }

    public void run(){
        int option = -1;
        while (option != 0) {
            System.out.println("Select an option");
            showOptions();
            option = scanner.nextInt();
            scanner.nextLine();
            handleOption(option);
        }
    }

    private void showOptions() {
        System.out.println("1. Register an artist");
        System.out.println("2. Register a song");
        System.out.println("3. List available artists");
        System.out.println("4. List available songs");
        System.out.println("5. Search about any artist info");
        System.out.println("0. Leave");
    }

    private void handleOption(int option) {
        switch (option){
            case 0:
                System.out.println("Leaving application....");
                break;
            case 1:
                handleRegisterArtist();
                break;
            case 2:
                handleRegisterSong();
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
    }

    void handleRegisterArtist() {
        System.out.println("Type the artist name");
        var name = scanner.nextLine();
        System.out.println("Which are the artist genders? Lets register one by one.");
        List<Gender> genderList = new ArrayList<>();
        int option = -1;
        while (option != 0){
            System.out.println("Select a gender:");
            System.out.println("0 - Leave");
            Gender.listGenders();
            option = scanner.nextInt();
            scanner.nextLine();
            if (option != 0) {
                genderList.add(Gender.fromValue(option));
            }
        }
        Artist artist = new Artist(name, genderList);
        artistRepository.save(artist);
    }

    void handleRegisterSong() {
        System.out.println("Type the song name");
        var name = scanner.nextLine();
        System.out.println("Type the song duration");
        var duration = scanner.nextInt();
        System.out.println("Select the artist(s) that sing this song");
        List<Artist> artists = new ArrayList<>();
        int option = -1;
        while (option != 0){
            System.out.println("Select an artist");
            System.out.println("0 - Leave");
            for(Artist artist : artistRepository.findAll()) {
                System.out.printf("%d - %s\n", artist.getId(), artist.getName());
            }

            option = scanner.nextInt();
            if (option != 0) {
                Optional<Artist> artist = artistRepository.findById(((long) option));
                if (artist.isPresent())
                    artists.add(artist.get());
                else
                    System.out.println("Cannot find the artist");
            }
        }
        Song song = new Song(name, duration, artists);
        songRepository.save(song);
    }
}
