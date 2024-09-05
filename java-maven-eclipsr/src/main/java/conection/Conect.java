package conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conect {
    private static final String URL = "jdbc:mysql://localhost:3306/sistema_livro";
    private static final String USER = "root";
    private static final String PASSWORD = "cacomp#1234";

    static {
        try {
            // Registra o driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConexao() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
