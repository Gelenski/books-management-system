import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Livro {
    private int id;
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private String genero;

    // Construtor
    public Livro(String titulo, String autor, int anoPublicacao, String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.genero = genero;
    }

    // Construtor para quando o livro já está no banco de dados (com ID)
    public Livro(int id, String titulo, String autor, int anoPublicacao, String genero) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.genero = genero;
    }

    // Método para salvar o livro no banco de dados
    public void salvar() {
        // Obtém a conexão com o banco de dados
        Connection conexao = DatabaseConnection.conectar();
        if (conexao != null) {
            String sql = "INSERT INTO livros (titulo, autor, ano, genero) VALUES (?, ?, ?, ?)";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setString(1, this.titulo);
                stmt.setString(2, this.autor);
                stmt.setInt(3, this.anoPublicacao);
                stmt.setString(4, this.genero);
                stmt.executeUpdate();  // Executa o comando de inserção
                System.out.println("Livro salvo com sucesso!");
            } catch (SQLException e) {
                System.out.println("Erro ao salvar o livro no banco de dados: " + e.getMessage());
            } finally {
                try {
                    conexao.close();  // Fecha a conexão após a operação
                } catch (SQLException e) {
                    System.out.println("Erro ao fechar a conexão: " + e.getMessage());
                }
            }
        } else {
            System.out.println("Erro na conexão com o banco de dados.");
        }
    }

    // Método para exibir as informações do livro
    public void exibirInformacoes() {
        System.out.println("ID: " + this.id);
        System.out.println("Título: " + this.titulo);
        System.out.println("Autor: " + this.autor);
        System.out.println("Ano de Publicação: " + this.anoPublicacao);
        System.out.println("Gênero: " + this.genero);
    }

    // Método para listar todos os livros
    public static void listarLivros() {
        Connection conexao = DatabaseConnection.conectar();
        if (conexao != null) {
            String sql = "SELECT * FROM livros";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    do {
                        Livro livro = new Livro(
                                rs.getInt("id"),
                                rs.getString("titulo"),
                                rs.getString("autor"),
                                rs.getInt("ano"),
                                rs.getString("genero")
                        );
                        livro.exibirInformacoes();
                    } while (rs.next());
                } else {
                    System.out.println("Nenhum livro cadastrado.");
                }
            } catch (SQLException e) {
                System.out.println("Erro ao listar os livros: " + e.getMessage());
            } finally {
                try {
                    conexao.close();
                } catch (SQLException e) {
                    System.out.println("Erro ao fechar a conexão: " + e.getMessage());
                }
            }
        } else {
            System.out.println("Erro na conexão com o banco de dados.");
        }
    }

    // Método para buscar um livro pelo título ou autor
    public static void buscarLivro(String busca) {
        Connection conexao = DatabaseConnection.conectar();
        if (conexao != null) {
            String sql = "SELECT * FROM livros WHERE titulo LIKE ? OR autor LIKE ?";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setString(1, "%" + busca + "%");
                stmt.setString(2, "%" + busca + "%");
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    Livro livro = new Livro(
                            rs.getInt("id"),
                            rs.getString("titulo"),
                            rs.getString("autor"),
                            rs.getInt("ano"),
                            rs.getString("genero")
                    );
                    livro.exibirInformacoes();
                } else {
                    System.out.println("Livro não encontrado.");
                }
            } catch (SQLException e) {
                System.out.println("Erro ao buscar o livro: " + e.getMessage());
            } finally {
                try {
                    conexao.close();
                } catch (SQLException e) {
                    System.out.println("Erro ao fechar a conexão: " + e.getMessage());
                }
            }
        } else {
            System.out.println("Erro na conexão com o banco de dados.");
        }
    }

    // Método para deletar um livro do banco de dados
    public static void deletarLivro(int id) {
        Connection conexao = DatabaseConnection.conectar();
        if (conexao != null) {
            String sql = "DELETE FROM livros WHERE id = ?";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setInt(1, id);
                int linhasAfetadas = stmt.executeUpdate();
                if (linhasAfetadas > 0) {
                    System.out.println("Livro deletado com sucesso!");
                } else {
                    System.out.println("Livro não encontrado.");
                }
            } catch (SQLException e) {
                System.out.println("Erro ao deletar o livro: " + e.getMessage());
            } finally {
                try {
                    conexao.close();
                } catch (SQLException e) {
                    System.out.println("Erro ao fechar a conexão: " + e.getMessage());
                }
            }
        } else {
            System.out.println("Erro na conexão com o banco de dados.");
        }
    }

    // Método para alterar informações de um livro no banco de dados
    public static void alterarInfo(int id, int infoAlterar, String novoValor) {
        Connection conexao = DatabaseConnection.conectar();
        if (conexao != null) {
            String sql = "";
            switch (infoAlterar) {
                case 1:
                    sql = "UPDATE livros SET titulo = ? WHERE id = ?";
                    break;
                case 2:
                    sql = "UPDATE livros SET autor = ? WHERE id = ?";
                    break;
                case 3:
                    sql = "UPDATE livros SET ano = ? WHERE id = ?";
                    break;
                case 4:
                    sql = "UPDATE livros SET genero = ? WHERE id = ?";
                    break;
                default:
                    System.out.println("Opção inválida.");
                    return;
            }

            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                if (infoAlterar == 3) {
                    stmt.setInt(1, Integer.parseInt(novoValor));
                } else {
                    stmt.setString(1, novoValor);
                }
                stmt.setInt(2, id);
                int linhasAfetadas = stmt.executeUpdate();
                if (linhasAfetadas > 0) {
                    System.out.println("Informação alterada com sucesso!");
                } else {
                    System.out.println("Livro não encontrado.");
                }
            } catch (SQLException e) {
                System.out.println("Erro ao alterar a informação do livro: " + e.getMessage());
            } finally {
                try {
                    conexao.close();
                } catch (SQLException e) {
                    System.out.println("Erro ao fechar a conexão: " + e.getMessage());
                }
            }
        } else {
            System.out.println("Erro na conexão com o banco de dados.");
        }
    }

    // Getter e Setter para o ID
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
