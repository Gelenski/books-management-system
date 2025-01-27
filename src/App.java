import java.util.ArrayList;
import java.util.Scanner;
public class App {
    public static void menu() {
        System.out.println("Bem-vindo ao sistema de biblioteca!");
        System.out.println("Selecione uma opção:");
        System.out.println("1 - Adicionar livro");
        System.out.println("2 - Listar livro");
        System.out.println("3 - Buscar livro");
        System.out.println("4 - Remover livro");
        System.out.println("5 - Sair");
    }
    public static void main(String[] args) throws Exception {
        Livro livro1 = new Livro("O Senhor dos Anéis", "J.R.R. Tolkien", 1954, "Fantasia");
        Livro livro2 = new Livro("Harry Potter", "J.K. Rowling", 1997, "Fantasia");
        Livro livro3 = new Livro("O Hobbit", "J.R.R. Tolkien", 1937, "Fantasia");
        Livro livro4 = new Livro("A Game of Thrones", "George R.R. Martin", 1996, "Fantasia");

        ArrayList<Livro> livros = new ArrayList<Livro>();

        livros.add(livro1);
        livros.add(livro2);
        livros.add(livro3);
        livros.add(livro4);

        //// Livro[] livros = {livro1, livro2, livro3, livro4};
        
        // * Loop para manter o programa em execução.
        while (true) {
            menu();
            Scanner scanner = new Scanner(System.in);
            Integer opcao = scanner.nextInt();

            // * Verifica a opção escolhida.
            switch (opcao) {
                case 1: 
                    System.out.println("Digite o título do livro:");
                    String titulo = scanner.next();
                    System.out.println("Digite o autor do livro:");
                    String autor = scanner.next();
                    System.out.println("Digite o ano de publicação do livro:");
                    Integer anoPublicacao = scanner.nextInt();
                    System.out.println("Digite o gênero do livro:");
                    String genero = scanner.next();
                    Livro novoLivro = new Livro(titulo, autor, anoPublicacao, genero);
                    livros.add(novoLivro);
                break;

                case 2:
                    for (Livro livro : livros) {
                        if (livro != null) {
                            livro.exibirInformacoes();
                        }
                    }
                break;

                case 3:
                    System.out.println("Digite o título ou autor do livro:");
                    String busca = scanner.next();
                    Livro.buscarLivro(livros, busca);
                break;

                case 4:
                    System.out.println("Digite o ID do livro:");
                    Integer ID = scanner.nextInt();
                    Livro.deletarLivro(livros, ID);
                break;

                case 5:
                    System.out.println("Saindo...");
                    System.exit(0);
                    scanner.close();
                break;

                default:
                    System.out.println("Opção inválida.");
                break;
            }
        }
    }
}
