package com.pankaj.springdatajpa.repository;

import com.pankaj.springdatajpa.model.ChessPlayer;
import org.springframework.data.repository.CrudRepository;

public interface ChessPlayerCrudRepository extends CrudRepository<ChessPlayer,Long> {
}
