import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class DatabaseCreate {
    public static void criarTabela() {
        String sqlCreate = "CREATE TABLE IF NOT EXISTS livros (" + 
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " + 
                "titulo VARCHAR(80) NOT NULL, " + 
                "autor VARCHAR(60) NOT NULL, " + 
                "ano INTEGER NOT NULL, " + 
                "genero VARCHAR(40) NOT NULL)";

        try (Connection conexao = DatabaseConnection.conectar();
             Statement stmt = conexao.createStatement()) {
            stmt.executeUpdate(sqlCreate);
            System.out.println("Tabela 'livros' criada ou já existente.");

            // Verifica se a tabela está vazia antes de inserir
            if (estaVazia(conexao)) {
                popularTabela(stmt);
                System.out.println("Tabela 'livros' populada com dados iniciais.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao criar a tabela: " + e.getMessage());
        }
    }

    private static boolean estaVazia(Connection conexao) {
        String sqlVerificar = "SELECT COUNT(*) AS total FROM livros";
        try (Statement stmt = conexao.createStatement();
             ResultSet rs = stmt.executeQuery(sqlVerificar)) {
            if (rs.next()) {
                return rs.getInt("total") == 0; // Retorna true se a tabela estiver vazia
            }
        } catch (Exception e) {
            System.out.println("Erro ao verificar se a tabela está vazia: " + e.getMessage());
        }
        return false;
    }

    private static void popularTabela(Statement stmt) {
        String sqlInsert = "INSERT INTO livros (titulo, autor, ano, genero) VALUES " +
                "('1984', 'George Orwell', 1949, 'Ficção'), " +
                "('Dom Casmurro', 'Machado de Assis', 1899, 'Romance'), " +
                "('O Senhor dos Anéis', 'J.R.R. Tolkien', 1954, 'Fantasia'), " +
                "('A Revolução dos Bichos', 'George Orwell', 1945, 'Sátira política');";

        try {
            stmt.executeUpdate(sqlInsert);
        } catch (Exception e) {
            System.out.println("Erro ao popular a tabela: " + e.getMessage());
        }
    }
}
