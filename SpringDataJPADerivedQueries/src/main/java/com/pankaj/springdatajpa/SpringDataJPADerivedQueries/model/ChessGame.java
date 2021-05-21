package com.pankaj.springdatajpa.SpringDataJPADerivedQueries.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class ChessGame {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private LocalDate date;

    private int round;

    @ManyToOne(fetch = FetchType.LAZY)
    private ChessTournament chessTournament;

    @ManyToOne(fetch = FetchType.LAZY)
    private ChessPlayer playerWhite;

    @ManyToOne(fetch = FetchType.LAZY)
    private ChessPlayer playerBlack;

    @Version
    private int version;

    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public int getVersion() {
        return version;
    }

    public ChessTournament getChessTournament() {
        return chessTournament;
    }

    public void setChessTournament(ChessTournament chessTournament) {
        this.chessTournament = chessTournament;
    }

    public ChessPlayer getPlayerWhite() {
        return playerWhite;
    }

    public void setPlayerWhite(ChessPlayer playerWhite) {
        this.playerWhite = playerWhite;
    }

    public ChessPlayer getPlayerBlack() {
        return playerBlack;
    }

    public void setPlayerBlack(ChessPlayer playerBlack) {
        this.playerBlack = playerBlack;
    }
}
