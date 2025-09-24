package com.example.milo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "walk_log_points")
@Getter @Setter @NoArgsConstructor
public class WalkLogPoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer point_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "log_id")
    private WalkLog walkLog;

    private float latitude;
    private float longitude;
    private LocalDateTime recorded_at;
}
