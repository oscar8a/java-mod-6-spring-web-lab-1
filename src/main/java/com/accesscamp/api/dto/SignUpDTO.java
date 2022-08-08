package com.accesscamp.api.dto;

import lombok.Data;

@Data
public class SignUpDTO {
    private int time;
    private ActivityDTO activity;
    private CamperDTO camper;
}
