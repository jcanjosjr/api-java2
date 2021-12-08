package model;

// Importando bibliotecas.
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class DAO {

    public Connection connection;

    // Valida se existe conexão, se não existir, retorna a conexão.
    public Connection startConnection() throws Exception {
        if (this.connection != null && !connection.isClosed()) {
            return this.connection;
        }

        this.connection = getConnection();

        return this.connection;
    }

    // Fechando a conexão com o banco.
    public void endConnection() throws SQLException, Exception {
        startConnection().close();
    }

    // Realizando a conexão direta com o banco Zoo.
    public static Connection getConnection() throws Exception {
        try {
            final String url = "jdbc:mysql://localhost:3306/zoo?useTimezone=true&serverTimezone=UTC";
            final String user = "root";
            final String password = "";

            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}