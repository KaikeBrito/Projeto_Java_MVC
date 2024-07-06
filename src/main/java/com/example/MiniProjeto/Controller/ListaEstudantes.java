package com.example.MiniProjeto.Controller;

import com.example.MiniProjeto.Model.Estudante;

import java.util.ArrayList;
import java.util.List;

public class ListaEstudantes extends Estudante {
    public static List<Estudante> estudantes = new ArrayList<>();

    public static void adicionarEstudante(Estudante estudante) {
        estudantes.add(estudante);
    }

}