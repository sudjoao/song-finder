package com.sudjoao.song_finder;

import com.sudjoao.song_finder.repository.ArtistRepository;
import com.sudjoao.song_finder.repository.SongRepository;
import com.sudjoao.song_finder.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SongFinderApplication implements CommandLineRunner {

	@Autowired
	private ArtistRepository artistRepository;

	@Autowired
	private SongRepository songRepository;

	public static void main(String[] args) {
		SpringApplication.run(SongFinderApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		MenuService menuService = new MenuService(artistRepository, songRepository);
		menuService.run();
	}
}
