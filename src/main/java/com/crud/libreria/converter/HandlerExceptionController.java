package com.crud.libreria.converter;

import com.crud.libreria.dto.ErrorMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

@RestControllerAdvice
public class HandlerExceptionController {

    private static final Logger LOG = LoggerFactory.getLogger(HandlerExceptionController.class);


    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<ErrorMessage> badRequest(final MethodArgumentNotValidException ex) {
        LOG.error("Detalle error request", ex);
        var mensaje = "";
        var field = ex.getBindingResult().getFieldError("password");
        if(Objects.nonNull(field)) {
            mensaje = field.getDefaultMessage();
        }else {
            mensaje = "Request no válido";
        }
        return new ResponseEntity<>(buildMessage(mensaje), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    ResponseEntity<ErrorMessage> exception(final Exception ex) {
        LOG.error("Detalle error: ",ex);
        return new ResponseEntity<>(buildMessage("Hubo un error inesperado"), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private static ErrorMessage buildMessage(String message) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setMensaje(message);
        return errorMessage;
    }

}
