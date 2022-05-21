package com.vinne.solutions.Mps.domain.repository;

import com.vinne.solutions.Mps.presenter.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel,Long> {
    UserModel findByEmail(String email);
}
