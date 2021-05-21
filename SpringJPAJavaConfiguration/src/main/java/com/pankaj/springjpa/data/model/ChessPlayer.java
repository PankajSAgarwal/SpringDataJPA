package com.pankaj.springjpa.data.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class ChessPlayer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="player_generator")
    @SequenceGenerator(name = "player_generator",sequenceName = "player_seq")
    private Long id;

    private String firstName;
    private String lastName;

    private LocalDate birthDate;

    @Version
    private int version;

    public Long getId() {
        return id;
    }

    public int getVersion() {
        return version;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
