package com.codecool.musicapi.controller;

import com.codecool.musicapi.entity.Album;
import com.codecool.musicapi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class AlbumController {
    private AlbumService albumService;

    @Autowired
    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping("/albums")
    public List<Album> findAll() {
        return albumService.findAll();
    }

    @GetMapping("/album/{id}")
    public Optional<Album> findById(@PathVariable("id") Long id) {
        return albumService.findById(id);
    }
}
