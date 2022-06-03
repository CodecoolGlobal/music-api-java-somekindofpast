package com.codecool.musicapi.controller;

import com.codecool.musicapi.DTO.SongDTO;
import com.codecool.musicapi.entity.Song;
import com.codecool.musicapi.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SongController {
    private SongService songService;

    @Autowired
    public SongController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping("/songs")
    public List<Song> findAll() {
        return songService.findAll();
    }

    @GetMapping("/song/{id}")
    public Optional<Song> findById(@PathVariable("id") Long id) {
        return songService.findById(id);
    }

    @PostMapping("/songs")
    public Song save(@RequestBody SongDTO song) { return songService.save(song); }

    @PutMapping("/song/{id}")
    public Song update(@PathVariable("id") Long id, @RequestBody SongDTO song) { return songService.update(id, song); }

    @DeleteMapping("/song/{id}")
    public void delete(@PathVariable("id") Long id) { songService.delete(id); }
}
