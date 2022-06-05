package com.vinne.solutions.Mps.domain.enums;

import lombok.Getter;

@Getter
public enum ExceptionReason {

    ERRO_ADICIONAR_CATEGORIA("ERRO_ADICIONAR_CATEGORIA","Houve um erro ao tentar adicionar a categoria");

    private String titulo;
    private String descricao;

    ExceptionReason(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
    }
}
