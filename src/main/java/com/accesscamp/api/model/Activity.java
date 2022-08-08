package com.accesscamp.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="ACTIVITIES")
@Getter
@Setter
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int difficulty;
    private LocalDateTime created_at;
    private LocalDateTime update_at;

    @OneToMany(mappedBy = "activity", cascade = CascadeType.REMOVE)
    List<SignUp> signUpList = new ArrayList<>();
}
