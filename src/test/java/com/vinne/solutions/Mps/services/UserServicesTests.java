package com.vinne.solutions.Mps.services;

import com.vinne.solutions.Mps.domain.services.UserService;
import com.vinne.solutions.Mps.infra.model.UserModel;
import com.vinne.solutions.Mps.mocks.UserMock;
import com.vinne.solutions.Mps.domain.repository.UserRepositoryData;
import com.vinne.solutions.Mps.util.LojaUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Teste UserService")
@ExtendWith(MockitoExtension.class)
public class UserServicesTests {

    @InjectMocks
    UserService service;

    @Mock
    UserRepositoryData repository;

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
        assertEquals(new ResponseEntity<>(data, HttpStatus.CREATED),data);
    }
//
//    @Test
//    void addCategoria() {
//        var representation = LojaUtils.categoryRepresentationMock();
//
//        Mockito.doNothing().when(userService).addCategoria(domain);
//
//        Assertions.assertEquals(new ResponseEntity<>(HttpStatus.CREATED),service.addCategoria(representation));
//    }
//
//    @Test
//    void atualizarCategoria() {
//        var domain = LojaUtils.categoryDomainMock();
//
//        Mockito.doNothing().when(service).atualizarCategoria(domain);
//
//        Assertions.assertEquals(new ResponseEntity<>(HttpStatus.OK),controller.atualizarCategoria(representation));
//    }
}
