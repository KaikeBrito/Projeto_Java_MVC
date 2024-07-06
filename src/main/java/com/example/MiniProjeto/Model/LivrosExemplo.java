package com.example.MiniProjeto.Model;

import java.util.List;

public class LivrosExemplo {
    public static List<Livro> getLivrosExemplo() {
        // Método fictício para retornar livros de exemplo
        return List.of(
                new Livro(1,"O Pequeno Principe"),
                new Livro(2,"O Pai dos Dividendos"),
                new Livro(3,"Robison Crusoé"),
                new Livro(4,"O Conde Monte Cristo"),
                new Livro(5,"Pai Rico, Pai Pobre"),
                new Livro(6,"Harry Potter"),
                new Livro(7,"Jogos Vorazes")
        );
    }
}
