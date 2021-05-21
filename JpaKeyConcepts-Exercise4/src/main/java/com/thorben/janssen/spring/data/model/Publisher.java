package com.thorben.janssen.spring.data.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="publisher_generator")
    @SequenceGenerator(name="publisher_generator",sequenceName = "publisher_sequence")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "publisher")
    private Set<Book> books = new HashSet<>();

    @Version
    private int version;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVersion() {
        return version;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
