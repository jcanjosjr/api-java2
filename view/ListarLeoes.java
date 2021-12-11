package view;

// Importando bibliotecas.
import java.awt.*;
import javax.swing.*;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Importando models.
import model.Leao;

public class ListarLeoes extends JFrame {

    // Instânciando o TextArea
    JTextArea listaLeao = new JTextArea(15, 30);
    JScrollPane scrollPane = new JScrollPane(listaLeao);

    // Instânciando botão para sair da tela.
    JButton button1 = new JButton("Sair");

    public ListarLeoes() {

        // Padronizando a janela.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,400);
        this.setVisible(true);

        // Gerando o Container e layout da Janela.
        Container pane = this.getContentPane();
        pane.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Instânciando Leão para String de maneira estática.
        String leao = "";
        try {
                leao = Leao.getAll();
        } catch (Exception e) {
            leao = "Erro ao buscar Leões: " + e.getMessage();
        }

        // Adicionando os Leões à Janela.
        listaLeao.setLineWrap(true);
        listaLeao.setText(leao);

        // Adicionando o scroll na Janela.
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Adicionando componentes ao Container.
        pane.add(scrollPane);
        pane.add(button1);

        // Adicionando evento do botão:
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                button1ActionPerformed(e);
            }
        });

    }

    private void button1ActionPerformed(ActionEvent e) {
        // Fechando a janela ao sair.
        this.dispose();
    }
}
