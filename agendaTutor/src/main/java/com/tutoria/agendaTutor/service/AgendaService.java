package com.tutoria.agendaTutor.service;


import com.tutoria.agendaTutor.entity.AgendaEntity;
import com.tutoria.agendaTutor.entity.AlunoEntity;
import com.tutoria.agendaTutor.repository.AgendaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgendaService {

    private final AgendaRepository agendaRepository;

    public List<AgendaEntity> buscarTodos(){
        return agendaRepository.findAll();
    }

    public AgendaEntity buscarPorId(Integer id){
        return agendaRepository.findById(id).orElseThrow();

    }

    public AgendaEntity salvar(AgendaEntity agenda) {
        return agendaRepository.save(agenda);
    }
    public void removerPorId(Integer id) {
        agendaRepository.deleteById(id);
    }

    public AgendaEntity atualizar(Integer id, AgendaEntity agenda){
        buscarPorId(id);
        agenda.setId(id);
        return agendaRepository.save(agenda);
    }
}
