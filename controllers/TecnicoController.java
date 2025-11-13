package com.example.demo.controllers;

import com.example.demo.dto.TecnicoRequestDTO;
import com.example.demo.dto.TecnicoResponseDTO;
import com.example.demo.services.TecnicoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/tecnicos")
public class TecnicoController {

    private final TecnicoService tecnicoService;

    public TecnicoController(TecnicoService tecnicoService) {
        this.tecnicoService = tecnicoService;
    }

    // Cria um novo técnico
    @PostMapping
    public ResponseEntity<TecnicoResponseDTO> create(@Valid @RequestBody TecnicoRequestDTO dto) {
        TecnicoResponseDTO response = tecnicoService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // Lista todos os técnicos
    @GetMapping
    public ResponseEntity<List<TecnicoResponseDTO>> findAll() {
        List<TecnicoResponseDTO> tecnicos = tecnicoService.findAll();
        return ResponseEntity.ok(tecnicos);
    }

    // Retorna técnico pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<TecnicoResponseDTO> findById(@PathVariable("id") Integer id) {
        TecnicoResponseDTO response = tecnicoService.findById(id);
        return ResponseEntity.ok(response);
    }

    // Atualiza técnico existente
    @PutMapping("/{id}")
    public ResponseEntity<TecnicoResponseDTO> update(
            @PathVariable("id") Integer id,
            @Valid @RequestBody TecnicoRequestDTO dto) {
        TecnicoResponseDTO response = tecnicoService.update(id, dto);
        return ResponseEntity.ok(response);
    }

    // Exclui técnico
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        tecnicoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
