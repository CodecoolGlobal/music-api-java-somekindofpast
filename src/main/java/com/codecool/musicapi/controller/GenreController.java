package com.codecool.musicapi.controller;

import com.codecool.musicapi.entity.Genre;
import com.codecool.musicapi.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
}
