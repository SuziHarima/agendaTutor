package com.tutoria.agendaTutor.repository;


import com.tutoria.agendaTutor.entity.TutorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorRepository extends JpaRepository<TutorEntity, Integer> {
}
