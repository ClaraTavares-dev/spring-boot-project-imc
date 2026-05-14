package com.tavares.spring_boot_essentials.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.tavares.spring_boot_essentials.dto.PacienteRequest;
import com.tavares.spring_boot_essentials.dto.AtualizarPacienteRequest;

@RestController
@RequestMapping("v1/pacientes") //rota
public class PacienteController {

    @PostMapping
    public ResponseEntity<String> cadastrarPaciente(@RequestBody PacienteRequest paciente) {
        return ResponseEntity.status(HttpStatus.CREATED).body( "Paciente: " + paciente.nome()
                + "\n" +
                "Status: " + paciente.status()
                + "\n" +
                "Criado com sucesso!");
    }

    @GetMapping
    public ResponseEntity<String> listarPacientes() {
        return ResponseEntity.ok("Lista de pacientes retornada com sucesso!");
    }


    @GetMapping("/{id}")
    public ResponseEntity<String> buscarPacientePorId(@PathVariable Long id) {
        return ResponseEntity.ok("Dados do paciente com ID " + id + " visualizados.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarPaciente(@PathVariable Long id, @RequestBody AtualizarPacienteRequest atualizar) {
        return ResponseEntity.ok("Paciente ID " + id + " atualizado para o nome:" + atualizar.nome());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerPaciente(@PathVariable Long id) {
        return ResponseEntity.noContent().build();
    }
}



