package com.vinne.solutions.Mps.infra.repository.domain;

import com.vinne.solutions.Mps.infra.model.UserModel;
import org.springframework.http.ResponseEntity;

public interface UserRepository {

    ResponseEntity<String> createUser(UserModel user);
}
