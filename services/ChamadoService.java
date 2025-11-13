package com.example.demo.services;

import com.example.demo.domain.entities.Chamado;
import com.example.demo.domain.entities.Cliente;
import com.example.demo.domain.entities.Tecnico;
import com.example.demo.domain.enums.Prioridade;
import com.example.demo.domain.enums.Status;
import com.example.demo.dto.ChamadoRequestDTO;
import com.example.demo.dto.ChamadoResponseDTO;
import com.example.demo.repositories.ChamadoRepository;
import com.example.demo.repositories.ClienteRepository;
import com.example.demo.repositories.TecnicoRepository;
import com.example.demo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChamadoService {

    @Autowired
    private ChamadoRepository chamadoRepository;

    @Autowired
    private TecnicoRepository tecnicoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public ChamadoResponseDTO findById(Integer id) {
        Chamado chamado = chamadoRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Chamado não encontrado! ID: " + id));

        return toResponseDTO(chamado);
    }

    public List<ChamadoResponseDTO> findAll() {
        return chamadoRepository.findAll().stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    public ChamadoResponseDTO create(ChamadoRequestDTO dto) {
        Chamado chamado = fromRequestDTO(dto);
        Chamado salvo = chamadoRepository.save(chamado);
        return toResponseDTO(salvo);
    }

    public ChamadoResponseDTO update(Integer id, ChamadoRequestDTO dto) {
        Chamado chamado = chamadoRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Chamado não encontrado! ID: " + id));

        Tecnico tecnico = tecnicoRepository.findById(dto.getTecnicoId())
                .orElseThrow(() -> new ObjectNotFoundException("Técnico não encontrado! ID: " + dto.getTecnicoId()));

        Cliente cliente = clienteRepository.findById(dto.getClienteId())
                .orElseThrow(() -> new ObjectNotFoundException("Cliente não encontrado! ID: " + dto.getClienteId()));

        chamado.setPrioridade(Prioridade.toEnum(dto.getPrioridade()));
        chamado.setStatus(Status.toEnum(dto.getStatus()));
        chamado.setTitulo(dto.getTitulo());
        chamado.setObservacoes(dto.getObservacoes());
        chamado.setTecnico(tecnico);
        chamado.setCliente(cliente);
        chamado.setDataFechamento(dto.getDataFechamento());


        Chamado atualizado = chamadoRepository.save(chamado);

        return toResponseDTO(atualizado);
    }

    public void delete(Integer id) {
        Chamado chamado = chamadoRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Chamado não encontrado! ID: " + id));

        chamadoRepository.delete(chamado);
    }

    // =============================
    //  Métodos auxiliares
    // =============================

    private Chamado fromRequestDTO(ChamadoRequestDTO dto) {
        Tecnico tecnico = tecnicoRepository.findById(dto.getTecnicoId())
                .orElseThrow(() -> new ObjectNotFoundException("Técnico não encontrado! ID: " + dto.getTecnicoId()));

        Cliente cliente = clienteRepository.findById(dto.getClienteId())
                .orElseThrow(() -> new ObjectNotFoundException("Cliente não encontrado! ID: " + dto.getClienteId()));

        Chamado chamado = new Chamado();
        chamado.setPrioridade(Prioridade.toEnum(dto.getPrioridade()));
        chamado.setStatus(Status.toEnum(dto.getStatus()));
        chamado.setTitulo(dto.getTitulo());
        chamado.setObservacoes(dto.getObservacoes());
        chamado.setTecnico(tecnico);
        chamado.setCliente(cliente);
        chamado.setDataFechamento(dto.getDataFechamento());

        return chamado;
    }

    private ChamadoResponseDTO toResponseDTO(Chamado chamado) {
        ChamadoResponseDTO dto = new ChamadoResponseDTO();
        dto.setId(chamado.getId());
        dto.setDataAbertura(chamado.getDataAbertura());
        dto.setDataFechamento(chamado.getDataFechamento());
        dto.setPrioridade(chamado.getPrioridade().name());
        dto.setStatus(chamado.getStatus().name());
        dto.setTitulo(chamado.getTitulo());
        dto.setObservacoes(chamado.getObservacoes());
        dto.setTecnicoNome(chamado.getTecnico().getNome());
        dto.setClienteNome(chamado.getCliente().getNome());

        return dto;
    }
}
