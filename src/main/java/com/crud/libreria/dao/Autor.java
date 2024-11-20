package com.crud.libreria.dao;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="autor",uniqueConstraints = {@UniqueConstraint(name = "emailUnique",columnNames = {"email"})})
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @CreatedDate
    @Column(updatable = false)
    private Date created;
    @LastModifiedDate
    private Date modified;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "autor")
    private List<Libro> libros = new ArrayList<>();

    public void addLibro(Libro libro) {
        this.libros.add(libro);
        libro.setAutor(this);
    }

    public void addLibro(List<Libro> libros) {
        libros.forEach(libro -> {
            this.libros.add(libro);
            libro.setAutor(this);
        });
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }


}
