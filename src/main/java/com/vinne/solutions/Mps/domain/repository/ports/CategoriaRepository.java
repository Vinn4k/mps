package com.vinne.solutions.Mps.domain.repository.ports;

import com.vinne.solutions.Mps.infra.model.Category;

public interface CategoriaRepository {

    void addCategoria(Category category);

    void atualizarCategoria(Category category);
}
