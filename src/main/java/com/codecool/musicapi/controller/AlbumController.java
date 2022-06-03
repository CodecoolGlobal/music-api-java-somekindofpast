package com.codecool.musicapi.controller;

import com.codecool.musicapi.DTO.AlbumDTO;
import com.codecool.musicapi.entity.Album;
import com.codecool.musicapi.entity.Song;
import com.codecool.musicapi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/albums/{album_id}/songs")
    public List<Song> findAllSongsByAlbumId(@PathVariable("album_id") Long albumId) {
        return albumService.findAllSongsByAlbumId(albumId);
    }

    @GetMapping("/albums/{album_id}/songs/{song_id}")
    public Song findSongByAlbum(@PathVariable("album_id") Long albumId, @PathVariable("song_id") Long songId) {
        return albumService.findSongByAlbum(albumId, songId);
    }

    @PostMapping("/albums")
    public Album save(@RequestBody AlbumDTO album) { return albumService.save(album); }

    @PutMapping("/album/{id}")
    public Album update(@PathVariable("id") Long id, @RequestBody AlbumDTO album) { return albumService.update(id, album); }
}
