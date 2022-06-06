package com.vinne.solutions.Mps.presenter.controller;

import com.vinne.solutions.Mps.domain.enums.ExceptionReason;
import com.vinne.solutions.Mps.domain.exception.LojaException;
import com.vinne.solutions.Mps.domain.services.UserService;
import com.vinne.solutions.Mps.infra.mapper.LojaMapper;
import com.vinne.solutions.Mps.infra.model.Category;
import com.vinne.solutions.Mps.util.LojaUtils;
import loja.v1.model.CategoryRepresentation;
import loja.v1.model.ListCategoriesRepresentation;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @InjectMocks
    UserController controller;

    @Mock
    UserService userService;
    @Mock
    LojaMapper mapper;

    EasyRandom easyRandom;

    @BeforeEach
    public  void setUp(){
        easyRandom = new EasyRandom();
    }

    @Test
    void newUser() {
        var domain = LojaUtils.userMock();

       Mockito.when(userService.createUser(domain))
               .thenReturn(new ResponseEntity<String>(HttpStatus.OK));

        Assertions.assertEquals(new ResponseEntity<>(HttpStatus.OK),controller.newUser(domain));

    }

    @Test
    void addCategoria() {

        var representation = LojaUtils.categoryRepresentationMock();
        var domain = LojaUtils.categoryDomainMock();

        Mockito.when(mapper.paraCategoriaDomain(representation))
                .thenReturn(domain);

        Mockito.doNothing().when(userService).addCategoria(domain);

        Assertions.assertEquals(new ResponseEntity<>(HttpStatus.CREATED),controller.addCategoria(representation));
    }

    @Test
    void atualizarCategoria() {
        var representation = LojaUtils.categoryRepresentationMock();
        var domain = LojaUtils.categoryDomainMock();

        Mockito.when(mapper.paraCategoriaDomain(representation))
                .thenReturn(domain);

        Mockito.doNothing().when(userService).atualizarCategoria(domain);

        Assertions.assertEquals(new ResponseEntity<>(HttpStatus.OK),controller.atualizarCategoria(representation));

    }

    @Test
    void listarCategorias() {
        var representation = LojaUtils.categoryRepresentationMock();
        var domain = LojaUtils.categoryDomainMock();
        List<Category> listDomain = new ArrayList<>();
        listDomain.add(domain);

        List<CategoryRepresentation> listRep = new ArrayList<>();
        listRep.add(representation);

        Mockito.when(userService.listarCategorias()).thenReturn(listDomain);

        Mockito.when(mapper.paraListaDeCategoriasRepresentation(listDomain))
                .thenReturn(listRep);

        Assertions.assertEquals(new ListCategoriesRepresentation().categories(listRep),controller.listarCategorias().getBody());

    }

    @Test
    void newUserErroCriarUsuario() {
        var domain = LojaUtils.userMock();

        Mockito.when(userService.createUser(domain))
                .thenThrow(new LojaException(ExceptionReason.ERRO_CRIAR_USUARIO));

        Assertions.assertThrows(LojaException.class,() -> controller.newUser(domain));

    }

    @Test
    void addCategoriaErro() {

        var representation = LojaUtils.categoryRepresentationMock();
        var domain = LojaUtils.categoryDomainMock();

        Mockito.when(mapper.paraCategoriaDomain(representation))
                .thenReturn(domain);

        Mockito.doThrow(new LojaException(ExceptionReason.ERRO_ADICIONAR_CATEGORIA))
                .when(userService).addCategoria(domain);

        Assertions.assertThrows(LojaException.class,() -> controller.addCategoria(representation));
    }

    @Test
    void atualizarCategoriaErro() {
        var representation = LojaUtils.categoryRepresentationMock();
        var domain = LojaUtils.categoryDomainMock();

        Mockito.when(mapper.paraCategoriaDomain(representation))
                .thenReturn(domain);

        Mockito.doThrow(new LojaException(ExceptionReason.ERRO_ATUALIZAR_CATEGORIA))
                .when(userService).atualizarCategoria(domain);

        Assertions.assertThrows(LojaException.class,() -> controller.atualizarCategoria(representation));
    }

    @Test
    void listarCategoriasErro() {
        Mockito.doThrow(new LojaException(ExceptionReason.ERRO_ATUALIZAR_CATEGORIA))
                .when(userService).listarCategorias();

        Assertions.assertThrows(LojaException.class,() -> controller.listarCategorias());
    }

}