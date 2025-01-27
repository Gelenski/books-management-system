import java.util.ArrayList;

public class Livro {
    // * Atributos.
    // Static significa que o atributo é da classe e não do objeto.
    private static int contadorID = 1; // Gera os IDs automaticamente.
    private Integer ID;
    private String titulo;
    private String autor;
    private Integer anoPublicacao;
    private String genero;

    // * Constructor.
    public Livro(String titulo, String autor, Integer anoPublicao, String genero) {
        this.ID = contadorID++;
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicao;
        this.genero = genero;
    }

    // * Getters 
    public Integer getID() {
        return this.ID;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getAutor() {
        return this.autor;
    }

    public Integer getAno() {
        return this.anoPublicacao;
    }

    public String getGenero() {
        return this.genero;
    }

    // * Setters
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setAno(Integer anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }
    
    public void setGenero(String genero) {
        this.genero = genero;
    }

    // * Método para exibir informações dos livros instanciados.
    public void exibirInformacoes() {
        System.out.println("ID: " + this.ID);
        System.out.println("Título: " + this.titulo);
        System.out.println("Autor: " + this.autor);
        System.out.println("Ano de publicação: " + this.anoPublicacao);
        System.out.println("Gênero: " + this.genero);
    }

    // * Método para buscar livros por título ou pelo autor.
    public static void buscarLivro(ArrayList<Livro> livros, String busca) {
    for (Livro livro : livros) {
        // Verifica se o livro não é nulo e se o título ou autor são iguais ao termo de busca.
        if (livro != null && (livro.titulo.equalsIgnoreCase(busca) || livro.autor.equalsIgnoreCase(busca))) {
            livro.exibirInformacoes();
            return; // Para o loop após encontrar o livro.
        } 
    }
    System.out.println("Livro não encontrado.");
}

    // * Método para alterar informações de um livro.
    public static void alterarInfo() {
         
    }

    // * Método para deletar um livro.
    public static void deletarLivro(ArrayList<Livro> livros, Integer ID) {
        for (int i = 0; i < livros.size(); i++) {
            if (livros.get(i).ID.equals(ID)) {
                livros.remove(i);
                System.out.println("Livro deletado.");
                return;
        }
    }
 }
}