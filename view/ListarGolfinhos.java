package view;

// Importando bibliotecas.
import java.awt.*;
import javax.swing.*;
import java.awt.Container;

// Importando models.
import model.Golfinho;

public class ListarGolfinhos  extends JFrame {

    // Instânciando o TextArea
    JTextField listaGolfinho = new JTextField(300);

    public ListarGolfinhos() {
        
        // Padronizando a janela.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,400);
        this.setVisible(true);

        // Gerando layout da janela.
        Container pane = this.getContentPane();
        pane.setLayout(new GridLayout(1, 1));

        pane.add(listaGolfinho);

    }

    public static void main(String[] args) {
        
        ListarGolfinhos tela = new ListarGolfinhos();
    }
}
