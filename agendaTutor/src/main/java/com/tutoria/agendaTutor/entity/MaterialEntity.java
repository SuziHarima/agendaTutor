package com.tutoria.agendaTutor.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "material")
public class MaterialEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "agenda_id")
    private AgendaEntity agenda;

    private String descricao;
}
