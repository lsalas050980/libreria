package com.crud.libreria.dto;

import jakarta.validation.constraints.*;

import java.io.Serializable;
import java.util.List;

public class AgregarLibroRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotBlank(message = "Titulo es obligatorio")
    private String nombreAutor;
    private List<Libro> libros;

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    public static class Libro implements Serializable {
        private static final long serialVersionUID = 1L;

        private Long idAutor;

        private String titulo;
        private String editorial;

        public String getTitulo() {
            return titulo;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public String getEditorial() {
            return editorial;
        }

        public void setEditorial(String editorial) {
            this.editorial = editorial;
        }

        public Long getIdAutor() {
            return idAutor;
        }

        public void setIdAutor(Long idAutor) {
            this.idAutor = idAutor;
        }
    }

}
