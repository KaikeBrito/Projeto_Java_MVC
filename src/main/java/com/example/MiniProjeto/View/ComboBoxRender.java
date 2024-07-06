package com.example.MiniProjeto.View;

import com.example.MiniProjeto.Model.Disciplina;
import com.example.MiniProjeto.Model.Estudante;
import com.example.MiniProjeto.Model.Livro;

import javax.swing.*;
import java.awt.*;

public class ComboBoxRender {

    // Classe para definir como os objetos Estudante são representados na JComboBox
    static class EstudanteComboBoxRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            if (value instanceof Estudante) {
                value = ((Estudante) value).getID();
            }
            return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        }
    }
    public static class DisciplinaComboBoxRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            if (value instanceof Disciplina) {
                value = ((Disciplina) value).getNome();
            }
            return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        }
    }
    static class LivroComboBoxRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            if (value instanceof Livro) {
                value = ((Livro) value).getNome();
            }
            return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        }
    }
}
