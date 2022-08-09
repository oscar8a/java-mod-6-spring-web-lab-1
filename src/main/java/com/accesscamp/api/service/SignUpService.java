package com.accesscamp.api.service;

import com.accesscamp.api.dto.CamperDTO;
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

        Camper camper = camperRepo.findById(signUpDTO.getCamper_id())
                .orElseThrow(()->new ResponseStatusException(HttpStatus.BAD_REQUEST, "validation error"));

        Activity activity = activityRepo.findById(signUpDTO.getActivity_id())
                .orElseThrow(()->new ResponseStatusException(HttpStatus.BAD_REQUEST, "validation error"));

        signUp.setCamper(camper);
        signUp.setActivity(activity);

        signUpRepository.save(signUp);

        return mapper.map(signUp, SignUpDTO.class);
    }

    public SignUpDTO getSignupDTO(Long id){
        SignUp signUp =
                    signUpRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "SignUp not Found"));
            return mapper.map(signUp, SignUpDTO.class);
    }
}
