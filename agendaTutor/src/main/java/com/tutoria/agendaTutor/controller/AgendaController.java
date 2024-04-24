package com.tutoria.agendaTutor.controller;


import com.tutoria.agendaTutor.entity.AgendaEntity;
import com.tutoria.agendaTutor.entity.AlunoEntity;
import com.tutoria.agendaTutor.service.AgendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluno")
@RequiredArgsConstructor
public class AgendaController {

    private final AgendaService agendaService;

    @GetMapping
    public ResponseEntity<List<AgendaEntity>> listarTodos(){
        List<AgendaEntity> agenda = agendaService.buscarTodos();
        return new ResponseEntity<>(agenda, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgendaEntity> listarPorId(@PathVariable Integer id){
        AgendaEntity agenda = agendaService.buscarPorId(id);
        return new ResponseEntity<>(agenda, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AgendaEntity> salvar(@RequestBody AgendaEntity agenda){
        AgendaEntity agendaSalva = agendaService.salvar(agenda);
        return new ResponseEntity<>(agendaSalva, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerPorId(@PathVariable Integer id){
        agendaService.removerPorId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping
    public ResponseEntity<Void> atualizar(@PathVariable Integer id, @RequestBody AgendaEntity agenda){
        agendaService.atualizar(id, agenda);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
