package com.example.demo.domain.enums;

public enum Status {

    ABERTO(1, "ABERTO"),
    ANDAMENTO(2, "ANDAMENTO"),
    ENCERRADO(3, "ENCERRADO");

    private final int codigo;
    private final String descricao;

    Status(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Status toEnum(Integer cod) {
        if (cod == null) {
            return null;
        }

        for (Status x : Status.values()) {
            if (cod.equals(x.getCodigo())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Status inválido: " + cod);
    }
}
