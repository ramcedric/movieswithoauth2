package com.example.movieproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Movie {
@Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int yearReleased;
    private boolean isSequel;

    @Enumerated(EnumType.STRING)
    private Genre genre;



    @ElementCollection
    private List<String> castList;
}
