package com.pankaj.springdatajpa.repository;

import com.pankaj.springdatajpa.model.ChessPlayer;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ChessPlayerPagingRepository
        extends PagingAndSortingRepository<ChessPlayer,Long> {
}
