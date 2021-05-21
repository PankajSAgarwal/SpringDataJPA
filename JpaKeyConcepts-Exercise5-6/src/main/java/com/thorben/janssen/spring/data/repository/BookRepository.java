package com.thorben.janssen.spring.data.repository;

import com.thorben.janssen.spring.data.model.Book;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    
}
