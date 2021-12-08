package view;

// Importando bibliotecas.
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastrarTreinamento extends JFrame {

        // Instânciando campos de texto.
    JLabel labelId = new JLabel("ID: ");
    JLabel labelName = new JLabel("Data: ");
    JLabel labelDetalhes = new JLabel("Detalhes: ");

    // Instânciando botões.
    JButton button1 = new JButton("Cadastrar");
    JButton button2 = new JButton("Cancelar");

    // Instânciando campos de input.
    JTextField textId = new JTextField(25);
    JTextField textName = new JTextField(25);
    JTextField textDetalhes = new JTextField(25);

    public CadastrarTreinamento() {

        // Padronizando a janela.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,400);
        this.setVisible(true);

        Container pane = this.getContentPane();
        pane.setLayout(new GridLayout(4,2));

        // Adicionando o campo ID.
        pane.add(labelId);
        pane.add(textId);

        // Adicionando o campo Name.
        pane.add(labelName);
        pane.add(textName);

        // Adicionando o campo Detalhes.
        pane.add(labelDetalhes);
        pane.add(textDetalhes);

        // Adicionando botões
        pane.add(button1);
        pane.add(button2);
    
        // Mensagens dos botões:
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                button1ActionPerformed(e);
            }
        });

        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                button2ActionPerformed(e);
            }
        });

    }

    private void button1ActionPerformed(ActionEvent e) {
        // Implementar
    }

    private void button2ActionPerformed(ActionEvent e) {
        // implementar.
    }

}
