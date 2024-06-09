package com.spring_batch_chunk.entities;

import jakarta.persistence.*;
import lombok.Data;

//jpa data - crea el to string los getter y setter
@Data
@Entity
@Table(name = "persons")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(name="last_name")
    private String lastName;
    private String createAt;
}
