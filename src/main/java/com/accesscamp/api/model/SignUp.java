package com.accesscamp.api.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "SIGN_UPS")
@Data
public class SignUp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Activity activity;

    @ManyToOne(fetch = FetchType.LAZY)
    private Camper camper;

    @NotNull
    @Min(0)
    @Max(23)
    private int time;

    private LocalDateTime created_at;
    private LocalDateTime update_at;
}
