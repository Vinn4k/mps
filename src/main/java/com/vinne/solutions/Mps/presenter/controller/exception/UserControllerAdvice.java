package com.vinne.solutions.Mps.presenter.controller.exception;

import com.vinne.solutions.Mps.domain.exception.CategoriaException;
import loja.v1.model.ApiResponseRepresentation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class UserControllerAdvice extends ResponseEntityExceptionHandler {

        @ExceptionHandler(value = CategoriaException.class)
        protected ResponseEntity<Object> handleConflict(Exception ex, CategoriaException request) {
            var body = new ApiResponseRepresentation();
            body.setTitle(request.getReason().getTitulo());
            body.setMessage(request.getReason().getDescricao());
            return new ResponseEntity<>(body, HttpStatus.UNPROCESSABLE_ENTITY);
        }

}
