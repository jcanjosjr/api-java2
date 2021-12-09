package view;

// Importando bibliotecas.
import java.awt.*;
import javax.swing.*;
import java.sql.Date;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Import de Model.
import model.Alimentacao;

public class CadastrarAlimentacao extends JFrame {

    // Instânciando campos de texto.
    JLabel labelId = new JLabel("ID Alimentação: ");
    JLabel labelData = new JLabel("Data: ");
    JLabel labelDetalhes = new JLabel("Detalhes: ");
    JLabel labelLeao = new JLabel("ID do Leão: ");

    // Instânciando botões.
    JButton button1 = new JButton("Cadastrar");
    JButton button2 = new JButton("Cancelar");

    // Instânciando campos de input.
    JTextField textId = new JTextField(25);
    JTextField textData = new JTextField(25);
    JTextField textDetalhes = new JTextField(25);
    JTextField textLeao = new JTextField(25);

    public CadastrarAlimentacao() {

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
        pane.add(labelData);
        pane.add(textData);

        // Adicionando o campo Detalhes.
        pane.add(labelDetalhes);
        pane.add(textDetalhes);

        // Adicionando botões
        pane.add(button1);
        pane.add(button2);

        // Adicionando o campo ID Golfinho.
        pane.add(labelLeao);
        pane.add(textLeao);

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

    private void button1ActionPerformed(ActionEvent e) {
        try {
            // Recebendo ID de Treinamento.
            int numId = Integer.parseInt(textId.getText());
    
            // Convertendo a String da Data para o tipo Date.
            String dataTexto = textData.getText();
            Date data = Date.valueOf(dataTexto);
    
            // Recebendo detalhes em forma de String.
            String detalhes = textDetalhes.getText();
    
            // Recebendo o ID de Golfinho.
            int numLeao = Integer.parseInt(textLeao.getText());
    
            // Instânciando Treinamento.
            Alimentacao alimentacao = new Alimentacao(numLeao, data, detalhes);

            // Inserindo dados no DB com o método de Insert.
            alimentacao.insertAlimentacao(numId, numLeao, data, detalhes);
    
            JOptionPane.showMessageDialog(
                this,
                "Alimentação cadastrado. \n" + alimentacao,
                "Confirmação de Cadastro",
                JOptionPane.INFORMATION_MESSAGE    
            );

        } catch (Exception err) {
            System.err.println("Tivemos um problema no cadastro.");
            System.err.println(err.getMessage());
        }

    }

    private void button2ActionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(
            this,
            "Tarefa cancelada.",
            "Confirmação de Cadastro",
            JOptionPane.INFORMATION_MESSAGE
        );
    }

    public static void main(String[] args) {
        
        CadastrarTreinamento tela = new CadastrarTreinamento();

    }
}
