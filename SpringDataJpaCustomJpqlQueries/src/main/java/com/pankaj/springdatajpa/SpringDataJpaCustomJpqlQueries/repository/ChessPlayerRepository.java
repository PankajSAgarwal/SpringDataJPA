package com.pankaj.springdatajpa.SpringDataJpaCustomJpqlQueries.repository;

import com.pankaj.springdatajpa.SpringDataJpaCustomJpqlQueries.model.ChessPlayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChessPlayerRepository extends JpaRepository<ChessPlayer,Long> {

    @Query("SELECT p FROM ChessPlayer p where UPPER(p.lastName) LIKE UPPER(:lastName) AND p.firstName=:firstName ")
    List<ChessPlayer> findByName(String lastName, String firstName);

    @Query("FROM ChessPlayer p WHERE UPPER(p.lastName) like UPPER(:lName) and p.firstName=:firstName")
    List<ChessPlayer> findByNameWithoutSelect(@Param("lName") String lastName, String firstName);

    @Query("SELECT p FROM ChessPlayer p JOIN p.chessTournaments t "
            + "WHERE p.lastName LIKE :lastName and p.firstName LIKE :firstName and t.name=:tournamentName"
            + " ORDER BY p.lastName ASC,p.firstName ASC")
    List<ChessPlayer> findByNameAndTournamentOrderedByPlayerName(String lastName,
                                                                 String firstName,
                                                                 String tournamentName);

    @Query("SELECT p FROM ChessPlayer p "
    + "where p.lastName like %:lastName% and p.firstName like %:firstName% "
    + "ORDER BY p.lastName ASC, p.firstName ASC")
    List<ChessPlayer> findByNameAndChessTournamentsOrderedAdvancedLike(String lastName, String firstName);



}
