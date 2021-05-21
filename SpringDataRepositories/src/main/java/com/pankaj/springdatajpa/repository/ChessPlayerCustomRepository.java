package com.pankaj.springdatajpa.repository;

import com.pankaj.springdatajpa.model.ChessGame;
import com.pankaj.springdatajpa.model.ChessPlayer;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;


public interface ChessPlayerCustomRepository extends Repository<ChessPlayer,Long> {

    ChessPlayer save(ChessPlayer player);
    Optional<ChessPlayer> findById(Long id);
    List<ChessPlayer> findAll();
}
