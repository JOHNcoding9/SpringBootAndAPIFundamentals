package com.example.demo.dto;

import java.time.LocalDate;
import com.example.demo.domain.entities.Tecnico;

public class TecnicoResponseDTO {

    private Integer id;
    private String nome;
    private String email;
    private LocalDate dataCriacao;


    public TecnicoResponseDTO(Tecnico tecnico) {
        this.id = tecnico.getId();
        this.nome = tecnico.getNome();
        this.email = tecnico.getEmail();
        this.dataCriacao = tecnico.getDataCriacao();
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
