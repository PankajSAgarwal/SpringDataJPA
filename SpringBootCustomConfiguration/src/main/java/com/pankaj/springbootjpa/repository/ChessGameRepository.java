package com.pankaj.springbootjpa.repository;

import com.pankaj.springbootjpa.model.ChessGame;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChessGameRepository extends JpaRepository<ChessGame,Long> {
}
