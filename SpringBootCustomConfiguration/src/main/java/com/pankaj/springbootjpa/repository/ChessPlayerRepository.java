package com.pankaj.springbootjpa.repository;

import com.pankaj.springbootjpa.model.ChessPlayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChessPlayerRepository extends JpaRepository<ChessPlayer,Long> {
    @Query("SELECT p from ChessPlayer p where p.firstName=:firstName")
    List<ChessPlayer> findByFirstName(String firstName);

    List<ChessPlayer> findByLastName(String lastName);
}
