package com.thorben.janssen.spring.data.repository;

import com.thorben.janssen.spring.data.model.Publisher;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
    
}
