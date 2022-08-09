package com.accesscamp.api.controller;

import com.accesscamp.api.dto.CamperDTO;
import com.accesscamp.api.dto.SignUpDTO;
import com.accesscamp.api.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/signup")
public class SignUpController {
    @Autowired
    private SignUpService signUpService;

    @PostMapping
    public SignUpDTO createSignup(@RequestBody SignUpDTO signup){
        return signUpService.saveSignUpDTO(signup);
    }

    @GetMapping("/{id}")
    public SignUpDTO getSignup(@PathVariable Long id) {
        return signUpService.getSignupDTO(id);
    }
}
