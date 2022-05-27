package com.vinne.solutions.Mps.domain.repository;

import com.vinne.solutions.Mps.domain.enums.ExceptionReason;
import com.vinne.solutions.Mps.domain.exception.LojaException;
import com.vinne.solutions.Mps.infra.model.Category;
import com.vinne.solutions.Mps.infra.repository.CategoriaRepositoryData;
import com.vinne.solutions.Mps.infra.repository.domain.CategoriaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpServerErrorException;

@Repository
@Slf4j
public class CategoriaRepositoryImpl implements CategoriaRepository {

    @Autowired
    CategoriaRepositoryData repository;

    @Override
    public void addCategoria(Category category) {
        try {
            repository.save(category);
        }catch (HttpServerErrorException e){
            log.error("Ocorreu um erro ao tentar inserir a Categoria: message{}", e.getMessage());
            throw new LojaException(ExceptionReason.ERRO_ADICIONAR_CATEGORIA);
        }
    }

    @Override
    public void atualizarCategoria(Category category) {
        try {
            repository.save(category);
        }catch (HttpServerErrorException e){
            log.error("Ocorreu um erro ao tentar atualizar a Categoria: message{}", e.getMessage());
            throw new LojaException(ExceptionReason.ERRO_ADICIONAR_CATEGORIA);
        }
    }

}
