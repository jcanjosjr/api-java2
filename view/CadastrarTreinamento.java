package view;


// Importando bibliotecas.
import java.awt.*;
import javax.swing.*;
import java.sql.Date;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Import de models
import model.Treinamento;

public class CadastrarTreinamento extends JFrame {

    // Instânciando campos de texto.
    JLabel labelData = new JLabel("Data [yyyy-MM-DD]: ");
    JLabel labelDetalhes = new JLabel("Detalhes: ");
    JLabel labelGolfinho = new JLabel("ID do Golfinho: ");

    // Instânciando botões.
    JButton button1 = new JButton("Cadastrar");
    JButton button2 = new JButton("Cancelar");

    // Instânciando campos de input.
    JTextField textData = new JTextField(25);
    JTextField textDetalhes = new JTextField(25);
    JTextField textGolfinho = new JTextField(25);

    public CadastrarTreinamento() {

        // Padronizando a janela.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,400);
        this.setVisible(true);

        // Gerando o Container e layout da Janela.
        Container pane = this.getContentPane();
        pane.setLayout(new GridLayout(4,2));

        // Adicionando o campo Data.
        pane.add(labelData);
        pane.add(textData);

        // Adicionando o campo Detalhes.
        pane.add(labelDetalhes);
        pane.add(textDetalhes);

        // Adicionando o campo ID Golfinho.
        pane.add(labelGolfinho);
        pane.add(textGolfinho);

        // Adicionando botões
        pane.add(button1);
        pane.add(button2);
    
        // Adicionando evento dos botões:
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

    // Gerando ação ao botão de Confirmar.
    private void button1ActionPerformed(ActionEvent e) {
        try {    
            // Convertendo a String da Data para o tipo Date.
            String dataTexto = textData.getText();
            Date data = Date.valueOf(dataTexto);
    
            // Convertando detalhes em forma de String.
            String detalhes = textDetalhes.getText();
    
            // Convertando o ID de Golfinho para Int.
            int numGolfinho = Integer.parseInt(textGolfinho.getText());
        
            // Instânciando Treinamento.
            Treinamento treinamento = Treinamento.inserirTreinamento(numGolfinho, data, detalhes);
    
            // Gerando caixa de mensagem após ação efetuada.
            JOptionPane.showMessageDialog(
                this,
                "Treinamento cadastrado. \n" + treinamento,
                "Confirmação de Cadastro",
                JOptionPane.INFORMATION_MESSAGE    
            );

        } catch (Exception err) {
            System.err.println("Tivemos um problema no cadastro.");
            System.err.println(err.getMessage());
        }

    }

    // Gerando ação ao botão de Cancelar.
    private void button2ActionPerformed(ActionEvent e) {
        // Fechando a janela ao cancelar.
        this.dispose();
    }

}
