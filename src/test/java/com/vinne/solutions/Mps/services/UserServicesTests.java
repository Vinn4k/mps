package com.vinne.solutions.Mps.services;

import com.vinne.solutions.Mps.mocks.UserMock;
import com.vinne.solutions.Mps.model.UserModel;
import com.vinne.solutions.Mps.repository.UserRepository;
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
    public  void setUp(){
        MockitoAnnotations.openMocks(this);
    }
    UserMock userMocked=new UserMock();

    @Test
    @DisplayName("Criar usuário")
    void newUser() {
        UserModel model = userMocked.userMock();

        ResponseEntity<String> data = service.createUser(model);
        assertEquals(new ResponseEntity<>(model,HttpStatus.CREATED),data);

    }


}
