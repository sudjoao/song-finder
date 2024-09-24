package com.sudjoao.song_finder.service;

import com.sudjoao.song_finder.models.Artist;
import com.sudjoao.song_finder.models.Gender;
import com.sudjoao.song_finder.repository.ArtistRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuService {
    Scanner scanner = new Scanner(System.in);
    ArtistRepository artistRepository;

    public MenuService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
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
}
