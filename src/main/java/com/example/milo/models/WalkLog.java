package com.example.milo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "walk_logs")
@Getter @Setter @NoArgsConstructor
public class WalkLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer log_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pet_id")
    private Pet pet;

    private String log_name;
    private String log_description;
    private enum path_review {
        FREE, ACTIVE, HARD, EXPLORE
    }
    private enum walk_style {
        FLAT, GRASS, SOIL, UPHILL
    }
    private LocalDateTime start_time;
    private LocalDateTime end_time;
    private Float distance_km;
    private Integer duration_seconds;
    private Float Calories;
    private Integer image_url;
}
