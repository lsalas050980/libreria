package com.crud.libreria.converter;

import com.crud.libreria.dao.Autor;
import com.crud.libreria.dao.Libro;
import com.crud.libreria.dto.AgregarLibroRequest;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AutorLibroRequestToUserDB implements Converter<AgregarLibroRequest, Autor> {

    @Override
    public Autor convert(AgregarLibroRequest source) {
        Autor autor = new Autor();
        autor.setName(source.getNombreAutor());
        autor.addLibro(getLibros(source.getLibros()));
        return autor;
    }

    private List<Libro> getLibros(List<AgregarLibroRequest.Libro> libros){
        return libros.stream().map((libro) -> {
           Libro libroDb = new Libro();
           libroDb.setTitulo(libro.getTitulo());
           libroDb.setEditorial(libro.getEditorial());
           return libroDb;

        }).toList();
    }
}
