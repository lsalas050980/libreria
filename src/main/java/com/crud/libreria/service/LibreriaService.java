package com.crud.libreria.service;

import com.crud.libreria.dao.Autor;
import com.crud.libreria.dao.Libro;
import com.crud.libreria.dto.*;
import com.crud.libreria.repository.AutorRepository;
import com.crud.libreria.repository.LibroRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.ConversionService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibreriaService {
    
    private final AutorRepository autorRepository;
    private final LibroRepository libroRepository;
    private final ConversionService conversionService;

    public LibreriaService(final AutorRepository autorRepository,
                           final ConversionService conversionService,
                           final LibroRepository libroRepository) {
        this.autorRepository = autorRepository;
        this.libroRepository = libroRepository;

        this.conversionService = conversionService;
    }

    private final static Logger LOG = LoggerFactory.getLogger(LibreriaService.class);

    public void agregarLibroUsuario(AgregarLibroRequest agregarLibroRequest) {
        try {
            var userDB = this.autorRepository.save(this.conversionService.convert(agregarLibroRequest, Autor.class));
            LOG.info("Registro creado exitosamente", userDB);
        }catch (DataIntegrityViolationException ex) {
            LOG.error("Error en bd",ex);
            throw new RuntimeException(ex);
        }

    }

    public void agregarNuevoAutor(AutorRequest autorRequest) {
        try {
            com.crud.libreria.dao.Autor autor = new com.crud.libreria.dao.Autor();
            autor.setName(autorRequest.getNombre());
            var userDB = this.autorRepository.save(autor);
            LOG.info("Registro creado exitosamente", userDB);
        }catch (DataIntegrityViolationException ex) {
            LOG.error("Error en bd",ex);
            throw new RuntimeException(ex);
        }

    }


    public void agregarNuevoLibro(LibroRequest libroRequest) {
        try {
            com.crud.libreria.dao.Autor autor = new com.crud.libreria.dao.Autor();
            autor.setId(libroRequest.getIdAutor());
            Libro libro = new Libro();
            libro.setAutor(autor);
            libro.setTitulo(libroRequest.getTitulo());
            libro.setEditorial(libroRequest.getEditorial());

            var userDB = this.libroRepository.save(libro);
            LOG.info("Registro creado exitosamente", userDB);
        }catch (DataIntegrityViolationException ex) {
            LOG.error("Error en bd",ex);
            throw new RuntimeException(ex);
        }

    }

    public void borrarLibro(LibroRequest libroRequest) {
        try {
            Libro libro = new Libro();
            libro.setId(libroRequest.getIdLibro());

            this.libroRepository.delete(libro);
            LOG.info("Registro eliminado exitosamente");
        }catch (DataIntegrityViolationException ex) {
            LOG.error("Error en bd",ex);
            throw new RuntimeException(ex);
        }

    }

    public void borrarAutor(AutorRequest autorRequest) {
        try {
            Autor autor = new Autor();
            autor.setId(autorRequest.getIdAutor());

            this.autorRepository.delete(autor);
            LOG.info("Registro eliminado exitosamente");
        }catch (DataIntegrityViolationException ex) {
            LOG.error("Error en bd",ex);
            throw new RuntimeException(ex);
        }

    }
    public void modificarLibro(LibroRequest libroRequest) {
        try {
             var libroBD = this.libroRepository.getReferenceById(libroRequest.getIdLibro());


            Libro libro = new Libro();
            libro.setAutor(libroBD.getAutor());
            libro.setId(libroRequest.getIdLibro());
            libro.setTitulo(libroRequest.getTitulo());
            libro.setEditorial(libroRequest.getEditorial());

            var userDB = this.libroRepository.save(libro);
            LOG.info("Registro modificado exitosamente", userDB);
        }catch (DataIntegrityViolationException ex) {
            LOG.error("Error en bd",ex);
            throw new RuntimeException(ex);
        }

    }

    public void modificarAutor(AutorRequest autorRequest) {
        try {
            Autor autor = new Autor();
            autor.setName(autorRequest.getNombre());
            autor.setId(autorRequest.getIdAutor());

            var userDB = this.autorRepository.save(autor);
            LOG.info("Registro modificado exitosamente", userDB);
        }catch (DataIntegrityViolationException ex) {
            LOG.error("Error en bd",ex);
            throw new RuntimeException(ex);
        }

    }

    public Object listarAutores(){
        return this.autorRepository.findAll();
    }

    public List<LibroResponse> listarLibros(){
        List<Libro> all = this.libroRepository.findAll();
        return all.stream().map((libro -> {
            LibroResponse libroResponse = new LibroResponse();
            AutorResponse autorResponse = new AutorResponse();
            autorResponse.setNombre(libro.getAutor().getName());
            libroResponse.setAutor(autorResponse);
            libroResponse.setEditorial(libro.getEditorial());
            libroResponse.setTitulo(libro.getTitulo());
            return libroResponse;
        })).toList();
    }

}

