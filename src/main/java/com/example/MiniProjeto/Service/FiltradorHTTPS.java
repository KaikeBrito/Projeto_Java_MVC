package com.example.MiniProjeto.Service;

import com.example.MiniProjeto.Controller.ListaEstudantes;
import com.example.MiniProjeto.Model.Estudante;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;

public class FiltradorHTTPS  {
    public static void filtrarEstudantesServicoSocial() {
        try {
            String jsonUrl = "https://rmi6vdpsq8.execute-api.us-east-2.amazonaws.com/msAluno";
            // Fazendo uma solicitação HTTP GET
            HttpURLConnection connection = (HttpURLConnection) new URL(jsonUrl).openConnection();
            connection.setRequestMethod("GET");

            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                // Analisando o JSON usando a biblioteca Jackson
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode rootNode = objectMapper.readTree(connection.getInputStream());

                // Filtrando e exibindo apenas os estudantes que cursam serviço social
                Iterator<JsonNode> estudanteNodes = rootNode.elements();
                while (estudanteNodes.hasNext()) {

                    JsonNode estudanteNode = estudanteNodes.next();

                    if ("Serviço Social".equals(estudanteNode.get("curso").asText())) {
                        Estudante estudante = new Estudante();
                        estudante.setID(estudanteNode.get("id").asInt());
                        estudante.setNome(estudanteNode.get("nome").asText());
                        estudante.setCurso(estudanteNode.get("curso").asText());
                        ListaEstudantes.adicionarEstudante(estudante);

                        // Faça o que quiser com os dados do estudante
                        System.out.println("ID: " + estudante.getID());
                        System.out.println("Nome: " + estudante.getNome());
                        System.out.println("Curso: " + estudante.getCurso());
                        System.out.println();
                    }

                }

            } else {
                System.out.println("Falha na solicitação HTTP: " + connection.getResponseCode());
            }
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
