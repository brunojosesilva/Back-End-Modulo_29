package main.java.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Bruno.Silva
 * Utilizado para efetuar a conexao com o banco de dados.
 */
public class ConnectionFactory {
    private static Connection connection;
    private ConnectionFactory(Connection connection) {

    }

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = initConnection();
        }
        return connection;
    }

    private static Connection initConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:postgresql://localhost:15432/Curso", "postgres", "Jsilva00");
        } catch (SQLException e) {
            throw  new RuntimeException(e);
        }
    }

}
