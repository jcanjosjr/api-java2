package view;

// Importando bibliotecas.
import java.awt.*;
import javax.swing.*;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Importando models.
import model.Golfinho;


public class ListarGolfinhos extends JFrame {

    // Instânciando o TextArea
    JTextArea listaGolfinho = new JTextArea(15, 30);
    JScrollPane scrollPane = new JScrollPane(listaGolfinho);

    // Instânciando botão para sair da tela.
    JButton button1 = new JButton("Sair");

    public ListarGolfinhos() {
        
        // Padronizando a janela.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,400);
        this.setVisible(true);

        // Gerando o Container e layout da Janela.
        Container pane = this.getContentPane();
        pane.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Instânciando Golfinho para String de maneira estática.
        String golfinho = "";
        try {
             golfinho = Golfinho.getAll();
        } catch (Exception e) {
            golfinho = "Erro ao buscar golfinhos: " + e.getMessage();
        }

        // Adicionando os Golfinhos à Janela.
        listaGolfinho.setLineWrap(true);
        listaGolfinho.setText(golfinho);

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
