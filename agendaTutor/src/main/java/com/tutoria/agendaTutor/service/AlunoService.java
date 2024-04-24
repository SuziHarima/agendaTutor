package com.tutoria.agendaTutor.service;


import com.tutoria.agendaTutor.entity.AlunoEntity;
import com.tutoria.agendaTutor.repository.AlunoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public List<AlunoEntity> buscarTodos(){
        return alunoRepository.findAll();
    }

    public AlunoEntity buscarPorId(Integer id){
        return alunoRepository.findById(id).orElseThrow();

    }

    public AlunoEntity salvar(AlunoEntity aluno) {
        return alunoRepository.save(aluno);
    }
    public void removerPorId(Integer id) {
        alunoRepository.deleteById(id);
    }

    public AlunoEntity atualizar(Integer id, AlunoEntity aluno){
        buscarPorId(id);
        aluno.setId(id);
        return alunoRepository.save(aluno);
    }
}
