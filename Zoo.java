// Importando bibliotecas.
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Import View.
import view.CadastrarLeao;
import view.AlterarGolfinho;
import view.AlterarLeao;
import view.CadastrarAlimentacao;
import view.CadastrarGolfinho;
import view.CadastrarTreinamento;


public class Zoo extends JFrame {

    // Instânciando botões.
    JButton button1 = new JButton("Alterar Golfinho");
    JButton button2 = new JButton("Cadastrar Golfinho");
    JButton button3 = new JButton("Cadastrar Treinamento de Golfinho.");
    JButton button4 = new JButton("Alterar Leão.");
    JButton button5 = new JButton("Cadastrar Leão");
    JButton button6 = new JButton("Cadastrar Alimentação de Leão.");
    JButton button7 = new JButton("Listar Golfinhos");
    JButton button8 = new JButton("Listar Leões");

    public Zoo() {

        // Padronizando a janela.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,400);
        this.setVisible(true);

        Container pane = this.getContentPane();
        pane.setLayout(new GridLayout(8,1));

        // Adicionando botões
        pane.add(button1);
        pane.add(button2);
        pane.add(button3);
        pane.add(button4);
        pane.add(button5);
        pane.add(button6);
        pane.add(button7);
        pane.add(button8);
    
        // Ações dos botões:
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

        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                button2ActionPerformed(e);
            }
        });

        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                button2ActionPerformed(e);
            }
        });

        button5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                button2ActionPerformed(e);
            }
        });

        button6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                button2ActionPerformed(e);
            }
        });

        button7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                button2ActionPerformed(e);
            }
        });

        button8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                button2ActionPerformed(e);
            }
        });

    }

    private void button1ActionPerformed(ActionEvent e) {
        try {
            // Instanciando a View de Alterar Golfinho.
            AlterarGolfinho alterarGolfinho = new AlterarGolfinho();
        } catch (Exception err) {
            System.err.println("Tivemos um problema no cadastro.");
            System.err.println(err.getMessage());
        }
    
    }
    private void button2ActionPerformed(ActionEvent e) {
        try {
            // Instanciando a View de Cadastrar Golfinho.
            CadastrarGolfinho cadastrarGolfinho = new CadastrarGolfinho();
        } catch (Exception err) {
            System.err.println("Tivemos um problema no cadastro.");
            System.err.println(err.getMessage());
        }
    
    }

    private void button3ActionPerformed(ActionEvent e) {
        try {
            // Instanciando a View de Cadastrar Treinamento.
            CadastrarTreinamento cadastrarTreinamento = new CadastrarTreinamento();
        } catch (Exception err) {
            System.err.println("Tivemos um problema no cadastro.");
            System.err.println(err.getMessage());
        }
    
    }

    private void button4ActionPerformed(ActionEvent e) {
        try {
            // Instanciando a View de Alterar Leão.
            AlterarLeao alterarLeao = new AlterarLeao();
        } catch (Exception err) {
            System.err.println("Tivemos um problema no cadastro.");
            System.err.println(err.getMessage());
        }
    }

    private void button5ActionPerformed(ActionEvent e) {
        try {
            // Instanciando a View de Cadastrar Leão.
            CadastrarLeao cadastrarLeao = new CadastrarLeao();
        } catch (Exception err) {
            System.err.println("Tivemos um problema no cadastro.");
            System.err.println(err.getMessage());
        }
    
    }

    private void button6ActionPerformed(ActionEvent e) {
        try {
            // Instanciando a View de Cadastrar Alimentação.
            CadastrarAlimentacao cadastrarAlimentacao = new CadastrarAlimentacao();
        } catch (Exception err) {
            System.err.println("Tivemos um problema no cadastro.");
            System.err.println(err.getMessage());
        }
    }

    private void button7ActionPerformed(ActionEvent e) {
        // Implementar
    }

    private void button8ActionPerformed(ActionEvent e) {
        // Implementar
    }

    public static void main(String[] args) {
        
        Zoo zoo = new Zoo();
    }
}
