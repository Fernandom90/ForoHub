package com.alura.ForoHub;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


interface TopicoRepository extends JpaRepository<Model, Long> {

    List<Model> findAll();

    boolean existsByTitulo(String titulo);
}