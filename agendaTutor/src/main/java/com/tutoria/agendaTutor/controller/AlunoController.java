package com.tutoria.agendaTutor.controller;


import com.tutoria.agendaTutor.entity.AlunoEntity;
import com.tutoria.agendaTutor.service.AlunoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluno")
@RequiredArgsConstructor
public class AlunoController {

    private final AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<AlunoEntity>> listarTodos(){
        List<AlunoEntity> alunos = alunoService.buscarTodos();
        return new ResponseEntity<>(alunos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoEntity> listarPorId(@PathVariable Integer id){
        AlunoEntity aluno = alunoService.buscarPorId(id);
        return new ResponseEntity<>(aluno, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AlunoEntity> salvar(@RequestBody AlunoEntity aluno){
        AlunoEntity alunoSalvo = alunoService.salvar(aluno);
        return new ResponseEntity<>(alunoSalvo, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerPorId(@PathVariable Integer id){
        alunoService.removerPorId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping
    public ResponseEntity<Void> atualizar(@PathVariable Integer id, @RequestBody AlunoEntity aluno){
        alunoService.atualizar(id, aluno);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
