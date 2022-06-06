package com.vinne.solutions.Mps.domain.services;

import com.vinne.solutions.Mps.domain.enums.ExceptionReason;
import com.vinne.solutions.Mps.domain.exception.LojaException;
import com.vinne.solutions.Mps.infra.model.Category;
import com.vinne.solutions.Mps.infra.model.UserModel;
import com.vinne.solutions.Mps.domain.repository.ports.CategoriaRepository;
import com.vinne.solutions.Mps.domain.repository.ports.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserService {

    @Autowired
    UserRepository repository;

    @Autowired
    CategoriaRepository categoriaRepository;

   public ResponseEntity<String> createUser(UserModel user){
    try {
        if (user.getEmail() == null || user.getPassword() == null) {
            log.error("Os dados informados não podem ser nulos");
            throw new LojaException(ExceptionReason.ERRO_DADOS_INVALIDOS);
        }
            return repository.createUser(user);
        }catch(HttpServerErrorException e){
            log.error("Ocorreu um erro ao tentar inserir o Usuario: message{}", e.getMessage());
            throw new LojaException(ExceptionReason.ERRO_CRIAR_USUARIO);
        }
   }

    public void addCategoria(Category category){
            categoriaRepository.addCategoria(category);
    }
    public void atualizarCategoria(Category category){
           categoriaRepository.atualizarCategoria(category);
    }
    public List<Category> listarCategorias(){
         log.debug("Service");
          var list = categoriaRepository.listarCategorias();
          return list.stream().filter(Category::isAtivo).collect(Collectors.toList());
    }
}
