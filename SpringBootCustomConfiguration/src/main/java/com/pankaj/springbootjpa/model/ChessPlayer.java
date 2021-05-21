package com.pankaj.springbootjpa.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ChessPlayer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "player_generator")
    @SequenceGenerator(name="player_generator",sequenceName = "player_seq",initialValue = 100,allocationSize = 1)
    private Long id;

    private String firstName;
    private String lastName;

    private LocalDate birthDate;

    @OneToMany(mappedBy = "playerWhite")
    private Set<ChessGame> gamesWhite;
    @OneToMany(mappedBy = "playerBlack")
    private Set<ChessGame> gamesBlack;

    @Version
    private int version;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Set<ChessGame> getGamesWhite() {
        return gamesWhite;
    }

    public void setGamesWhite(Set<ChessGame> gamesWhite) {
        this.gamesWhite = gamesWhite;
    }

    public Set<ChessGame> getGamesBlack() {
        return gamesBlack;
    }

    public void setGamesBlack(Set<ChessGame> gamesBlack) {
        this.gamesBlack = gamesBlack;
    }

    public int getVersion() {
        return version;
    }

    public Long getId() {
        return id;
    }
}
