package com.example.demo.services;

import com.example.demo.domain.entities.Tecnico;
import com.example.demo.dto.TecnicoRequestDTO;
import com.example.demo.dto.TecnicoResponseDTO;
import com.example.demo.repositories.TecnicoRepository;
import com.example.demo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.domain.enums.Perfil;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepository tecnicoRepository;

    public TecnicoResponseDTO findById(Integer id) {
        Tecnico tecnico = tecnicoRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Técnico não encontrado! ID: " + id));

        return new TecnicoResponseDTO(tecnico);
    }

    public List<TecnicoResponseDTO> findAll() {
        return tecnicoRepository.findAll().stream()
                .map(TecnicoResponseDTO::new)
                .collect(Collectors.toList());
    }

    public TecnicoResponseDTO create(TecnicoRequestDTO dto) {
        Tecnico tecnico = new Tecnico();
        tecnico.setNome(dto.getNome());
        tecnico.setCpf(dto.getCpf());
        tecnico.setEmail(dto.getEmail());
        tecnico.setSenha(dto.getSenha());
        tecnico.setPerfil(Perfil.toEnum(dto.getPerfil()));

        Tecnico salvo = tecnicoRepository.save(tecnico);

        return new TecnicoResponseDTO(salvo);
    }

    public TecnicoResponseDTO update(Integer id, TecnicoRequestDTO dto) {
        Tecnico tecnico = tecnicoRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Técnico não encontrado! ID: " + id));

        tecnico.setNome(dto.getNome());
        tecnico.setEmail(dto.getEmail());
        tecnico.setSenha(dto.getSenha());

        Tecnico atualizado = tecnicoRepository.save(tecnico);

        return new TecnicoResponseDTO(atualizado);
    }

    public void delete(Integer id) {
        Tecnico tecnico = tecnicoRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Técnico não encontrado! ID: " + id));

        tecnicoRepository.delete(tecnico);
    }
}
