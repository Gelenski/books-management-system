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

    //// Método para adicionar um livro. (Deprecated)
    // !--------------------------------------- Método não funcionando, necessário corrigir -----------------.
    // public static void adicionarLivro(Livro[] livros, Livro novoLivro) {
    //     for (int i = 0; i < livros.length; i++) {
    //         if (livros[i] == null) {
    //             livros[i] = novoLivro;
    //             break; 
    //         }
    //     }
    // }

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