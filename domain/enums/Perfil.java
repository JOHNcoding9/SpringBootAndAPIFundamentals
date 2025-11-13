package com.example.demo.domain.enums;

public enum Perfil {

    ADMIN(1, "ADMIN"),
    CLIENTE(2, "CLIENTE"),
    TECNICO(3, "TECNICO");

    private final int codigo;
    private final String descricao;

    Perfil(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Perfil toEnum(Integer cod) {
        if (cod == null) {
            return null;
        }

        for (Perfil x : Perfil.values()) {
            if (cod.equals(x.getCodigo())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Perfil inválido: " + cod);
    }
}
