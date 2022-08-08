package com.accesscamp.api.controller;

import com.accesscamp.api.dto.SignUpDTO;
import com.accesscamp.api.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/signup")
public class SignUpController {
    @Autowired
    private SignUpService signUpService;

    @PostMapping
    public SignUpDTO createSignup(@RequestBody SignUpDTO signup){
        return signUpService.saveSignUpDTO(signup);
    }
}
