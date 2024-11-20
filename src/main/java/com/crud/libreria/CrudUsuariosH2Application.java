package com.crud.libreria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CrudUsuariosH2Application {

    public static void main(String[] args) {
        SpringApplication.run(CrudUsuariosH2Application.class, args);
    }

}
