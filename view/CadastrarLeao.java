package view;

// Importando bibliotecas.
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Importando models.
import model.Leao;


public class CadastrarLeao extends JFrame {
    
    // Instânciando campos de texto.
    JLabel labelNome = new JLabel("Nome: ");
    JLabel labelAlimentacao = new JLabel("Nome: ");
    JLabel labelVisitantes = new JLabel("Alimentação: ");
    JLabel labelJaula = new JLabel("ID referente à Jaula: ");

    // Instânciando botões.
    JButton button1 = new JButton("Cadastrar");
    JButton button2 = new JButton("Cancelar");

    // Instânciando campos de input.
    JTextField textNome = new JTextField(25);
    JTextField textAlimentacao = new JTextField(25);
    JTextField textVisitantes = new JTextField(25);
    JTextField textJaula = new JTextField(25);

    public CadastrarLeao() {

        // Padronizando a janela.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,400);
        this.setVisible(true);

        Container pane = this.getContentPane();
        pane.setLayout(new GridLayout(5,2));

        // Adicionando o campo Nome.
        pane.add(labelNome);
        pane.add(textNome);

        // Adicionando o campo Alimentação.
        pane.add(labelAlimentacao);
        pane.add(textAlimentacao);

        // Adicionando o campo Visitantes.
        pane.add(labelVisitantes);
        pane.add(textVisitantes);

        // Adicionando o campo Jaula.
        pane.add(labelJaula);
        pane.add(textJaula);

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

    // Gerando ação ao botão de Confirmar.
    private void button1ActionPerformed(ActionEvent e) {
        try {
            // Convertendo Nome Leão em forma de String
            String nomeLeao = textNome.getText();

            // Convertendo Alimentações para Int.
            int numAlimentado = Integer.parseInt(textAlimentacao.getText());

            // Convertendo Visitantes para Int.
            int numVisitantes = Integer.parseInt(textVisitantes.getText());

            // Convertendo IDJaula para Int.
            int numJaula = Integer.parseInt(textJaula.getText());

            // Instânciando Leão com INSERT no DB.
            Leao leao = Leao.insertLeao(nomeLeao, numAlimentado, numVisitantes, numJaula);

            // Gerando caixa de mensagem após ação efetuada.
            JOptionPane.showMessageDialog(
                this,
                "Treinamento cadastrado. \n" + leao,
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
        JOptionPane.showMessageDialog(
            this,
            "Tarefa cancelada.",
            "Confirmação de Cadastro",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
}
