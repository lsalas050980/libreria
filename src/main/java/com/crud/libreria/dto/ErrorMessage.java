package com.crud.libreria.dto;

import java.io.Serializable;

public class ErrorMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    private String mensaje;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
