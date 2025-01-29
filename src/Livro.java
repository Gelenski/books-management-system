import java.util.ArrayList;
import java.util.Scanner;

public class Livro {
    private static int contadorID = 1;
    private int ID;
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private String genero;

    public Livro(String titulo, String autor, int anoPublicacao, String genero) {
        this.ID = contadorID++;
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.genero = genero;
    }

    public int getID() {
        return this.ID;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getAutor() {
        return this.autor;
    }

    public int getAno() {
        return this.anoPublicacao;
    }

    public String getGenero() {
        return this.genero;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setAno(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void exibirInformacoes() {
        System.out.println("ID: " + this.ID);
        System.out.println("Título: " + this.titulo);
        System.out.println("Autor: " + this.autor);
        System.out.println("Ano de Publicação: " + this.anoPublicacao);
        System.out.println("Gênero: " + this.genero);
        System.out.println();
    }

    public static void buscarLivro(ArrayList<Livro> livros, String busca) {
    for (Livro livro : livros) {
        // Verifica se o livro não é nulo e se o título ou autor são iguais ao termo de busca.
        if (livro != null && (livro.getTitulo().equalsIgnoreCase(busca) || livro.getAutor().equalsIgnoreCase(busca))) {
            livro.exibirInformacoes();
            return; // Para o loop após encontrar o livro.
        } 
    }
    System.out.println("Livro não encontrado.");
}

    public static void alterarInfo(ArrayList<Livro> livros, int ID, int infoAlterar) {
        Scanner scanner = new Scanner(System.in);
        Livro livroAlterar = null;

        for (Livro livro : livros) {
            if (livro != null && livro.getID() == ID) {
                livroAlterar = livro;
                break;
            }
        }

        if (livroAlterar == null) {
            System.out.println("Livro com ID " + ID + " não encontrado.");
            return;
        }

        switch (infoAlterar) {
            case 1:
                System.out.println("Digite o novo título do livro:");
                String novoTitulo = scanner.next();
                livroAlterar.setTitulo(novoTitulo);
                break;

            case 2:
                System.out.println("Digite o novo autor do livro:");
                String novoAutor = scanner.next();
                livroAlterar.setAutor(novoAutor);
                break;

            case 3:
                System.out.println("Digite o novo ano de publicação do livro:");
                int novoAno = scanner.nextInt();
                livroAlterar.setAno(novoAno);
                break;

            case 4:
                System.out.println("Digite o novo gênero do livro:");
                String novoGenero = scanner.next();
                livroAlterar.setGenero(novoGenero);
                break;

            default:
                System.out.println("Opção inválida para alteração.");
                break;
        }

        System.out.println("Informação alterada com sucesso!");
    }

    public static void deletarLivro(ArrayList<Livro> livros, int ID) {
        for (int i = 0; i < livros.size(); i++) {
            if (livros.get(i).getID() == ID) {
                livros.remove(i);
                System.out.println("Livro deletado.");
                return;
            }
        }
        System.out.println("Livro com ID " + ID + " não encontrado.");
    }
}
