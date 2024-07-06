package com.example.MiniProjeto;

import com.example.MiniProjeto.Controller.ListaEstudantes;
import com.example.MiniProjeto.Model.Disciplina;
import com.example.MiniProjeto.Model.Estudante;
import com.example.MiniProjeto.Model.Livro;
import com.example.MiniProjeto.Service.FiltradorHTTPS;
import com.example.MiniProjeto.View.MatriculaFrame;

import javax.swing.*;
import java.util.List;


import static com.example.MiniProjeto.Model.Disciplina.getCursosExemplo;
import static com.example.MiniProjeto.Model.LivrosExemplo.getLivrosExemplo;

public class Main {
    public static void main(String[] args) {

        FiltradorHTTPS.filtrarEstudantesServicoSocial();

        List<Estudante> estudantes = ListaEstudantes.estudantes;
        List<Disciplina> cursos = getCursosExemplo(); // Suponha que você tenha um método para obter cursos de exemplo
        List<Livro> livros = getLivrosExemplo(); // Suponha que você tenha um método para obter livros de exemplo

        // Cria e exibe o JFrame para matrícula
        SwingUtilities.invokeLater(() -> {
            new MatriculaFrame(estudantes, cursos, livros).setVisible(true);
        });
    }
}
