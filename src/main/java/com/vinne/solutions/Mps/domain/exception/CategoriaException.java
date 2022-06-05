package com.vinne.solutions.Mps.domain.exception;

import com.vinne.solutions.Mps.domain.enums.ExceptionReason;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class CategoriaException extends  RuntimeException{

    private ExceptionReason reason;

    public CategoriaException(ExceptionReason reason) {
        this.reason = reason;
    }
}
