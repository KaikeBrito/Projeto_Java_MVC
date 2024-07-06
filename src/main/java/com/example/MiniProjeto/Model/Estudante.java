package com.example.MiniProjeto.Model;

import java.util.ArrayList;
import java.util.List;



public class Estudante {

    private int ID;
    private String nome;

    private String curso;

    private List<Disciplina> matriculas = new ArrayList<>();

    private List<Livro> livro =  new ArrayList<>();


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public List<Disciplina> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<Disciplina> matriculas) {
        this.matriculas = matriculas;
    }

    public List<Livro> getLivro() {
        return livro;
    }

    public void setLivro(List<Livro> livro) {
        this.livro = livro;
    }

    public void alugarLivro(Livro livroSelecionado) {
        livro.add(livroSelecionado);
    }
    public void adicionarMatricula(Disciplina cursoSelecionado) {
        matriculas.add(cursoSelecionado);
    }
    public void cancelarLivro(Livro livroSelecionado) {
        livro.remove(livroSelecionado);
    }
    public void cancelarMatricula(Disciplina cursoSelecionado) {
        matriculas.remove(cursoSelecionado);
    }


}


