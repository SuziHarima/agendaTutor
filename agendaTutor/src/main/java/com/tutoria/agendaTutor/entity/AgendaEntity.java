package com.tutoria.agendaTutor.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "agenda")
public class AgendaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "aluno_id")
    private AlunoEntity aluno;

    @OneToOne
    @JoinColumn(name = "tutor_id")
    private TutorEntity tutor;

    @JsonFormat(pattern = "dd/MM/yy")
    private LocalDate data;
    private String status;

    private String tema;
    private String descricao;

}
