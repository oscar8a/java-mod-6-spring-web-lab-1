package model;

import javax.persistence.*;
import java.time.LocalDateTime;

public class SignUp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Activity activity;

    @ManyToOne
    private Camper camper;

    private int time;
    private LocalDateTime created_at;
    private LocalDateTime update_at;
}
