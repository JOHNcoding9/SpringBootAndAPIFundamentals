package com.example.demo.controllers;

import com.example.demo.dto.ChamadoRequestDTO;
import com.example.demo.dto.ChamadoResponseDTO;
import com.example.demo.services.ChamadoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/chamados")
public class ChamadoController {

    private final ChamadoService chamadoService;

    public ChamadoController(ChamadoService chamadoService) {
        this.chamadoService = chamadoService;
    }

    // Cria um novo chamado *
    @PostMapping
    public ResponseEntity<ChamadoResponseDTO> create(@Valid @RequestBody ChamadoRequestDTO dto) {
        ChamadoResponseDTO response = chamadoService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // Retorna um chamado pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<ChamadoResponseDTO> findById(@PathVariable("id") Integer id) {
        ChamadoResponseDTO response = chamadoService.findById(id);
        return ResponseEntity.ok(response);
    }

    // Lista todos os chamados
    @GetMapping
    public ResponseEntity<List<ChamadoResponseDTO>> findAll() {
        List<ChamadoResponseDTO> chamados = chamadoService.findAll();
        return ResponseEntity.ok(chamados);
    }

    // Atualiza um chamado existente
    @PutMapping("/{id}")
    public ResponseEntity<ChamadoResponseDTO> update(
            @PathVariable("id") Integer id,
            @Valid @RequestBody ChamadoRequestDTO dto) {
        ChamadoResponseDTO response = chamadoService.update(id, dto);
        return ResponseEntity.ok(response);
    }

    // Exclui um chamado
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        chamadoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
