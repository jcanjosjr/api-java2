// Importando bibliotecas.
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Import View.
import view.ListarLeoes;
import view.AlterarLeao;
import view.CadastrarLeao;
import view.ListarGolfinhos;
import view.AlterarGolfinho;
import view.CadastrarGolfinho;
import view.CadastrarAlimentacao;
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
                button3ActionPerformed(e);
            }
        });

        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                button4ActionPerformed(e);
            }
        });

        button5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                button5ActionPerformed(e);
            }
        });

        button6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                button6ActionPerformed(e);
            }
        });

        button7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                button7ActionPerformed(e);
            }
        });

        button8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                button8ActionPerformed(e);
            }
        });

    }

    // Chamando a view para o Botão 1.
    private void button1ActionPerformed(ActionEvent e) {
        try {
            // Instanciando a View de Alterar Golfinho.
            AlterarGolfinho alterarGolfinho = new AlterarGolfinho();
        } catch (Exception err) {
            System.err.println("Tivemos um problema no cadastro.");
            System.err.println(err.getMessage());
        }
    
    }

    // Chamando a view para o Botão 2.
    private void button2ActionPerformed(ActionEvent e) {
        try {
            // Instanciando a View de Cadastrar Golfinho.
            CadastrarGolfinho cadastrarGolfinho = new CadastrarGolfinho();
        } catch (Exception err) {
            System.err.println("Tivemos um problema no cadastro.");
            System.err.println(err.getMessage());
        }
    
    }

    // Chamando a view para o Botão 3.
    private void button3ActionPerformed(ActionEvent e) {
        try {
            // Instanciando a View de Cadastrar Treinamento.
            CadastrarTreinamento cadastrarTreinamento = new CadastrarTreinamento();
        } catch (Exception err) {
            System.err.println("Tivemos um problema no cadastro.");
            System.err.println(err.getMessage());
        }
    
    }

    // Chamando a view para o Botão 4.
    private void button4ActionPerformed(ActionEvent e) {
        try {
            // Instanciando a View de Alterar Leão.
            AlterarLeao alterarLeao = new AlterarLeao();
        } catch (Exception err) {
            System.err.println("Tivemos um problema no cadastro.");
            System.err.println(err.getMessage());
        }

    }

    // Chamando a view para o Botão 5.
    private void button5ActionPerformed(ActionEvent e) {
        try {
            // Instanciando a View de Cadastrar Leão.
            CadastrarLeao cadastrarLeao = new CadastrarLeao();
        } catch (Exception err) {
            System.err.println("Tivemos um problema no cadastro.");
            System.err.println(err.getMessage());
        }
    
    }

    // Chamando a view para o Botão 6.
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
        try {
            // Instanciando a View de Cadastrar Alimentação.
            ListarGolfinhos listarGolfinho = new ListarGolfinhos();
        } catch (Exception err) {
            System.err.println("Tivemos um problema no cadastro.");
            System.err.println(err.getMessage());
        }
    }

    private void button8ActionPerformed(ActionEvent e) {
        try {
            // Instanciando a View de Cadastrar Alimentação.
            ListarLeoes listarLeao = new ListarLeoes();
        } catch (Exception err) {
            System.err.println("Tivemos um problema no cadastro.");
            System.err.println(err.getMessage());
        }
    }

    public static void main(String[] args) {
        
        Zoo zoo = new Zoo();
    }
}
