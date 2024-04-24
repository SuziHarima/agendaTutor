package com.tutoria.agendaTutor.repository;


import com.tutoria.agendaTutor.entity.AgendaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendaRepository extends JpaRepository<AgendaEntity, Integer> {
}
