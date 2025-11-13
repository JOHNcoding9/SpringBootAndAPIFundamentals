package com.example.demo.services;

import com.example.demo.domain.entities.Cliente;
import com.example.demo.dto.ClienteRequestDTO;
import com.example.demo.dto.ClienteResponseDTO;
import com.example.demo.repositories.ClienteRepository;
import com.example.demo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.domain.enums.Perfil;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteResponseDTO findById(Integer id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Cliente não encontrado! ID: " + id));

        return new ClienteResponseDTO(
                cliente.getId(),
                cliente.getNome(),
                cliente.getEmail(),
                cliente.getCpf(),
                cliente.getDataCriacao()
        );
    }

    public List<ClienteResponseDTO> findAll() {
        return clienteRepository.findAll().stream()
                .map(cliente -> new ClienteResponseDTO(
                        cliente.getId(),
                        cliente.getNome(),
                        cliente.getEmail(),
                        cliente.getCpf(),
                        cliente.getDataCriacao()
                ))
                .collect(Collectors.toList());
    }

    public ClienteResponseDTO create(ClienteRequestDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNome());
        cliente.setCpf(dto.getCpf());
        cliente.setEmail(dto.getEmail());
        cliente.setSenha(dto.getSenha());
        cliente.setPerfil(Perfil.toEnum(dto.getPerfil()));

        Cliente salvo = clienteRepository.save(cliente);

        return new ClienteResponseDTO(
                salvo.getId(),
                salvo.getNome(),
                salvo.getEmail(),
                salvo.getCpf(),
                salvo.getDataCriacao()
        );
    }

    public ClienteResponseDTO update(Integer id, ClienteRequestDTO dto) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Cliente não encontrado! ID: " + id));

        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());
        cliente.setSenha(dto.getSenha());

        Cliente atualizado = clienteRepository.save(cliente);

        return new ClienteResponseDTO(
                atualizado.getId(),
                atualizado.getNome(),
                atualizado.getEmail(),
                atualizado.getCpf(),
                atualizado.getDataCriacao()
        );
    }

    public void delete(Integer id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Cliente não encontrado! ID: " + id));

        clienteRepository.delete(cliente);
    }
}
