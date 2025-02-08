import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:sqlite:livros.db"; 

    public static Connection conectar() {
        try {
            Connection conexao = DriverManager.getConnection(URL);
            return conexao;
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco de dados: " + e.getMessage());
            return null;
        }
    }
}
