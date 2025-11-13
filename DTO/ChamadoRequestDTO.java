package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;


public class ChamadoRequestDTO {

    @NotNull(message = "Prioridade é obrigatória")
    private Integer prioridade;

    @NotNull(message = "Status é obrigatório")
    private Integer status;

    @NotBlank(message = "Título é obrigatório")
    private String titulo;

    private String observacoes;

    @NotNull(message = "ID do técnico é obrigatório")
    private Integer tecnicoId;

    @NotNull(message = "ID do cliente é obrigatório")
    private Integer clienteId;

    private LocalDate dataFechamento;


    public Integer getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Integer prioridade) {
        this.prioridade = prioridade;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Integer getTecnicoId() {
        return tecnicoId;
    }

    public void setTecnicoId(Integer tecnicoId) {
        this.tecnicoId = tecnicoId;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }


    public LocalDate getDataFechamento() {
        return dataFechamento;
    }
    public void setDataFechamento(LocalDate dataFechamento) {
        this.dataFechamento = dataFechamento ;
    }
}
