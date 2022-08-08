package com.accesscamp.api.service;

import com.accesscamp.api.dto.SignUpDTO;
import com.accesscamp.api.model.Activity;
import com.accesscamp.api.model.Camper;
import com.accesscamp.api.model.SignUp;
import com.accesscamp.api.repository.ActivityRepository;
import com.accesscamp.api.repository.CamperRepository;
import com.accesscamp.api.repository.SignUpRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class SignUpService {
    @Autowired
    private SignUpRepository signUpRepository;

    @Autowired
    private CamperRepository camperRepo;

    @Autowired
    private ActivityRepository activityRepo;

    @Autowired
    private ModelMapper mapper;

    public SignUpDTO saveSignUpDTO(SignUpDTO signUpDTO){
        SignUp signUp = mapper.map(signUpDTO, SignUp.class);

        Camper camper = signUp.getCamper();
        Activity activity = signUp.getActivity();

        signUp.setCamper(camperRepo.findById(camper.getId())
                .orElseThrow(()->new ResponseStatusException(HttpStatus.BAD_REQUEST, "validation error")));
        signUp.setActivity(activityRepo.findById(activity.getId())
                .orElseThrow(()->new ResponseStatusException(HttpStatus.BAD_REQUEST, "validation error")));

        signUpRepository.save(signUp);

        return mapper.map(signUp, SignUpDTO.class);
    }
}
