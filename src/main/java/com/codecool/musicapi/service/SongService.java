package com.codecool.musicapi.service;

import com.codecool.musicapi.DTO.SongDTO;
import com.codecool.musicapi.entity.Song;
import com.codecool.musicapi.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongService {
    private SongRepository songRepository;
    private GenreRepository genreRepository;
    private AlbumRepository albumRepository;

    @Autowired
    public SongService(SongRepository songRepository, GenreRepository genreRepository, AlbumRepository albumRepository) {
        this.songRepository = songRepository;
        this.genreRepository = genreRepository;
        this.albumRepository = albumRepository;
    }

    public List<Song> findAll() {
        return songRepository.findAll();
    }

    public Optional<Song> findById(Long id) {
        return songRepository.findById(id);
    }

    public Song save(SongDTO song) {
        return songRepository.save(entityFromDTO(song));
    }

    public Song update(Long id, SongDTO song) {
        Song songToUpdate = findById(id).orElseThrow();
        Song newSong = entityFromDTO(song);
        songToUpdate.setTitle(newSong.getTitle());
        songToUpdate.setGenre(newSong.getGenre());
        songToUpdate.setAlbum(newSong.getAlbum());
        return songRepository.save(songToUpdate);
    }

    private Song entityFromDTO(SongDTO song) {
        Song newSong = new Song();

        newSong.setTitle(song.getTitle());
        newSong.setGenre(genreRepository.findById(song.getGenre_id()).orElseThrow());
        newSong.setAlbum(albumRepository.findById(song.getAlbum_id()).orElseThrow());

        return newSong;
    }

    public void delete(Long id) {
        songRepository.delete(findById(id).orElseThrow());
    }
}
