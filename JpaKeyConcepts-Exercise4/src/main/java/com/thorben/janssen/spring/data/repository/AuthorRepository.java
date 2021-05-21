package com.thorben.janssen.spring.data.repository;

import com.thorben.janssen.spring.data.model.Author;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    
}
