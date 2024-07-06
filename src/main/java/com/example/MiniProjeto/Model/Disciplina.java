package com.example.MiniProjeto.Model;

import java.util.List;

public class Disciplina {
    private int id;
    private String nome;

    public Disciplina(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static List<Disciplina> getCursosExemplo() {
        // Método fictício para retornar cursos de exemplo
        return List.of(
                new Disciplina(1, "Teoria Serviço Social"),
                new Disciplina(2, "Saúde"),
                new Disciplina(3, "Pesquisa"),
                new Disciplina(4, "TCC"),
                new Disciplina(5, "História"),
                new Disciplina(6, "Saúde Coletiva"),
                new Disciplina(7, "Teologia")
        );
    }
}
