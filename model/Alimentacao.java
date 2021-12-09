package model;

// Importando bibliotecas.
import java.sql.Date;
import java.util.List;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;

public class Alimentacao {

    // Atributos da classe Alimentação.
    private int id;
    private Date data;
    private String detalhes;
    // Alimnetação possui diversos leões:
    private List<Leao> leoes = new ArrayList<>();

    // Método construtor de Alimentação.
    public Alimentacao(int id, Date data, String detalhes) {
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

    public List<Leao> getLeoes() {
        return this.leoes;
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

    public void setLeoes(Leao leao) {
        this.leoes.add(leao);
    }

    // Método para comparar objeto com Alimentação:
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Alimentacao)) {
            return false;
        }

        Alimentacao alimentacao = (Alimentacao) o;
        return this.getId() == alimentacao.getId();
    }

    // Trazendo Alimentação em forma de texto.
    @Override
    public String toString() {
        String printAlimentacao = 
        "Alimentação! \n" + 
        "Data: " + this.getData() + "\n" +
        "Detalhes da alimentação: " + this.getDetalhes() + "\n" +
        "ID: " + this.getId() + "\n";
        
        if(!(this.leoes.isEmpty())) {
            for (Leao leao: this.leoes) {
                printAlimentacao += "Leões: " + leao.getNome() + "\n";
            }
        } else {
            printAlimentacao += "Leões ainda não possuem alimentações. \n";
        }

        return printAlimentacao;
    }

    // Inserindo dados em Alimentação.
    public static Alimentacao insertAlimentacao(int idLeao, Date data, String detalhes) throws Exception {
        try {
            // Instânciando a classe DAO, iniciando conexão com DB.
            DAO dao = new DAO();
            Connection conn = dao.startConnection();

            // Criando o INSERT para inserir todos os dados da tabela Leão.
            PreparedStatement insert = conn.prepareStatement(
                "INSERT INTO zoo.alimentacao (leao_id, data, detalhes) VALUES (?, ?, ?);",
                PreparedStatement.RETURN_GENERATED_KEYS
            );
                
            // Atribuindo parâmetros ao INSERT.
            insert.setInt(1, idLeao);
            insert.setDate(2, data);
            insert.setString(3, detalhes);

            if (insert.executeUpdate() > 0) {
                ResultSet rs = insert.getGeneratedKeys();
                rs.next();
                Alimentacao alimento = new Alimentacao(rs.getInt(1), data, detalhes);
                // Fechando a conexão com DB.
                dao.endConnection();
                return alimento;
            }

            // Fechando a conexão com DB.
            dao.endConnection();
            throw new Exception("Erro ao incluir Alimentação");

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
