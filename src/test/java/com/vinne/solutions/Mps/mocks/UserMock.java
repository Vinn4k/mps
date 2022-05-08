package com.vinne.solutions.Mps.mocks;

import com.vinne.solutions.Mps.model.UserModel;

public class UserMock {

   public UserModel userMock(){
          UserModel model = new UserModel();
        model.setCpf("00000000000");
        model.setEmail("teste@t.com");
        model.setFirstName("Geremias");
        model.setLastName("Virgulino");
        model.setId(123L);
        model.setPassword("1234");

        return  model;
    }
}
