package com.accesscamp.api.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CamperDTO {
    private long id;
    private String name;
    private int age;
    private List<ActivityDTO> listOfCamperActivities = new ArrayList<>();
}
