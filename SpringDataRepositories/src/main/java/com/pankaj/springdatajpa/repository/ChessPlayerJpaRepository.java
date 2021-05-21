package com.pankaj.springdatajpa.repository;

import com.pankaj.springdatajpa.model.ChessPlayer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChessPlayerJpaRepository extends JpaRepository<ChessPlayer,Long> {
}
