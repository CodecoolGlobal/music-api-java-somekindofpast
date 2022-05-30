package com.codecool.musicapi.service;

import com.codecool.musicapi.entity.Album;
import com.codecool.musicapi.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
}
