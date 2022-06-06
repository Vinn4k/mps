package com.vinne.solutions.Mps.domain.enums;

import lombok.Getter;

@Getter
public enum ExceptionReason {

    ERRO_CRIAR_USUARIO("ERRO_CRIAR_USUARIO","Houve um erro ao tentar criar um usuario"),
    ERRO_DADOS_INVALIDOS("ERRO_DADOS_INVALIDOS","Dados inválidos"),
    ERRO_ADICIONAR_CATEGORIA("ERRO_ADICIONAR_CATEGORIA","Houve um erro ao tentar adicionar a categoria"),
    ERRO_ATUALIZAR_CATEGORIA("ERRO_ATUALIZAR_CATEGORIA","Houve um erro ao tentar atualizar a categoria"),
    ERRO_LISTAR_CATEGORIAS("ERRO_LISTAR_CATEGORIAS","Houve um erro ao tentar buscar as categorias");

    private String titulo;
    private String descricao;

    ExceptionReason(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
    }
}
