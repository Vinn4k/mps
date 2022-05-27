package com.vinne.solutions.Mps.infra.repository.domain;

import com.vinne.solutions.Mps.infra.model.Category;

public interface CategoriaRepository {

    void addCategoria(Category category);

    void atualizarCategoria(Category category);
}
