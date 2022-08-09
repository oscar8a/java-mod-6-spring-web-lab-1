package com.accesscamp.api.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ActivityDTO {
    private Long id;
    private String name;
    private int difficulty;
}
