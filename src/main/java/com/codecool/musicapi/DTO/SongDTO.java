package com.codecool.musicapi.DTO;

import lombok.Data;

import java.util.List;

@Data
public class SongDTO {
    private String title;
    private Long genre_id;
    private Long album_id;
}
