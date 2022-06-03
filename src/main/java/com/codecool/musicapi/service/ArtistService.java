package com.codecool.musicapi.service;

import com.codecool.musicapi.DTO.ArtistDTO;
import com.codecool.musicapi.entity.Album;
import com.codecool.musicapi.entity.Artist;
import com.codecool.musicapi.entity.Song;
import com.codecool.musicapi.repository.AlbumRepository;
import com.codecool.musicapi.repository.ArtistRepository;
import com.codecool.musicapi.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ArtistService {
    private ArtistRepository artistRepository;
    private SongRepository songRepository;
    private AlbumRepository albumRepository;

    @Autowired
    public ArtistService(ArtistRepository artistRepository, SongRepository songRepository, AlbumRepository albumRepository) {
        this.artistRepository = artistRepository;
        this.songRepository = songRepository;
        this.albumRepository = albumRepository;
    }

    public List<Artist> findAll() {
        return artistRepository.findAll();
    }

    public Optional<Artist> findById(Long id) {
        return artistRepository.findById(id);
    }

    public Artist save(ArtistDTO artist) {
        return artistRepository.save(entityFromDTO(artist));
    }

    public Artist update(Long id, ArtistDTO artist) {
        Artist artistToUpdate = findById(id).orElseThrow();
        Artist newArtist = entityFromDTO(artist);
        artistToUpdate.setName(newArtist.getName());
        artistToUpdate.setSongs(newArtist.getSongs());
        artistToUpdate.setAlbums(newArtist.getAlbums());
        return artistRepository.save(artistToUpdate);
    }

    private Artist entityFromDTO(ArtistDTO artist) {
        Artist newArtist = new Artist();

        newArtist.setName(artist.getName());

        List<Song> songs = new ArrayList<>();
        for (Long songId : artist.getSongIds()) {
            songs.add(songRepository.findById(songId).orElseThrow());
        }
        newArtist.setSongs(songs);

        List<Album> albums = new ArrayList<>();
        for (Long albumId : artist.getAlbumIds()) {
            albums.add(albumRepository.findById(albumId).orElseThrow());
        }
        newArtist.setAlbums(albums);

        return  newArtist;
    }
}
