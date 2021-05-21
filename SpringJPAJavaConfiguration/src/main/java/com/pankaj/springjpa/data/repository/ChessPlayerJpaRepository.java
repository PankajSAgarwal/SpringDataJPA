package com.pankaj.springjpa.data.repository;

import com.pankaj.springjpa.data.model.ChessPlayer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChessPlayerJpaRepository extends JpaRepository<ChessPlayer,Long> {
}
