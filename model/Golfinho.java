package model;

// Importando bibliotecas:
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Golfinho extends Animal implements Pesquisa {
    
    // Atributos da classe Golfinho.
    private int qtdTreinos;
    // Golfinho possui N -> Treinamentos.
    private List<Treinamento> treinamentos = new ArrayList<>();

    // Método construtor de Golfinho.
    public Golfinho(
        int id,
        String nome,
        int qtdTreinos
    ) {
        super(id, nome);
        this.qtdTreinos = qtdTreinos;
    }

    // Getters
    public int getQtdTreinos() {
        return qtdTreinos;
    }

    public List<Treinamento> getTreinamentos() {
        return this.treinamentos;
    }

    // Getter para último Treinamento.
    public Treinamento getUltiTreinamento() {
        return treinamentos.get(treinamentos.size() - 1);
    }

    // Setters
    public void setQtdTreinos(int qtdTreinos) {
        this.qtdTreinos = qtdTreinos;
    }

    public void setTreinamentos(Treinamento treinamento) {
        this.treinamentos.add(treinamento);
    }

    // Método para comparar objeto com Golfinho:
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Golfinho)) {
            return false;
        }

        Golfinho golfinho = (Golfinho) o;
        return this.getId() == golfinho.getId();
    }


    // Trazendo Alimentação em forma de texto.
    @Override
    public String toString() {
        String printGolfinho = 
            "Golfinho! \n" +
            "Treinamentos: " + this.getQtdTreinos() + "\n";

        if(!(this.treinamentos.isEmpty())) {
            for(Treinamento treinamento : this.treinamentos) {
                printGolfinho += "Treinamentos: " + treinamento.getDetalhes() + "\n";
            }
        } else {
            printGolfinho += "Golfinho ainda não foi alimentado.";
        }
        
        return printGolfinho;
            
    }

    // Realizando um INSERT na tabela Golfinho.
    public void insertGolfinho() {
        try {
            // Instânciando a classe DAO, start na conexão com DB.
            DAO dao = new DAO();
            Connection conn = dao.startConnection();

            // Criando o java statement.
            Statement st = conn.createStatement();
    
            // Criando o INSERT para inserir todos os dados da tabela Leão.
            PreparedStatement insert = conn.prepareStatement(
                "INSERT INTO zoo.golfinho VALUES (id, nome, treinamento, jaula_id) VALUES (?, ?, ?, ?);",
                PreparedStatement.RETURN_GENERATED_KEYS
            );

            if(insert.executeUpdate() > 0) {
                ResultSet resultado = st.getGeneratedKeys();

                if(resultado.next()) {
                    resultado.getInt(1);
                }
            }

            // Fechando a conexão com DB.
            dao.endConnection();

        } catch (Exception e) {
            System.err.println("Tivemos um problema.");
            System.err.println(e.getMessage());
        }
    }

    // Buscando todos os dados na tabela Golfinho
    public void getAll() {
        try {
            // Instânciando a classe DAO, start na conexão com DB.
            DAO dao = new DAO();
            Connection conn = dao.startConnection();

            // Criando o java statement.
            Statement st = conn.createStatement();
    
            // Criando o SELECT para trazer todos os dados da tabela Golfinho.
            String select = "SELECT * FROM zoo.golfinho;";

            // Executando a query, e obtendo o resultado.
            ResultSet rs = st.executeQuery(select);

            // Iterando sobre o resultado.
            while (rs.next()) {
                Golfinho golfinho = new Golfinho(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getInt(3)
                );

                System.out.println(golfinho);
            }
               

            // Fechando a conexão com DB.
            dao.endConnection();

        } catch (Exception e) {
            System.err.println("Tivemos um problema.");
            System.err.println(e.getMessage());
        }
    }

    // Buscando Golfinho pelo ID.
    public void getPorId(int id) {
        try {
            // Instânciando a classe DAO, start na conexão com DB.
            DAO dao = new DAO();
            Connection conn = dao.startConnection();
   
            // Preparando o Select com PreparedStatement:
            PreparedStatement select = conn.prepareStatement(
                "SELECT * FROM zoo.golfinho WHERE id = ?;",
                PreparedStatement.RETURN_GENERATED_KEYS
            );

            // Passando o ID recebido no parâmetro para a Query.
            select.setInt(1, id);
            // Executando a Query.
            ResultSet rs = select.executeQuery();


            // Iterando sobre o resultado.
            while (rs.next()) {
                Golfinho golfinho = new Golfinho(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getInt(3)
                );

                System.out.println(golfinho);
            }
               

            // Fechando a conexão com DB.
            dao.endConnection();

        } catch (Exception e) {
            System.err.println("Tivemos um problema.");
            System.err.println(e.getMessage());
        }
    }

    // Realizando um Update em Golfinho conforme o ID.
    public void updateLeao() {
        try {
            // Instânciando a classe DAO, start na conexão com DB.
            DAO dao = new DAO();
            Connection conn = dao.startConnection();
   
            // Preparando o Select com PreparedStatement:
            PreparedStatement select = conn.prepareStatement(
                "UPDATE zoo.leao SET id = ?, nome = ?, alimentacao = ?, visitantes = ? WHERE id = ?;",
                PreparedStatement.RETURN_GENERATED_KEYS
            );

            // Executando a Query.
            ResultSet rs = select.executeQuery();


            // Iterando sobre o resultado.
            while (rs.next()) {
                Golfinho golfinho = new Golfinho(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getInt(3)
                );

                System.out.println(golfinho);
            }
               

            // Fechando a conexão com DB.
            dao.endConnection();

        } catch (Exception e) {
            System.err.println("Tivemos um problema.");
            System.err.println(e.getMessage());
        }
    }

}
