package com.example.MiniProjeto.Controller;

import com.example.MiniProjeto.Model.Disciplina;
import com.example.MiniProjeto.Model.Estudante;
import com.example.MiniProjeto.Model.Livro;
import com.example.MiniProjeto.View.MatriculaFrame;

import javax.swing.*;

public class MatriculaEAluguelLivrosController {
    private static MatriculaFrame matriculaFrame;

    public MatriculaEAluguelLivrosController(MatriculaFrame matriculaFrame) {
        MatriculaEAluguelLivrosController.matriculaFrame = matriculaFrame;
    }

    public static void adicionarMatricula(JComboBox<Estudante> estudanteComboBox, JComboBox<Disciplina> cursoComboBox, JComboBox<Livro> livroComboBox) {
        Estudante estudanteSelecionado = (Estudante) estudanteComboBox.getSelectedItem();
        Disciplina cursoSelecionado = (Disciplina) cursoComboBox.getSelectedItem();
        Livro livroSelecionado = (Livro) livroComboBox.getSelectedItem();

        if (estudanteSelecionado != null && cursoSelecionado != null && livroSelecionado != null) {
            // Adicionar a lógica para salvar a matrícula e o aluguel do livro
            estudanteSelecionado.adicionarMatricula(cursoSelecionado);
            System.out.println("Matrícula Adicionada:");
            System.out.println("ID: " + estudanteSelecionado.getID());
            System.out.println("Aluno: " + estudanteSelecionado.getNome());
            System.out.println("Curso: " + estudanteSelecionado.getCurso());
            System.out.println("Curso Matriculado: " + cursoSelecionado.getNome());
            System.out.println();


        } else {
            JOptionPane.showMessageDialog(matriculaFrame, "Selecione um Aluno, um Curso e um Livro.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void alugarLivro(JComboBox<Estudante> estudanteComboBox, JComboBox<Disciplina> cursoComboBox, JComboBox<Livro> livroComboBox) {
        Estudante estudanteSelecionado = (Estudante) estudanteComboBox.getSelectedItem();
        Livro livroSelecionado = (Livro) livroComboBox.getSelectedItem();

        if (estudanteSelecionado != null && livroSelecionado != null) {
            // Adicionar a lógica para salvar a matrícula e o aluguel do livro
            estudanteSelecionado.alugarLivro(livroSelecionado);
            System.out.println("Matrícula Adicionada:");
            System.out.println("ID: " + estudanteSelecionado.getID());
            System.out.println("Aluno: " + estudanteSelecionado.getNome());
            System.out.println("Livro Alugado: " + livroSelecionado.getNome());
            System.out.println();


        } else {
            JOptionPane.showMessageDialog(matriculaFrame, "Selecione um Aluno, um Curso e um Livro.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void cancelarLivro(JComboBox<Estudante> estudanteComboBox, JComboBox<Livro> livroComboBox) {
        Estudante estudanteSelecionado = (Estudante) estudanteComboBox.getSelectedItem();
        Livro livroSelecionado = (Livro) livroComboBox.getSelectedItem();

        if (estudanteSelecionado != null && livroSelecionado != null) {
            estudanteSelecionado.cancelarLivro(livroSelecionado);
            System.out.println("Livro Cancelado:");
            System.out.println("ID do Estudante: " + estudanteSelecionado.getID());
            System.out.println("Aluno: " + estudanteSelecionado.getNome());
            System.out.println("Livro Cancelado: " + livroSelecionado.getNome());
            System.out.println();
        } else {
            JOptionPane.showMessageDialog(matriculaFrame, "Selecione um Aluno e um Livro.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void cancelarMatricula(JComboBox<Estudante> estudanteComboBox, JComboBox<Disciplina> cursoComboBox) {
        Estudante estudanteSelecionado = (Estudante) estudanteComboBox.getSelectedItem();
        Disciplina cursoSelecionado = (Disciplina) cursoComboBox.getSelectedItem();

        if (estudanteSelecionado != null && cursoSelecionado != null) {
            estudanteSelecionado.cancelarMatricula(cursoSelecionado);
            System.out.println("Matrícula Cancelada:");
            System.out.println("ID: " + estudanteSelecionado.getID());
            System.out.println("Aluno: " + estudanteSelecionado.getNome());
            System.out.println("Curso: " + estudanteSelecionado.getCurso());
            System.out.println("Curso Cancelado: " + cursoSelecionado.getNome());
            System.out.println();
        } else {
            JOptionPane.showMessageDialog(matriculaFrame, "Selecione um Aluno e um Curso.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void procurarEstudantePorID(JTextField idTextField, JComboBox<Estudante> estudanteComboBox ) {
        int idProcurado;
        try {
            idProcurado = Integer.parseInt(idTextField.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(matriculaFrame, "Insira um ID válido.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Procurar o estudante na lista pelo ID
        for (Estudante estudante : ListaEstudantes.estudantes) {
            if (estudante.getID() == idProcurado) {
                // Imprimir os detalhes do estudante no console
                System.out.println("Estudante Encontrado:");
                System.out.println("ID: " + estudante.getID());
                System.out.println("Nome: " + estudante.getNome());
                System.out.println("Curso: " + estudante.getCurso());
                System.out.println();

                // Atualizar a JComboBox com as informações do estudante
                estudanteComboBox.setSelectedItem(estudante);
                return;
            }
        }
        // Se o estudante não for encontrado, exibir mensagem de erro
        JOptionPane.showMessageDialog(matriculaFrame, "Estudante não encontrado com o ID fornecido.", "Erro", JOptionPane.ERROR_MESSAGE);
    }
    // Método para listar alunos com matrículas e livros atualizados
    public static void listarAlunosComMatriculasELivrosAtualizados(JComboBox<Estudante> estudanteComboBox) {
        // Obtém o aluno selecionado na JComboBox
        Estudante estudanteSelecionado = (Estudante) estudanteComboBox.getSelectedItem();

        if (estudanteSelecionado != null) {
            // Imprime informações gerais do aluno
            System.out.println("Estudante: " + estudanteSelecionado.getNome());
            System.out.println("ID: " + estudanteSelecionado.getID());
            System.out.println("Curso: " + estudanteSelecionado.getCurso());

            // Imprime matrículas do aluno
            System.out.println("Matrículas:");
            for (Disciplina matricula : estudanteSelecionado.getMatriculas()) {
                System.out.println("- " + matricula.getNome());
            }

            // Imprime livros alugados pelo aluno
            System.out.println("Livros Alugados:");
            for (Livro livro : estudanteSelecionado.getLivro()) {
                System.out.println("- " + livro.getNome());
            }

            System.out.println();
        } else {
            System.out.println("Nenhum aluno selecionado.");
        }
    }

}