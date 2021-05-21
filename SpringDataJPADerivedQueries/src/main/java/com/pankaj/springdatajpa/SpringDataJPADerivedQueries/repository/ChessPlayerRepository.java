package com.pankaj.springdatajpa.SpringDataJPADerivedQueries.repository;

import com.pankaj.springdatajpa.SpringDataJPADerivedQueries.model.ChessPlayer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChessPlayerRepository extends JpaRepository<ChessPlayer,Long> {
    List<ChessPlayer> findByLastName(String lastName);

    List<ChessPlayer> streamByLastName(String lastName);

    List<ChessPlayer> findByFirstNameAndLastName(String firstName, String lastName);

    List<ChessPlayer> findFirst10ByLastName(String lastName);

    boolean existsByLastName(String lastName);

    Long countByLastName(String lastName);

    List<ChessPlayer> findByLastNameLike(String lastName);

    List<ChessPlayer> findByLastNameContainingIgnoreCase(String lastName);

    List<ChessPlayer> findByLastNameContainingIgnoreCaseAndFirstName(String lastName, String firstName);

    List<ChessPlayer> findByLastNameNotOrderByLastNameAscFirstNameAsc(String lastName);

    List<ChessPlayer> findByTournamentsName(String name);
}
