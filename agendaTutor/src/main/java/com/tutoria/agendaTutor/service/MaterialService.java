package com.tutoria.agendaTutor.service;


import com.tutoria.agendaTutor.entity.MaterialEntity;
import com.tutoria.agendaTutor.repository.MaterialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MaterialService {

    private final MaterialRepository materialRepository;

    public List<MaterialEntity> buscarTodos(){
        return materialRepository.findAll();
    }

    public MaterialEntity buscarPorId(Integer id){
        return materialRepository.findById(id).orElseThrow();

    }

    public MaterialEntity salvar(MaterialEntity material) {
        return materialRepository.save(material);
    }
    public void removerPorId(Integer id) {
        materialRepository.deleteById(id);
    }

    public MaterialEntity atualizar(Integer id, MaterialEntity material){
        buscarPorId(id);
        material.setId(id);
        return materialRepository.save(material);
    }
}
