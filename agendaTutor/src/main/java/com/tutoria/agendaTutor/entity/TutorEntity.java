package com.tutoria.agendaTutor.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tutor")
@Data
public class TutorEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String especialidade;

}
