package com.vinne.solutions.Mps.domain.repository;

import com.vinne.solutions.Mps.infra.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepositoryData extends JpaRepository<Category,Long> {
}
