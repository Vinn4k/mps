package com.vinne.solutions.Mps.services;

import com.vinne.solutions.Mps.infra.services.UserService;
import com.vinne.solutions.Mps.mocks.UserMock;
import com.vinne.solutions.Mps.presenter.model.UserModel;
import com.vinne.solutions.Mps.domain.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Teste UserService")
public class UserServicesTests {

    @InjectMocks
    UserService service;

    @Mock
    UserRepository repository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    UserMock userMocked = new UserMock();
    UserModel model = userMocked.userMock();

    @Test
    @DisplayName("Criar usuário")
    void newUser() {

        ResponseEntity<String> data = service.createUser(model);
        assertEquals(new ResponseEntity<>("Usuário:" + model.getEmail() + " Criado com sucesso", HttpStatus.CREATED), data);

    }@Test
    @DisplayName("Usuário duplicado ")
    void duplicateUser() {

        ResponseEntity<String> data = service.createUser(model);
        assertEquals(new ResponseEntity<>("Usuário:" + model.getEmail() + " Criado com sucesso", HttpStatus.CREATED), data);

    }


}
