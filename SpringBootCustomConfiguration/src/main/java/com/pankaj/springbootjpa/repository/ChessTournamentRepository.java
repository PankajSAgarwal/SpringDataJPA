package com.pankaj.springbootjpa.repository;

import com.pankaj.springbootjpa.model.ChessTournament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChessTournamentRepository extends JpaRepository<ChessTournament,Long> {
}
