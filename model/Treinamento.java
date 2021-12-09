package model;

// Importando bibliotecas.
import java.sql.Date;
import java.util.List;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;

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

    public static Treinamento inserirTreinamento(int golfinhoId, Date data, String detalhes) throws Exception {
        try {
            // Instânciando a classe DAO, start na conexão com DB.
            DAO dao = new DAO();
            Connection conn = dao.startConnection();
    
            // Criando o INSERT para inserir dados em Treinamento.
            PreparedStatement insert = conn.prepareStatement(
                "INSERT INTO zoo.treinamento (golfinho_id, data, detalhes) VALUES (?, ?, ?);",
                PreparedStatement.RETURN_GENERATED_KEYS
            );

            // Atribuindo parâmetros ao INSERT.
            insert.setInt(1, golfinhoId);
            insert.setDate(2, data);
            insert.setString(3, detalhes);

            // Executando a QUERY utilizando ResultSet para pegar resultados.
            if (insert.executeUpdate() > 0) {                
                ResultSet rs = insert.getGeneratedKeys();
                rs.next();
                Treinamento treinamento = new Treinamento(rs.getInt(1), data, detalhes);

                // Fechando a conexão com DB.
                dao.endConnection();

                return treinamento;
            }

            // Fechando a conexão com DB.
            dao.endConnection();
            throw new Exception("Erro ao incluir Treinamento.");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        
    }
    
}
