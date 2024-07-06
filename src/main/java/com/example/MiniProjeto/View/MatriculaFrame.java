package com.example.MiniProjeto.View;

import com.example.MiniProjeto.Controller.MatriculaEAluguelLivrosController;
import com.example.MiniProjeto.Model.Disciplina;
import com.example.MiniProjeto.Model.Estudante;
import com.example.MiniProjeto.Model.Livro;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MatriculaFrame extends JFrame {

    private final JComboBox<Estudante> estudanteComboBox;
    private final JComboBox<Disciplina> cursoComboBox;
    private final JComboBox<Livro> livroComboBox;
    private final JTextField idTextField;



    // Botão para procurar estudante por ID

    JButton searchButton = new JButton("Procurar Estudante");

    public MatriculaFrame(List<Estudante> estudantes, List<Disciplina> cursos, List<Livro> livros) {

        setTitle("Matrícula em Curso e Aluguel de Livro");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Layout do JFrame
        setLayout(new FlowLayout());

        // JTextField para inserir ID do estudante
        idTextField = new JTextField(10);
        add(new JLabel("ID do Estudante:"));
        add(idTextField);

        // JComboBox para selecionar aluno
        estudanteComboBox = new JComboBox<>(estudantes.toArray(new Estudante[0]));
        estudanteComboBox.setRenderer(new ComboBoxRender.EstudanteComboBoxRenderer()); // Definir um renderer personalizado
        add(new JLabel("Selecione o Aluno:"));
        add(estudanteComboBox);

        // JComboBox para selecionar curso
        cursoComboBox = new JComboBox<>(cursos.toArray(new Disciplina[0]));
        cursoComboBox.setRenderer(new ComboBoxRender.DisciplinaComboBoxRenderer()); // Definir um renderer personalizado
        add(new JLabel("Selecione o Curso:"));
        add(cursoComboBox);

        // JComboBox para selecionar livro
        livroComboBox = new JComboBox<>(livros.toArray(new Livro[0]));
        livroComboBox.setRenderer(new ComboBoxRender.LivroComboBoxRenderer()); // Definir um renderer personalizado
        add(new JLabel("Selecione o Livro:"));
        add(livroComboBox);


        // Botão para procurar Estudante
        searchButton.addActionListener(e -> MatriculaEAluguelLivrosController.procurarEstudantePorID(idTextField, estudanteComboBox));
        add(searchButton);

        // Botão para adicionar matrícula
        JButton addButton = new JButton("Adicionar Matrícula");
        addButton.addActionListener(e -> MatriculaEAluguelLivrosController.adicionarMatricula(estudanteComboBox, cursoComboBox, livroComboBox));
        add(addButton);


        // Botão para alugar livro
        JButton rentButton = new JButton("Alugar Livro");
        rentButton.addActionListener(e -> MatriculaEAluguelLivrosController.alugarLivro(estudanteComboBox, cursoComboBox, livroComboBox));
        add(rentButton);

        // Botão para cancelar matrícula
        JButton cancelButton = new JButton("Cancelar Matrícula");
        cancelButton.addActionListener(e -> MatriculaEAluguelLivrosController.cancelarMatricula(estudanteComboBox, cursoComboBox));
        add(cancelButton);

        // Botão para cancelar livro
        JButton cancelRentButton = new JButton("Cancelar Livro");
        cancelRentButton.addActionListener(e -> MatriculaEAluguelLivrosController.cancelarLivro(estudanteComboBox, livroComboBox));
        add(cancelRentButton);

        // Botão de Listar Estudantes com matriculas e livros atualizados
        JButton ListaAtualizadaRentButton = new JButton("Listar Estudante Atualizado");
        ListaAtualizadaRentButton.addActionListener(e -> MatriculaEAluguelLivrosController.listarAlunosComMatriculasELivrosAtualizados(estudanteComboBox));
        add(ListaAtualizadaRentButton);
    }
}
