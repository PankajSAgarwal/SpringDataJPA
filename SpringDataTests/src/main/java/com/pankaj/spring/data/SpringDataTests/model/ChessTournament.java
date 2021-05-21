package com.pankaj.spring.data.SpringDataTests.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ChessTournament {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "tournament_seq")
    @SequenceGenerator(name="tournament_seq",sequenceName = "tournament_sequence", initialValue = 100)
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

    public Long getId() {
        return id;
    }

    public int getVersion() {
        return version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }


    public Set<ChessPlayer> getPlayers() {
        return players;
    }

    public void setPlayers(Set<ChessPlayer> players) {
        this.players = players;
    }

    public Set<ChessGame> getGames() {
        return games;
    }

    public void setGames(Set<ChessGame> games) {
        this.games = games;
    }
}
