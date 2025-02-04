import java.sql.Statement;
import java.sql.Connection;

    // * Cria a tabela livros.
public class DatabaseCreate {
    public static void criarTabela() {
        String sql = "CREATE TABLE IF NOT EXISTS livros (" + 
        "id INTEGER PRIMARY KEY AUTOINCREMENT," + 
        "titulo VARCHAR(80) NOT NULL," + 
        "autor VARCHAR(60) NOT NULL," + 
        "ano INTEGER NOT NULL," + 
        "genero VARCHAR(40) NOT NULL)";
        
        try (Connection conexao = DatabaseConnection.conectar()) {
            Statement stmt = conexao.createStatement();
            stmt.executeUpdate(sql);
            System.out.println("Tabela livros criada.");
        } catch (Exception e) {
            System.out.println("Erro ao criar a tabela: " + e.getMessage());
        }
    }   
}
