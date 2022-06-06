package com.vinne.solutions.Mps.domain.repository.ports;

import com.vinne.solutions.Mps.infra.model.UserModel;
import org.springframework.http.ResponseEntity;

public interface UserRepository {

    ResponseEntity<String> createUser(UserModel user);
}
