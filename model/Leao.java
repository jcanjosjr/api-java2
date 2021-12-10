package model;

// Importando bibliotecas.
import java.util.List;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Leao extends Animal implements Pesquisa {
    
    // Atributos da classe Leão.
    private int alimentado;
    private int visitantes;
    // Leão possui N ->  Alimentações.
    private List<Alimentacao> alimentacoes = new ArrayList<>();

    // Método construtor da classe Leão.
    public Leao(
        int id,
        String nome,
        int alimentado,
        int visitantes
    ) {
        super(id, nome);
        this.alimentado = alimentado;
        this.visitantes = visitantes;
    }


   // Getters
   public int getAlimentado() {
    return alimentado;
    }

    public List<Alimentacao> getAlimentacao() {
        return this.alimentacoes;
    }

    public int getVisitantes() {
        return visitantes;
    }

    // Getter para última refeição.
    public Alimentacao getUltiAlimentacao() {
        return alimentacoes.get(alimentacoes.size() - 1);
    }

    // Setters
    public void setAlimentacoes(Alimentacao alimentacao) {
        this.alimentacoes.add(alimentacao);
    }

    public void setVisitantes(int visitantes) {
        this.visitantes = visitantes;
    }

    public void setAlimentado(int alimentado) {
        this.alimentado = alimentado;
    }

    // Método para comparar objeto com Leão:
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Leao)) {
            return false;
        }

        Leao leao = (Leao) o;
        return this.getId() == leao.getId();
    }

    // Trazendo leão em texto.
    @Override
    public String toString() {
        String printLeao = 
            "Leão! \n" +
            "Nome: " + getNome() + "\n" +
            "Hora em que foi alimentado: " + getAlimentado() + "\n" +
            "Jaula em que está: " + getJaula() + "\n" +
            "Quantidade de visitantes: " + getVisitantes() + "\n";
        
        if(!(this.alimentacoes.isEmpty())) {
            for(Alimentacao alimentacao : this.alimentacoes) {
                printLeao += "Alimentações: " + alimentacao.getDetalhes() + "\n";
            }
        } else {
            printLeao += "Leão ainda não foi alimentado.";
        }

        return printLeao;
    }

    // Realizando um INSERT na tabela Leão.
    public static Leao insertLeao(String nome, int alimentado, int visitantes, int jaulaId) throws Exception {
        try {
            // Instânciando a classe DAO, start na conexão com DB.
            DAO dao = new DAO();
            Connection conn = dao.startConnection();
    
            // Criando o INSERT para inserir todos os dados da tabela Leão.
            PreparedStatement insert = conn.prepareStatement(
                "INSERT INTO zoo.leao (nome, alimentacao, visitantes, jaula_id) VALUES (?, ?, ?, ?);",
                PreparedStatement.RETURN_GENERATED_KEYS
            );

            // Atribuindo parâmetros ao INSERT.
            insert.setString(1, nome);
            insert.setInt(2, alimentado);
            insert.setInt(3, visitantes);
            insert.setInt(4, jaulaId);

            // Executando a QUERY utilizando ResultSet para pegar resultados.
            if(insert.executeUpdate() > 0) {
                ResultSet rs = insert.getGeneratedKeys();
                rs.next();
                Leao leao = new Leao(rs.getInt(1), nome, alimentado, visitantes);

                // Fechando a conexão com DB.
                dao.endConnection();

                return leao;
            }

            // Fechando a conexão com DB.
            dao.endConnection();
            throw new Exception("Erro ao incluir Golfinho.");

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    // Buscando todos os dados na tabela Leão
    public void getAll() {
        try {
            // Instânciando a classe DAO, start na conexão com DB.
            DAO dao = new DAO();
            Connection conn = dao.startConnection();

            // Criando o java statement.
            Statement st = conn.createStatement();
    
            // Criando o SELECT para trazer todos os dados da tabela Golfinho.
            String select = "SELECT * FROM zoo.leao;";

            // Executando a query, e obtendo o resultado.
            ResultSet rs = st.executeQuery(select);

            // Iterando sobre o resultado.
            while (rs.next()) {
                Leao leao = new Leao(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getInt(3),
                    rs.getInt(4)
                );

                System.out.println(leao);
            }
               

            // Fechando a conexão com DB.
            dao.endConnection();

        } catch (Exception e) {
            System.err.println("Tivemos um problema.");
            System.err.println(e.getMessage());
        }
    }

    // Buscando Leão pelo ID.
    public void getPorId(int id) {
        try {
            // Instânciando a classe DAO, start na conexão com DB.
            DAO dao = new DAO();
            Connection conn = dao.startConnection();
   
            // Preparando o Select com PreparedStatement:
            PreparedStatement select = conn.prepareStatement(
                "SELECT * FROM zoo.leao WHERE id = ?;",
                PreparedStatement.RETURN_GENERATED_KEYS
            );

            // Passando o ID recebido no parâmetro para a Query.
            select.setInt(1, id);
            // Executando a Query.
            ResultSet rs = select.executeQuery();


            // Iterando sobre o resultado.
            while (rs.next()) {
                Leao leao = new Leao(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getInt(3),
                    rs.getInt(4)
                );

                System.out.println(leao);
            }
               

            // Fechando a conexão com DB.
            dao.endConnection();

        } catch (Exception e) {
            System.err.println("Tivemos um problema.");
            System.err.println(e.getMessage());
        }
    }

    // Realizando um Update em Leão conforme o ID.
    public static Leao updateLeao(int id, String nome, int alimentado, int visitantes, int jaulaId) throws Exception {
        try {
            // Instânciando a classe DAO, start na conexão com DB.
            DAO dao = new DAO();
            Connection conn = dao.startConnection();
   
            // Preparando o Select com PreparedStatement:
            PreparedStatement update = conn.prepareStatement(
                "UPDATE zoo.leao SET id = ?, nome = ?, alimentacao = ?, visitantes = ?, jaula_id = ? WHERE id = ?;",
                PreparedStatement.RETURN_GENERATED_KEYS
            );

            // Atribuindo parâmetros ao UPDATE.
            update.setInt(1, id);
            update.setString(2, nome);
            update.setInt(3, alimentado);
            update.setInt(4, visitantes);
            update.setInt(5, jaulaId);
            update.setInt(6, id);

            // Executando a QUERY utilizando ResultSet para pegar resultados.
            if(update.executeUpdate() > 0) {
                ResultSet rs = update.getGeneratedKeys();
                rs.next();
                Leao leao = new Leao(id, nome, alimentado, visitantes);

                // Fechando a conexão com DB.
                dao.endConnection();

                return leao;
            }
               

            // Fechando a conexão com DB.
            dao.endConnection();
            throw new Exception("Erro ao incluir Golfinho.");

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
