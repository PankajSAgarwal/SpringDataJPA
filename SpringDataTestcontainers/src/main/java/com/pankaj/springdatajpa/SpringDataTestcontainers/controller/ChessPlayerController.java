package com.pankaj.springdatajpa.SpringDataTestcontainers.controller;

import com.pankaj.springdatajpa.SpringDataTestcontainers.model.ChessPlayer;
import com.pankaj.springdatajpa.SpringDataTestcontainers.repositories.ChessPlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="player")
@Transactional
public class ChessPlayerController {

    private ChessPlayerRepository playerRepo;

    public ChessPlayerController(ChessPlayerRepository playerRepo) {
        this.playerRepo = playerRepo;
    }

    @PostMapping
    public void persistPlayer(ChessPlayer player){
        //validate input

        // persist checss player

        playerRepo.save(player);

        // perform other business logics

    }
}
