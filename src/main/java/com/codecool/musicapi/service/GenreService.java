package com.codecool.musicapi.service;

import com.codecool.musicapi.DTO.GenreDTO;
import com.codecool.musicapi.entity.Genre;
import com.codecool.musicapi.entity.Song;
import com.codecool.musicapi.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class GenreService {
    private GenreRepository genreRepository;

    @Autowired
    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public List<Genre> findAll() {
        return genreRepository.findAll();
    }

    public Optional<Genre> findById(Long id) {
        return genreRepository.findById(id);
    }

    public List<Song> findAllSongsByGenreId(Long genreId) {
        Genre genre = findById(genreId).orElseThrow();
        return genre.getSongs();
    }

    public Song findSongByGenre(Long genreId, Long songId) {
        List<Song> songs = findAllSongsByGenreId(genreId);
        if(songs == null)
            return null;

        return songs.stream()
                .filter(s -> Objects.equals(s.getId(), songId))
                .findFirst().orElseThrow();
    }

    public Genre save(GenreDTO genre) {
        Genre newGenre = new Genre();
        newGenre.setName(genre.getName());
        return genreRepository.save(newGenre);
    }

    public Genre update(Long id, GenreDTO genre) {
        Genre genreToUpdate = findById(id).orElseThrow();
        genreToUpdate.setName(genre.getName());
        return genreRepository.save(genreToUpdate);
    }
}
