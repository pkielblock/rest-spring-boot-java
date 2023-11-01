package dev.kielblock.calculatorAPI.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@Getter
public class ExceptionResponse implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Date timestamp;
    private String message;
    private String details;
}
