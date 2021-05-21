package com.pankaj.springdatajpa.SpringDataJpaCustomNativeQueries.repository;

import com.pankaj.springdatajpa.SpringDataJpaCustomNativeQueries.model.ChessPlayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChessPlayerRepository extends JpaRepository<ChessPlayer, Long> {
    @Query(value = "SELECT * FROM Chess_Player p "
            + "LEFT JOIN Chess_Tournament_Players tp ON p.id = tp.players_id "
            + "LEFT JOIN Chess_Tournament t ON tp.tournaments_id = t.id "
            + "WHERE p.last_name LIKE %:lastName% AND p.first_name LIKE %:firstName% AND t.name = :tournamentName "
            + "ORDER BY p.last_name ASC, p.first_name ASC",
            nativeQuery = true)
    List<ChessPlayer> findByNameAndTournamentOrderedAdvancedLike(String lastName,
                                                                 String firstName,
                                                                 String tournamentName);
}