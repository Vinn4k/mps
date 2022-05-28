package com.vinne.solutions.Mps.presenter.controller.exception;

import com.vinne.solutions.Mps.domain.enums.ExceptionReason;
import com.vinne.solutions.Mps.domain.exception.LojaException;
import loja.v1.model.ApiResponseRepresentation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class UserControllerAdviceTest {

    @InjectMocks
    UserControllerAdvice advice;

    @Test
    void handleConflict() {
        var apiErro = new ApiResponseRepresentation();
        apiErro.setTitle("ERRO_ADICIONAR_CATEGORIA");
        apiErro.setMessage("Houve um erro ao tentar adicionar a categoria");
        var response = advice.handleConflict(new Exception(), new LojaException(ExceptionReason.ERRO_ADICIONAR_CATEGORIA));
        Assertions.assertEquals(apiErro,response.getBody());
    }
}