package com.accesscamp.api.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ActivityDTO {
    private Long id;

    private String name;
    private int difficulty;
    private LocalDateTime created_at;
    private LocalDateTime update_at;
}
