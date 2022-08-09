package com.accesscamp.api.controller;

import com.accesscamp.api.dto.ActivityDTO;
import com.accesscamp.api.dto.CamperDTO;
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

    @GetMapping("/{id}")
    public ActivityDTO getActivity(@PathVariable Long id) {
        return activityService.getActivityDTO(id);
    }


    @GetMapping
    public List<ActivityDTO> getActivities() {
        return activityService.getActivitiesDTO();
    }

    @DeleteMapping("/{id}")
    public void deleteActivity(@PathVariable Long id) {
        activityService.deleteActivity(id);
    }
}
