package com.alura.ForoHub;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Model {

    // Getters y setters
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter
    @Setter
    @Column(unique = true)
    private String titulo;
    @Getter
    @Setter
    private String mensaje;
    private LocalDateTime fechaCreacion;
    private String estado;
    @Getter
    @Setter
    private String autor;
    @Setter
    @Getter
    private String curso;

}