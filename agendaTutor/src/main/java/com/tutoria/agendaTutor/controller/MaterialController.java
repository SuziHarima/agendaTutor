package com.tutoria.agendaTutor.controller;


import com.tutoria.agendaTutor.entity.MaterialEntity;
import com.tutoria.agendaTutor.service.MaterialService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/material")
@RequiredArgsConstructor
public class MaterialController {

    private final MaterialService materialService;

    @GetMapping
    public ResponseEntity<List<MaterialEntity>> listarTodos(){
        List<MaterialEntity> material = materialService.buscarTodos();
        return new ResponseEntity<>(material, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MaterialEntity> listarPorId(@PathVariable Integer id){
        MaterialEntity material = materialService.buscarPorId(id);
        return new ResponseEntity<>(material, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MaterialEntity> salvar(@RequestBody MaterialEntity material){
        MaterialEntity materialSalvo = materialService.salvar(material);
        return new ResponseEntity<>(materialSalvo, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerPorId(@PathVariable Integer id){
        materialService.removerPorId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping
    public ResponseEntity<Void> atualizar(@PathVariable Integer id, @RequestBody MaterialEntity material){
        materialService.atualizar(id, material);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
