package com.crud.libreria.controller;

import com.crud.libreria.dto.AgregarLibroRequest;
import com.crud.libreria.dto.AutorRequest;
import com.crud.libreria.dto.LibroRequest;
import com.crud.libreria.dto.LibroResponse;
import com.crud.libreria.service.LibreriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/libreria")
public class LibreriaController {

    private final LibreriaService libreriaService;

    @Autowired
    public LibreriaController(final LibreriaService libreriaService) {
        this.libreriaService = libreriaService;
    }

    @PostMapping(value = "/registro")
    public void agregarAutorLibro(@RequestBody @Valid AgregarLibroRequest agregarLibroRequest) {
        this.libreriaService.agregarLibroUsuario(agregarLibroRequest);
    }

    @PostMapping(value = "/nuevo-autor")
    public void agregarAutor(@RequestBody @Valid AutorRequest agregarAutorRequest) {
        this.libreriaService.agregarNuevoAutor(agregarAutorRequest);
    }

    @PostMapping(value = "/nuevo-libro")
    public void agregarLibro(@RequestBody @Valid LibroRequest agregarLibroRequest) {
        this.libreriaService.agregarNuevoLibro(agregarLibroRequest);
    }

    @DeleteMapping (value = "/borrar-libro")
    public void borrarLibro(@RequestBody LibroRequest borrarLibroRequest) {
        this.libreriaService.borrarLibro(borrarLibroRequest);
    }

    @DeleteMapping (value = "/borrar-autor")
    public void borrarAutor(@RequestBody AutorRequest borrarAutorRequest) {
        this.libreriaService.borrarAutor(borrarAutorRequest);
    }

    @PutMapping (value = "/modificar-libro")
    public void modificarLibro(@RequestBody LibroRequest modificarLibroRequest) {
        this.libreriaService.modificarLibro(modificarLibroRequest);
    }

    @PutMapping (value = "/modificar-autor")
    public void modificarAutor(@RequestBody AutorRequest modificarAutorRequest) {
        this.libreriaService.modificarAutor(modificarAutorRequest);
    }

    @GetMapping (value = "/listar-autores")
    public Object listarAutores() {
        return this.libreriaService.listarAutores();
    }

    @GetMapping (value = "/listar-libros")
    public List<LibroResponse> listarLibros() {
        return this.libreriaService.listarLibros();
    }
}
