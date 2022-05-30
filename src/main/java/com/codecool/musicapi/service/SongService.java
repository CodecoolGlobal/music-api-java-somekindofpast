package com.codecool.musicapi.service;

import com.codecool.musicapi.DTO.SongDTO;
import com.codecool.musicapi.entity.Song;
import com.codecool.musicapi.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongService {
    private SongRepository songRepository;

    @Autowired
    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public List<Song> findAll() {
        return songRepository.findAll();
    }

    public Optional<Song> findById(Long id) {
        return songRepository.findById(id);
    }

    public Song save(SongDTO song) {
        Song newSong = new Song();
        newSong.setTitle(song.getTitle());
        newSong.setAlbum(findById(song.getAlbum_id()).orElseThrow().getAlbum());
        newSong.setGenre(findById(song.getGenre_id()).orElseThrow().getGenre());
        return songRepository.save(newSong);
    }

    public Song update(Long id, String title) {
        Song songToUpdate = songRepository.getReferenceById(id);
        songToUpdate.setTitle(title);
        return songRepository.save(songToUpdate);
    }
}
