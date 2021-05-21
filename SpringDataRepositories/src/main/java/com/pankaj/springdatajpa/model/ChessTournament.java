package com.pankaj.springdatajpa.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ChessTournament {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "tournament_generator")
    @SequenceGenerator(name="tournament_generator",sequenceName = "tournament_seq",
    initialValue = 100)
    private Long id;
    private String name;

    private LocalDate startDate;
    private LocalDate endDate;

    @Version
    private int version;

    @ManyToMany
    private Set<ChessPlayer> players = new HashSet<>();

    @OneToMany
    private Set<ChessGame> games = new HashSet<>();
}
