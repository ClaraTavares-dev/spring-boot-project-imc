package com.tavares.spring_boot_essentials.controller;


import com.tavares.spring_boot_essentials.dto.AtualizarAvaliacaoRequest;
import com.tavares.spring_boot_essentials.dto.RegistrarAvaliacaoRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("v1/avaliacoes")
public class AvaliacaoController {
        @PostMapping
        public ResponseEntity<String> registrar(@RequestBody RegistrarAvaliacaoRequest registrar) {
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    "Avaliação registrada para o Paciente ID: " + registrar.idPaciente()
                            + "\n" +
                            "Peso: " + registrar.peso()
                            + "\n" +
                            "Altura: " + registrar.altura()
                            + "\n" +
                            "Criada com sucesso!"
            );
        }

        @GetMapping
        public ResponseEntity<String> listarAvaliacoes() {
            return ResponseEntity.ok("Lista de todas as avaliações retornada.");
        }

        @GetMapping("/{id}")
        public ResponseEntity<String> buscarAvaliacaoPorId(@PathVariable Long id) {
            return ResponseEntity.ok("Dados da avaliação ID " + id + " visualizados.");
        }

        @PutMapping("/{id}")
        public ResponseEntity<String> atualizarAvaliacao(@PathVariable Long id, @RequestBody AtualizarAvaliacaoRequest atualizar) {
            return ResponseEntity.ok(
                    "Avaliação ID " + id + " atualizada com sucesso!"
                            + "\n" +
                            "Novo Peso: " + atualizar.peso()
                            + "\n" +
                            "Nova Altura: " + atualizar.altura()
            );
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> removerAvaliacao(@PathVariable Long id) {
            return ResponseEntity.noContent().build();
        }

}
