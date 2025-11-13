package com.example.demo.dto;

import java.time.LocalDate;

public class ClienteResponseDTO {

    private Integer id;
    private String nome;
    private String email;
    private String cpf;
    private LocalDate dataCriacao;


    public ClienteResponseDTO(Integer id, String nome, String email, String cpf, LocalDate dataCriacao) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dataCriacao = dataCriacao;
    }


    public Integer getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
    public String getCpf() {return cpf; }
    public LocalDate getDataCriacao() {
        return dataCriacao;
    }
}
