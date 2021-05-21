package com.pankaj.springdatajpa.SpringDataTestcontainers.repositories;

import com.pankaj.springdatajpa.SpringDataTestcontainers.model.ChessPlayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChessPlayerRepository
        extends JpaRepository<ChessPlayer,Long> {
    @Query("SELECT p from ChessPlayer p WHERE p.lastName = :lastName ORDER BY p.lastName ASC")
    List<ChessPlayer> findByLastName(@Param("lastName")String lastName);
}
