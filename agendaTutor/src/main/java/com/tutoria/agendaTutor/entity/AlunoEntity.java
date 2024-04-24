package com.tutoria.agendaTutor.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "aluno")
@Data
public class AlunoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;
}
