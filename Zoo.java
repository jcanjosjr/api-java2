import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class Zoo extends JFrame {

    // Instânciando botões.
    JButton button1 = new JButton("Alterar Golfinho");
    JButton button2 = new JButton("Cadastrar Golfinho");
    JButton button4 = new JButton("Cadastrar Treinamento de Golfinho.");
    JButton button5 = new JButton("Alterar Leão.");
    JButton button6 = new JButton("Cadastrar Leão");
    JButton button3 = new JButton("Cadastrar Alimentação de Leão.");
    JButton button7 = new JButton("Listar Golfinhos");
    JButton button8 = new JButton("Listar Leões");
    JButton button9 = new JButton("Cadastrar");
    JButton button10 = new JButton("Cancelar");

    public Zoo() {

        // Padronizando a janela.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,450);
        this.setVisible(true);

        Container pane = this.getContentPane();
        pane.setLayout(new GridLayout(9,1));

        // Adicionando botões
        pane.add(button1);
        pane.add(button2);
        pane.add(button3);
        pane.add(button4);
        pane.add(button5);
        pane.add(button6);
        pane.add(button7);
        pane.add(button8);
    
    }

    private void button1ActionPerformed(ActionEvent e) {
        // Implementar
    }

    private void button2ActionPerformed(ActionEvent e) {
        // Implementar
    }

    private void button3ActionPerformed(ActionEvent e) {
        // Implementar
    }

    private void button4ActionPerformed(ActionEvent e) {
        // Implementar
    }

    private void button5ActionPerformed(ActionEvent e) {
        // Implementar
    }

    private void button6ActionPerformed(ActionEvent e) {
        // Implementar
    }

    private void button7ActionPerformed(ActionEvent e) {
        // Implementar
    }

    private void button8ActionPerformed(ActionEvent e) {
        // Implementar
    }

}
