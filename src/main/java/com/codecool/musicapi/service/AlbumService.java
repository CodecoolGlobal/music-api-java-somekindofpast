package com.codecool.musicapi.service;

import com.codecool.musicapi.DTO.AlbumDTO;
import com.codecool.musicapi.entity.Album;
import com.codecool.musicapi.entity.Song;
import com.codecool.musicapi.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AlbumService {
    private AlbumRepository albumRepository;

    @Autowired
    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    public List<Album> findAll() {
        return albumRepository.findAll();
    }

    public Optional<Album> findById(Long id) {
        return albumRepository.findById(id);
    }

    public List<Song> findAllSongsByAlbumId(Long albumId) {
        Album album = findById(albumId).orElseThrow();
        return album.getSongs();
    }

    public Song findSongByAlbum(Long albumId, Long songId) {
        List<Song> songs = findAllSongsByAlbumId(albumId);
        if(songs == null)
            return null;

        return songs.stream()
                .filter(s -> Objects.equals(s.getId(), songId))
                .findFirst().orElseThrow();
    }

    public Album save(AlbumDTO album) {
        Album newAlbum = new Album();
        newAlbum.setTitle(album.getTitle());
        return albumRepository.save(newAlbum);
    }

    public Album update(Long id, AlbumDTO album) {
        Album albumToUpdate = findById(id).orElseThrow();
        albumToUpdate.setTitle(album.getTitle());
        return albumRepository.save(albumToUpdate);
    }
}
