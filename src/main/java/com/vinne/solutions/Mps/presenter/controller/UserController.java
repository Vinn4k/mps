package com.vinne.solutions.Mps.presenter.controller;

import com.vinne.solutions.Mps.presenter.model.UserModel;
import com.vinne.solutions.Mps.infra.services.UserService;
import com.vinne.solutions.Mps.presenter.mapper.LojaMapper;
import loja.v1.api.CategoriaApi;
import loja.v1.model.CategoryRepresentation;
import loja.v1.model.ListarCategoriaRepresentation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

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

        var category = mapper.paraCategoriaDomain(body);
        userService.addCategoria(category);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> atualizarCategoria(CategoryRepresentation body) {
        var category = mapper.paraCategoriaDomain(body);
        userService.atualizarCategoria(category);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
