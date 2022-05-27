package com.vinne.solutions.Mps.domain.repository;

import com.vinne.solutions.Mps.domain.enums.ExceptionReason;
import com.vinne.solutions.Mps.domain.exception.LojaException;
import com.vinne.solutions.Mps.infra.model.UserModel;
import com.vinne.solutions.Mps.infra.repository.UserRepositoryData;
import com.vinne.solutions.Mps.infra.repository.domain.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpServerErrorException;

import java.util.Optional;
import java.util.UUID;

@Repository
@Slf4j
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    UserRepositoryData repository;

    @Override
    public ResponseEntity<String> createUser(UserModel user) {
        try {
        Optional<UserModel> userIsPresent= Optional.ofNullable(repository.findByEmail(user.getEmail()));
        if (userIsPresent.isPresent()){

            return new ResponseEntity<>("Usuário já cadastrado", HttpStatus.CONFLICT);
        }
            String uuid = UUID.randomUUID().toString().replace("-","");
            user.setUuid(uuid);
            repository.save(user);
            return new  ResponseEntity<>("Usuário:"+user.getEmail()+" Criado com sucesso",HttpStatus.CREATED);
        }catch (HttpServerErrorException e){
            throw new LojaException(ExceptionReason.ERRO_CRIAR_USUARIO);
        }
    }
}
