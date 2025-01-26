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

    // * Método para adicionar um livro.
    // !--------------------------------------- Método não funcionando, necessário corrigir -----------------.
    public static void adicionarLivro(Livro[] livros, Livro novoLivro) {
        for (int i = 0; i < livros.length; i++) {
            if (livros[i] == null) {
                livros[i] = novoLivro;
                break; 
            }
        }
    }

    // * Método para exibir informações dos livros instanciados.
    public void exibirInformacoes() {
        System.out.println("ID: " + ID);
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Ano de publicação: " + anoPublicacao);
        System.out.println("Gênero: " + genero);
    }

    // * Método para buscar livros por título ou pelo autor.
    public static void buscarLivro(Livro[] livros, String busca) {
    boolean encontrado = false;
    for (Livro livro : livros) {
        // Verifica se o livro não é nulo e se o título ou autor são iguais ao termo de busca.
        if (livro != null && (livro.titulo.equals(busca) || livro.autor.equals(busca))) {
            livro.exibirInformacoes();
            encontrado = true;
            break; // Para o loop após encontrar o livro.
        }
    }
    if (!encontrado) {
        System.out.println("Livro não encontrado.");
    }
}

    // * Método para deletar um livro.
    public static void deletarLivro(Livro[] livros, Integer ID) {
        for (int i = 0; i < livros.length; i++) {
            if (livros[i].ID == ID) {
                livros[i] = null;
            }
        }
    }
 }