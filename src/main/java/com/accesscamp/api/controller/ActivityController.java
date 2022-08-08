package com.accesscamp.api.controller;

import com.accesscamp.api.dto.ActivityDTO;
import com.accesscamp.api.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activities")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @PostMapping
    public ActivityDTO createActivity(@RequestBody ActivityDTO activity){
        return activityService.saveActivityDTO(activity);
    }

    @GetMapping
    public List<ActivityDTO> getActivities() {
        return activityService.getActivitesDTO();
    }

    @DeleteMapping("/{id}")
    public void deleteActivity(@PathVariable Long id) {
        activityService.deleteActivity(id);
    }
}
