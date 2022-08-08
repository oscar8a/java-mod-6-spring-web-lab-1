package com.accesscamp.api.service;

import com.accesscamp.api.dto.ActivityDTO;
import com.accesscamp.api.dto.CamperDTO;
import com.accesscamp.api.model.Activity;
import com.accesscamp.api.model.Camper;
import com.accesscamp.api.repository.ActivityRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private ModelMapper mapper;

    public ActivityDTO saveActivityDTO(ActivityDTO activityDTO){
        // Convert activityDTO to an Activity Entity
        Activity activity = mapper.map(activityDTO, Activity.class);

        activityRepository.save(activity);

        return mapper.map(activity, ActivityDTO.class);
    }

    public List<ActivityDTO> getActivitesDTO() {
        return activityRepository.findAll()
                .stream()
                .map(activity -> mapper.map(activity, ActivityDTO.class))
                .collect(Collectors.toList());
    }

    public void deleteActivity(Long id) {
        activityRepository.deleteById(id);
    }
}
