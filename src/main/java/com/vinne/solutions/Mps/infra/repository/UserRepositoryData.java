package com.vinne.solutions.Mps.infra.repository;

import com.vinne.solutions.Mps.infra.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryData extends JpaRepository<UserModel,Long> {
    UserModel findByEmail(String email);
}
