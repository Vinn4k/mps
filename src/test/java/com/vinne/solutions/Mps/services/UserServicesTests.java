package com.vinne.solutions.Mps.services;

import com.vinne.solutions.Mps.domain.services.UserService;
import com.vinne.solutions.Mps.mocks.UserMock;
import com.vinne.solutions.Mps.domain.repository.UserRepositoryData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

@DisplayName("Teste UserService")
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

//    @Test
//    @DisplayName("Criar usuário")
//    void newUser() {
//        UserModel model = userMocked.userMock();
//
//        ResponseEntity<String> data = service.createUser(model);
//        assertEquals(new ResponseEntity<>(data,HttpStatus.CREATED),data);
//
//    }


}
