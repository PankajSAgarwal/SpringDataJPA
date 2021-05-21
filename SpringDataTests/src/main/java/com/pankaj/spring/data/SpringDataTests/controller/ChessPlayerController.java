package com.pankaj.spring.data.SpringDataTests.controller;

import com.pankaj.spring.data.SpringDataTests.model.ChessPlayer;
import com.pankaj.spring.data.SpringDataTests.repsoitories.ChessPlayerRepository;
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
        // validate input

        // persist ChessPlayer
        playerRepo.save(player);

        // perform other business logics

    }
}
