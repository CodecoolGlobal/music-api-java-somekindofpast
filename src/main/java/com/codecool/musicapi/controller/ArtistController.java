package com.codecool.musicapi.controller;

import com.codecool.musicapi.DTO.ArtistDTO;
import com.codecool.musicapi.entity.Artist;
import com.codecool.musicapi.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ArtistController {
    private ArtistService artistService;

    @Autowired
    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping("/artists")
    public List<Artist> findAll() {
        return artistService.findAll();
    }

    @GetMapping("/artist/{id}")
    public Optional<Artist> findById(@PathVariable("id") Long id) {
        return artistService.findById(id);
    }

    @PostMapping("/artists")
    public Artist save(@RequestBody ArtistDTO artist) { return artistService.save(artist); }

    @PutMapping("/artist/{id}")
    public Artist update(@PathVariable("id") Long id, @RequestBody ArtistDTO artist) { return artistService.update(id, artist); }
}
