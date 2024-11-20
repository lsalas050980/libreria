package com.crud.libreria.repository;

import com.crud.libreria.dao.Autor;
import com.crud.libreria.dao.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends JpaRepository<Libro,Long> {
}
