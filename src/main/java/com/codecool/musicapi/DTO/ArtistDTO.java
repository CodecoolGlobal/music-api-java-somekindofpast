package com.codecool.musicapi.DTO;

import lombok.Data;

import java.util.List;

@Data
public class ArtistDTO {
    private String name;
    private List<Long> songIds;
    private List<Long> albumIds;
}
