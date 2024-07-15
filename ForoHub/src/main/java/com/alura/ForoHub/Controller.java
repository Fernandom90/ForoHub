package com.alura.ForoHub;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/topicos")
public class Controller {

    @Autowired
    private TopicoRepository topicoRepository;


    @GetMapping
    public ResponseEntity<List<Model>> getAllTopicos() {
        List<Model> topicos = TopicoService.getAllTopicos();
        return ResponseEntity.ok(topicos);
    }

    @PostMapping
    public Model createTopico(@RequestBody Model topico) {
        return topicoRepository.save(topico);
    }
    // Método para actualizar un tópico específico por ID
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarTopico(@PathVariable Long id, @RequestBody TopicoRequest request) {
        try {
            TopicoService.actualizarTopico(id, request);
            return ResponseEntity.ok("Tópico actualizado correctamente");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
    // Método para eliminar un tópico por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarTopico(@PathVariable Long id) {
        try {
            TopicoService.eliminarTopico(id);
            return ResponseEntity.ok("Tópico eliminado correctamente");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}

