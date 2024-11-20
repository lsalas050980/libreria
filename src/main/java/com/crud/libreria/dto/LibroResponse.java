package com.crud.libreria.dto;

public class LibroResponse {

    private AutorResponse autor;
    private String editorial;
    private String titulo;

    public AutorResponse getAutor() {
        return autor;
    }

    public void setAutor(AutorResponse autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
