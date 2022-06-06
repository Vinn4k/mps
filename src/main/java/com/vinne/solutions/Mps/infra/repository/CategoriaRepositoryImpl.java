package com.vinne.solutions.Mps.infra.repository;

import com.vinne.solutions.Mps.domain.enums.ExceptionReason;
import com.vinne.solutions.Mps.domain.exception.LojaException;
import com.vinne.solutions.Mps.domain.repository.CategoriaRepositoryData;
import com.vinne.solutions.Mps.infra.model.Category;
import com.vinne.solutions.Mps.domain.repository.ports.CategoriaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
public class CategoriaRepositoryImpl implements CategoriaRepository {

    @Autowired
    CategoriaRepositoryData repository;

    @Override
    public void addCategoria(Category category) {
        try {
            repository.save(category);
        }catch (RuntimeException e){
            log.error("Ocorreu um erro ao tentar inserir a Categoria: message{}", e.getMessage());
            throw new LojaException(ExceptionReason.ERRO_ADICIONAR_CATEGORIA);
        }
    }

    @Override
    public void atualizarCategoria(Category category) {
        try {
            repository.save(category);
        }catch (RuntimeException e){
            log.error("Ocorreu um erro ao tentar atualizar a Categoria: message{}", e.getMessage());
            throw new LojaException(ExceptionReason.ERRO_ATUALIZAR_CATEGORIA);
        }
    }

    @Override
    public List<Category> listarCategorias() {
        try {
            return repository.findAll();
        }catch (RuntimeException e){
            log.error("Ocorreu um erro ao tentar buscar todas as Categorias: message{}", e.getMessage());
            throw new LojaException(ExceptionReason.ERRO_LISTAR_CATEGORIAS);
        }
    }
}
