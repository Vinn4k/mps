package com.vinne.solutions.Mps.infra.services;

import com.vinne.solutions.Mps.infra.model.UserModel;
import com.vinne.solutions.Mps.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

   public ResponseEntity<String> createUser(UserModel user){
        try {
           if (user.getEmail() !=null&&user.getPassword()!=null){
               Optional<UserModel> userIsPresent= Optional.ofNullable(repository.findByEmail(user.getEmail()));
               if (userIsPresent.isPresent()){

                   return new ResponseEntity<>("Usuário já cadastrado",HttpStatus.CONFLICT);

               }else {
                   String uuid = UUID.randomUUID().toString().replace("-","");
                   user.setUuid(uuid);
                   repository.save(user);
                   return new  ResponseEntity<>("Usuário:"+user.getEmail()+" Criado com sucesso",HttpStatus.CREATED);
               }

           }
            return new  ResponseEntity<>("Dados inválido ",HttpStatus.BAD_REQUEST);
        }catch (HttpServerErrorException e){
            return new ResponseEntity<>("Erro desconhecido", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
