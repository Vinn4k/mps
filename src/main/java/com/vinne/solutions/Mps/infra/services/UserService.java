package com.vinne.solutions.Mps.infra.services;

import com.vinne.solutions.Mps.domain.enums.ExceptionReason;
import com.vinne.solutions.Mps.domain.exception.LojaException;
import com.vinne.solutions.Mps.infra.model.Category;
import com.vinne.solutions.Mps.infra.model.UserModel;
import com.vinne.solutions.Mps.infra.repository.domain.CategoriaRepository;
import com.vinne.solutions.Mps.infra.repository.domain.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

@Service
@Slf4j
public class UserService {

    @Autowired
    UserRepository repository;

    @Autowired
    CategoriaRepository categoriaRepository;

   public ResponseEntity<String> createUser(UserModel user){
    try {
        if (user.getEmail() == null && user.getPassword() == null) {
            log.error("Os dados informados não podem ser nulos");
            throw new LojaException(ExceptionReason.ERRO_DADOS_INVALIDOS);
        }
            return repository.createUser(user);
        }catch(HttpServerErrorException e){
            log.error("Ocorreu um erro ao tentar inserir a Categoria: message{}", e.getMessage());
            throw new LojaException(ExceptionReason.ERRO_CRIAR_USUARIO);
        }
   }

    public void addCategoria(Category category){
        try {
            categoriaRepository.addCategoria(category);
        }catch (HttpServerErrorException e){
            log.error("Ocorreu um erro ao tentar inserir a Categoria: message{}", e.getMessage());
            throw new LojaException(ExceptionReason.ERRO_ADICIONAR_CATEGORIA);
        }
    }
    public void atualizarCategoria(Category category){
        try {
           categoriaRepository.atualizarCategoria(category);
        }catch (HttpServerErrorException e){
            log.error("Ocorreu um erro ao tentar atualizar a Categoria: message{}", e.getMessage());
            throw new LojaException(ExceptionReason.ERRO_ATUALIZAR_CATEGORIA);
        }
    }
}
