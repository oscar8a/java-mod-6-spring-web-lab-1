package com.accesscamp.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="CAMPERS")
@Getter
@Setter
public class Camper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Name may not be empty")
    private String name;

    @Min(value = 8, message = "Minimum age is 8")
    @Max(value = 18, message = "Maximum age is 18")
    private int age;

    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    @OneToMany(mappedBy = "camper", cascade = CascadeType.REMOVE)
    List<SignUp> signUpList = new ArrayList<>();
}
