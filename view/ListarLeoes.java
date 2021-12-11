package view;

// Importando bibliotecas.
import java.awt.*;
import javax.swing.*;
import java.awt.Container;

// Importando models.
import model.Leao;

public class ListarLeoes extends JFrame {

        // Instânciando o TextArea
        JTextArea listaLeao = new JTextArea(15, 30);
        JScrollPane scrollPane = new JScrollPane(listaLeao);

    public ListarLeoes() {

        // Padronizando a janela.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,400);
        this.setVisible(true);

        // Gerando layout da Janela.
        Container pane = this.getContentPane();
        pane.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Instânciando Golfinho para String de maneira estática.
        String leao = "";
        try {
             leao = Leao.getAll();
        } catch (Exception e) {
            leao = "Erro ao buscar golfinhos: " + e.getMessage();
        }

        // Adicionando os Golfinhos.
        listaLeao.setLineWrap(true);
        listaLeao.setText(leao);

        // Adicionando o scroll na Janela.
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        pane.add(scrollPane);

    }

}
