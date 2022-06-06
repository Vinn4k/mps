package com.vinne.solutions.Mps.domain.exception;

import com.vinne.solutions.Mps.domain.enums.ExceptionReason;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LojaException extends  RuntimeException{

    private ExceptionReason reason;

    public LojaException(ExceptionReason reason) {
        this.reason = reason;
    }
}
