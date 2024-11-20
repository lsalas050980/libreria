package com.crud.libreria.dto;

import java.io.Serializable;

public class AutorRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long idAutor;
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Long idAutor) {
        this.idAutor = idAutor;
    }
}
