package com.vinne.solutions.Mps.domain.repository;

import com.vinne.solutions.Mps.domain.usercases.Category;
import com.vinne.solutions.Mps.infra.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Category,Long> {
}
