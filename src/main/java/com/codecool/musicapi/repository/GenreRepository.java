package com.codecool.musicapi.repository;

import com.codecool.musicapi.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
