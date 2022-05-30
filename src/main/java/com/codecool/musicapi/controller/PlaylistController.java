package com.codecool.musicapi.controller;

import com.codecool.musicapi.entity.Playlist;
import com.codecool.musicapi.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PlaylistController {
    private PlaylistService playlistService;

    @Autowired
    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @GetMapping("/playlists")
    public List<Playlist> findAll() { return playlistService.findAll(); }

    @GetMapping("/playlist/{id}")
    public Optional<Playlist> findById(@PathVariable("id") Long id) { return playlistService.findById(id); }
}
