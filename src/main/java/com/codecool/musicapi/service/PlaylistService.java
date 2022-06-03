package com.codecool.musicapi.service;

import com.codecool.musicapi.DTO.PlaylistDTO;
import com.codecool.musicapi.entity.Playlist;
import com.codecool.musicapi.entity.Song;
import com.codecool.musicapi.repository.PlaylistRepository;
import com.codecool.musicapi.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PlaylistService {
    private PlaylistRepository playlistRepository;
    private SongRepository songRepository;

    @Autowired
    public PlaylistService(PlaylistRepository playlistRepository, SongRepository songRepository) {
        this.playlistRepository = playlistRepository;
        this.songRepository = songRepository;
    }

    public List<Playlist> findAll() {
        return playlistRepository.findAll();
    }

    public Optional<Playlist> findById(Long id) {
        return playlistRepository.findById(id);
    }

    public List<Song> findAllSongsByPlaylistId(Long playlistId) {
        Playlist playlist = findById(playlistId).orElseThrow();
        return playlist.getSongs();
    }

    public Song findSongByPlaylist(Long playlistId, Long songId) {
        List<Song> songs = findAllSongsByPlaylistId(playlistId);
        if(songs == null)
            return null;

        return songs.stream()
                .filter(s -> Objects.equals(s.getId(), songId))
                .findFirst().orElseThrow();
    }

    public Playlist save(PlaylistDTO playlist) {
        return playlistRepository.save(entityFromDTO(playlist));
    }

    public Playlist update(Long id, PlaylistDTO playlist) {
        Playlist playlistToUpdate = findById(id).orElseThrow();
        Playlist newPlaylist = entityFromDTO(playlist);
        playlistToUpdate.setTitle(newPlaylist.getTitle());
        playlistToUpdate.setSongs(newPlaylist.getSongs());
        return playlistRepository.save(playlistToUpdate);
    }

    private Playlist entityFromDTO(PlaylistDTO playlist) {
        Playlist newPlaylist = new Playlist();

        newPlaylist.setTitle(playlist.getTitle());

        List<Song> songs = new ArrayList<>();
        for (Long songId : playlist.getSongIds()) {
            songs.add(songRepository.findById(songId).orElseThrow());
        }
        newPlaylist.setSongs(songs);

        return  newPlaylist;
    }
}
