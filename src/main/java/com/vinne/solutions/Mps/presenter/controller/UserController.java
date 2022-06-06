package com.vinne.solutions.Mps.presenter.controller;

import com.vinne.solutions.Mps.domain.services.UserService;
import com.vinne.solutions.Mps.infra.mapper.LojaMapper;
import com.vinne.solutions.Mps.infra.model.UserModel;
import loja.v1.api.CategoriaApi;
import loja.v1.model.CategoryRepresentation;
import loja.v1.model.ListCategoriesRepresentation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
public class UserController implements CategoriaApi {

    @Autowired
    private final UserService userService;
    @Autowired
    private final LojaMapper mapper;

    @ResponseBody
    @PostMapping(value = "/singup",consumes = "application/json")
    public ResponseEntity<String> newUser(@RequestBody UserModel user) {

        return userService.createUser(user);
    }

    @Override
    public ResponseEntity<Void> addCategoria(CategoryRepresentation body) {
        log.debug("Iniciando Request Adicionar Categoria");
        var category = mapper.paraCategoriaDomain(body);
        userService.addCategoria(category);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> atualizarCategoria(CategoryRepresentation body) {
        log.debug("Iniciando Request Atualizar Categoria");
        var category = mapper.paraCategoriaDomain(body);
        userService.atualizarCategoria(category);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ListCategoriesRepresentation> listarCategorias() {
        log.debug("Iniciando Request Listar Categorias");
        var response = new ListCategoriesRepresentation()
                .categories(mapper.paraListaDeCategoriasRepresentation(userService.listarCategorias()));
        return ResponseEntity.ok(response);
    }
}
