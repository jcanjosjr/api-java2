package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Treinamento {
    
    // Atributos da classe Treinamento.
    private int id;
    private Date data;
    private String detalhes;
    // Treinamento possui N -> Golfinhos.
    private List<Golfinho> golfinhos = new ArrayList<>();

    // Método construtor de Treinamento.
    public Treinamento(int id, Date data, String detalhes) {
        this.id = id;
        this.data = data;
        this.detalhes = detalhes;
    }

    // Getters
    public int getId() {
        return id;
    }

    public Date getData() {
        return data;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public List<Golfinho> getGolfinhos() {
        return this.golfinhos;
    }  

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setData(Date data) {
        this.data = data;
    }


    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }


    public void setGolfinhos(Golfinho golfinho) {
        this.golfinhos.add(golfinho);
    }


    // Método para comparar objeto com Treinamento:
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Treinamento)) {
            return false;
        }

        Treinamento treinamento = (Treinamento) o;
        return this.getId() == treinamento.getId();
    }

    // Trazendo Treinamento em forma de texto.
    @Override
    public String toString() {
        String printTreinamento = 
            "ID: " + id + "\n" +
            "Treinamento! \n" +
            "Data: " + this.getData() + "\n" + 
            "Detalhes: " + this.getDetalhes() + "\n";
        
        if(!(this.golfinhos.isEmpty())) {
            for(Golfinho golfinho : this.golfinhos) {
                printTreinamento += "Golfinhos: " + golfinho.getNome() + "\n";
            }
        } else {
            printTreinamento += "Golfinho ainda não receberam treinamentos.";
        }
        
        return printTreinamento;
    }

    public void inserirTreinamento() {
        try {
            // Instânciando a classe DAO, start na conexão com DB.
            DAO dao = new DAO();
            Connection conn = dao.startConnection();

            // Criando o java statement.
            Statement st = conn.createStatement();
    
            // Criando o INSERT para inserir dados em Treinamento.
            PreparedStatement insert = conn.prepareStatement(
                "INSERT INTO zoo.treinamento VALUES (id, golfinho_id, data, detalhes) VALUES (?, ?, ?, ?);",
                PreparedStatement.RETURN_GENERATED_KEYS
            );

            if(insert.executeUpdate() > 0) {
                ResultSet resultado = st.getGeneratedKeys();

                if(resultado.next()) {
                    Treinamento treinamento = new Treinamento(
                        resultado.getInt(1),
                        resultado.getDate(2),
                        resultado.getString(3)
                    );

                    System.out.println(treinamento);
                }
            }

            // Fechando a conexão com DB.
            dao.endConnection();

        } catch (Exception e) {
            System.err.println("Tivemos um problema.");
            System.err.println(e.getMessage());
        }
    }
    
}
