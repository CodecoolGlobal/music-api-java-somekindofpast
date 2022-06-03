package com.codecool.musicapi.DTO;

import lombok.Data;

import java.util.List;

@Data
public class PlaylistDTO {
    private String title;
    private List<Long> songIds;
}
