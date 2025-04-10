package com.livro.joao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.livro.joao.entities.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

}
