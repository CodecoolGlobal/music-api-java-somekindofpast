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
        property = "name")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany
    @JoinTable(name="song_authorship", foreignKey = @ForeignKey(name = "fk_artist_song_authorship"), inverseForeignKey = @ForeignKey(name = "fk_song_song_authorship"))
    @JsonIdentityReference(alwaysAsId = true)
    private List<Song> songs;

    @ManyToMany
    @JoinTable(name="album_authorship", foreignKey = @ForeignKey(name = "fk_artist_album_authorship"), inverseForeignKey = @ForeignKey(name = "fk_album_album_authorship"))
    @JsonIdentityReference(alwaysAsId = true)
    private List<Album> albums;
}
