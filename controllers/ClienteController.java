package com.example.demo.controllers;

import com.example.demo.dto.ClienteRequestDTO;
import com.example.demo.dto.ClienteResponseDTO;
import com.example.demo.services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    // Cria um novo cliente
    @PostMapping
    public ResponseEntity<ClienteResponseDTO> create(@Valid @RequestBody ClienteRequestDTO dto) {
        ClienteResponseDTO response = clienteService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // Lista todos os clientes
    @GetMapping
    public ResponseEntity<List<ClienteResponseDTO>> findAll() {
        List<ClienteResponseDTO> clientes = clienteService.findAll();
        return ResponseEntity.ok(clientes);
    }

    // Retorna cliente pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> findById(@PathVariable("id") Integer id) {
        ClienteResponseDTO response = clienteService.findById(id);
        return ResponseEntity.ok(response);
    }

    // Atualiza um cliente existente
    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> update(
            @PathVariable("id") Integer id,
            @Valid @RequestBody ClienteRequestDTO dto) {
        ClienteResponseDTO response = clienteService.update(id, dto);
        return ResponseEntity.ok(response);
    }

    // Exclui um cliente
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
