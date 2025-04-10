package com.livro.joao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.livro.joao.repository.LivroRepository;
import com.livro.joao.dto.LivroDTO;
import com.livro.joao.entities.Livro;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
@Transactional
public class LivroService {
    
    @Autowired
    private LivroRepository livroRepository;
    
    private List<LivroDTO> cache = new ArrayList<>();

    public List<LivroDTO> findAll() {
        List<Livro> livros = livroRepository.findAll();
        return livros.stream().map(LivroDTO::new).collect(Collectors.toList());
    }

    public LivroDTO getLivroInfo(int bookId) {
        // Procura no cache
        for (LivroDTO livro : cache) {
            if (livro.getId() == bookId) {
                System.out.println("Cache hit - ID: " + bookId);
                return livro;
            }
        }
        
        // Se não encontrou no cache, busca no banco
        System.out.println("Cache miss - ID: " + bookId);
        Livro livro = new Livro((long) bookId, "Livro " + bookId);
        LivroDTO livroDTO = new LivroDTO(livro);
        cache.add(livroDTO);
        return livroDTO;
    }

    public void addLivro(LivroDTO livroDTO) {
        Livro livro = new Livro();
        livro.setNome(livroDTO.getNome());
        livroRepository.save(livro);
    }

    public void updateLivroInfo(LivroDTO livroDTO) {
        // Atualiza no banco de dados
        Livro livro = livroRepository.findById(livroDTO.getId())
            .orElseThrow(() -> new RuntimeException("Livro não encontrado"));
        livro.setNome(livroDTO.getNome());
        livroRepository.save(livro);

        // Atualiza no cache
        for (int i = 0; i < cache.size(); i++) {
            if (cache.get(i).getId() == livroDTO.getId()) {
                cache.set(i, livroDTO);
                System.out.println("Cache atualizado - ID: " + livroDTO.getId());
                break;
            }
        }
    }

    // Método para mostrar o conteúdo do cache
    public void mostrarCache() {
        System.out.println("\n=== CONTEÚDO DO CACHE ===");
        if (cache.isEmpty()) {
            System.out.println("Cache vazio!");
        } else {
            for (LivroDTO livro : cache) {
                System.out.println("ID: " + livro.getId() + " | Nome: " + livro.getNome());
            }
        }
        System.out.println("========================\n");
    }
}