package com.accesscamp.api.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "SIGN_UPS")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class SignUp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Activity activity;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Camper camper;

    @NotNull
    @Min(0)
    @Max(23)
    private int time;

    private LocalDateTime created_at;
    private LocalDateTime update_at;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SignUp signUp = (SignUp) o;
        return id != null && Objects.equals(id, signUp.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
