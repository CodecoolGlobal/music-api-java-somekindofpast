package com.codecool.musicapi.controller;

import com.codecool.musicapi.DTO.PlaylistDTO;
import com.codecool.musicapi.entity.Playlist;
import com.codecool.musicapi.entity.Song;
import com.codecool.musicapi.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/playlists/{playlist_id}/songs")
    public List<Song> findAllSongsByPlaylistId(@PathVariable("playlist_id") Long playlistId) {
        return playlistService.findAllSongsByPlaylistId(playlistId);
    }

    @GetMapping("/playlists/{playlist_id}/songs/{song_id}")
    public Song findSongByPlaylist(@PathVariable("playlist_id") Long playlistId, @PathVariable("song_id") Long songId) {
        return playlistService.findSongByPlaylist(playlistId, songId);
    }

    @PostMapping("/playlists")
    public Playlist save(@RequestBody PlaylistDTO playlist) { return playlistService.save(playlist); }

    @PutMapping("/playlist/{id}")
    public Playlist update(@PathVariable("id") Long id, @RequestBody PlaylistDTO playlist) { return playlistService.update(id, playlist); }
}
