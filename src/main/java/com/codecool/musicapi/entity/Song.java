package com.codecool.musicapi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "title")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @ManyToMany(mappedBy = "songs")
    @JsonIdentityReference(alwaysAsId = true)
    private List<Artist> artists;

    @ManyToOne
    @JsonBackReference
    private Album album;

    @ManyToOne
    @JsonBackReference
    private Genre genre;

    @ManyToMany(mappedBy = "songs")
    @JsonIdentityReference(alwaysAsId = true)
    private List<Playlist> playlists;
}
