package com.codecool.musicapi.DTO;

import lombok.Data;

@Data
public class SongDTO {
    private String title;
    private Long album_id;
    private Long genre_id;
}
