package com.tutoria.agendaTutor.controller;


import com.tutoria.agendaTutor.entity.TutorEntity;
import com.tutoria.agendaTutor.service.TutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tutor")
@RequiredArgsConstructor
public class TutorController {

    private final TutorService tutorService;

    @GetMapping
    public ResponseEntity<List<TutorEntity>> listarTodos(){
        List<TutorEntity> tutores = tutorService.buscarTodos();
        return new ResponseEntity<>(tutores, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TutorEntity> listarPorId(@PathVariable Integer id){
        TutorEntity tutor = tutorService.buscarPorId(id);
        return new ResponseEntity<>(tutor, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TutorEntity> salvar(@RequestBody TutorEntity tutor){
        TutorEntity tutotSalvo = tutorService.salvar(tutor);
        return new ResponseEntity<>(tutotSalvo, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerPorId(@PathVariable Integer id){
        tutorService.removerPorId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping
    public ResponseEntity<Void> atualizar(@PathVariable Integer id, @RequestBody TutorEntity tutor){
        tutorService.atualizar(id, tutor);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
