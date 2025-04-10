package com.livro.joao.dto;

import com.livro.joao.entities.Livro;

public class LivroDTO {

    private Long id;
    private String nome;

    public LivroDTO() {
    }

    public LivroDTO(Livro livro) {
        id = livro.getId();
        nome = livro.getNome();
    }

    public LivroDTO(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
    
    
    
}
