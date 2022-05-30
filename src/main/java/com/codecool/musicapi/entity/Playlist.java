package com.codecool.musicapi.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "title")
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @ManyToMany
    @JoinTable(name="song_by_playlist", foreignKey = @ForeignKey(name = "fk_playlist_song_by_playlist"), inverseForeignKey = @ForeignKey(name = "fk_song_song_by_playlist"))
    @JsonIdentityReference(alwaysAsId = true)
    private List<Song> songs;
}
