package com.tutoria.agendaTutor.service;


import com.tutoria.agendaTutor.entity.TutorEntity;
import com.tutoria.agendaTutor.repository.TutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TutorService {

    private final TutorRepository tutorRepository;

    public List<TutorEntity> buscarTodos(){
        return tutorRepository.findAll();
    }

    public TutorEntity buscarPorId(Integer id){
        return tutorRepository.findById(id).orElseThrow();

    }

    public TutorEntity salvar(TutorEntity tutor) {
        return tutorRepository.save(tutor);
    }
    public void removerPorId(Integer id) {
        tutorRepository.deleteById(id);
    }

    public TutorEntity atualizar(Integer id, TutorEntity tutor){
        buscarPorId(id);
        tutor.setId(id);
        return tutorRepository.save(tutor);
    }
}
