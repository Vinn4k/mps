package com.vinne.solutions.Mps.infra.repository;

import com.vinne.solutions.Mps.domain.exception.LojaException;
import com.vinne.solutions.Mps.domain.repository.CategoriaRepositoryData;
import com.vinne.solutions.Mps.infra.model.Category;
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
import org.springframework.web.client.HttpServerErrorException;

@ExtendWith(MockitoExtension.class)
class CategoriaRepositoryImplTest {
    
    @InjectMocks
    CategoriaRepositoryImpl repository;
    
   @Mock
    CategoriaRepositoryData data;

   EasyRandom easyRandom;

   @BeforeEach
   public  void setUp(){
       easyRandom = new EasyRandom();
   }

    @Test
    void addCategoria() {
       var categoria = easyRandom.nextObject(Category.class);

       repository.addCategoria(categoria);
    }

    @Test
    void atualizarCategoria() {

        var categoria = easyRandom.nextObject(Category.class);

        repository.atualizarCategoria(categoria);
    }

    @Test
    void addCategoriaErro() {
        var categoria = easyRandom.nextObject(Category.class);

        Mockito.doThrow(new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR))
                .when(data).save(categoria);

        Assertions.assertThrows(LojaException.class,() -> repository.addCategoria(categoria));
    }

    @Test
    void atualizarCategoriaErro() {

        var categoria = easyRandom.nextObject(Category.class);

        Mockito.doThrow(new IllegalArgumentException())
                .when(data).save(categoria);

        Assertions.assertThrows(LojaException.class,() -> repository.atualizarCategoria(categoria));
    }

    @Test
    void listarCategoria() {
        repository.listarCategorias();
    }

    @Test
    void listarCategoriaErroadd() {
        Mockito.doThrow(new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR))
                .when(data).findAll();

        Assertions.assertThrows(LojaException.class,() -> repository.listarCategorias());
    }
}