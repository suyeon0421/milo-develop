package com.example.milo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pets")
@Getter @Setter @NoArgsConstructor
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pet_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String pet_name;
    private String birth;
    private Float weight;
    private enum gender{
        MALE, FEMALE, NULL
    }
    private boolean neutered;
    private enum selected_dog_breed {
        MALTESE, Poodle, Chihuahua
    }
    private enum pet_type {
        LARGE, MEDIUM, SMALL
    }
}
