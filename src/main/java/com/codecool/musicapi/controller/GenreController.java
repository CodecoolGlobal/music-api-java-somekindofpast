package com.codecool.musicapi.controller;

import com.codecool.musicapi.DTO.GenreDTO;
import com.codecool.musicapi.entity.Genre;
import com.codecool.musicapi.entity.Song;
import com.codecool.musicapi.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GenreController {
    private GenreService genreService;

    @Autowired
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping("/genres")
    public List<Genre> findAll() { return genreService.findAll(); }

    @GetMapping("/genre/{id}")
    public Optional<Genre> findById(@PathVariable("id") Long id) { return genreService.findById(id); }

    @GetMapping("/genres/{genre_id}/songs")
    public List<Song> findAllSongsByGenreId(@PathVariable("genre_id") Long genreId) {
        return genreService.findAllSongsByGenreId(genreId);
    }

    @GetMapping("/genres/{genre_id}/songs/{song_id}")
    public Song findSongByGenre(@PathVariable("genre_id") Long genreId, @PathVariable("song_id") Long songId) {
        return genreService.findSongByGenre(genreId, songId);
    }

    @PostMapping("/genres")
    public Genre save(@RequestBody GenreDTO genre) { return genreService.save(genre); }

    @PutMapping("/genre/{id}")
    public Genre update(@PathVariable("id") Long id, @RequestBody GenreDTO genre) { return genreService.update(id, genre); }
}
