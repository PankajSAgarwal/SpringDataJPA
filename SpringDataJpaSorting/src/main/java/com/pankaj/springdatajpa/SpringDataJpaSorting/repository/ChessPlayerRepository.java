package com.pankaj.springdatajpa.SpringDataJpaSorting.repository;

import com.pankaj.springdatajpa.SpringDataJpaSorting.model.ChessPlayer;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChessPlayerRepository
        extends JpaRepository<ChessPlayer, Long> {

    @Query("SELECT p from ChessPlayer p WHERE upper(p.lastName) like upper(:lastName)")
    List<ChessPlayer> findByName(String lastName, Sort sort);
}