import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void exibirMenu() {
        System.out.println("Bem-vindo ao sistema de biblioteca!");
        System.out.println("Selecione uma opção:");
        System.out.println("1 - Adicionar livro");
        System.out.println("2 - Listar livros");
        System.out.println("3 - Buscar livro");
        System.out.println("4 - Remover livro");
        System.out.println("5 - Alterar informações de livro");
        System.out.println("6 - Sair");
    }

    public static void main(String[] args) {
        Livro livro1 = new Livro("O Senhor dos Anéis", "J.R.R. Tolkien", 1954, "Fantasia");
        Livro livro2 = new Livro("Harry Potter", "J.K. Rowling", 1997, "Fantasia");
        Livro livro3 = new Livro("O Hobbit", "J.R.R. Tolkien", 1937, "Fantasia");
        Livro livro4 = new Livro("A Game of Thrones", "George R.R. Martin", 1996, "Fantasia");

        ArrayList<Livro> livros = new ArrayList<Livro>();
        livros.add(livro1);
        livros.add(livro2);
        livros.add(livro3);
        livros.add(livro4);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            exibirMenu();
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o título do livro:");
                    String titulo = scanner.next();
                    System.out.println("Digite o autor do livro:");
                    String autor = scanner.next();
                    System.out.println("Digite o ano de publicação do livro:");
                    int anoPublicacao = scanner.nextInt();
                    System.out.println("Digite o gênero do livro:");
                    String genero = scanner.next();
                    Livro novoLivro = new Livro(titulo, autor, anoPublicacao, genero);
                    livros.add(novoLivro);
                    System.out.println("Livro adicionado com sucesso!");
                    break;

                case 2:
                    if (livros.isEmpty()) {
                        System.out.println("Nenhum livro cadastrado.");
                    } else {
                        for (Livro livro : livros) {
                            livro.exibirInformacoes();
                        }
                    }
                    break;

                case 3:
                clear();
                    System.out.println("Digite o título ou autor do livro:");
                    String busca = scanner.next();
                    Livro.buscarLivro(livros, busca);
                    break;

                case 4:
                clear();
                    System.out.println("Digite o ID do livro:");
                    int ID = scanner.nextInt();
                    Livro.deletarLivro(livros, ID);
                    break;

                case 5:
                    System.out.println("Digite o ID do livro:");
                    int IDAlterar = scanner.nextInt();
                    System.out.println("Que informação deseja alterar? Título (1), Autor (2), Ano de Publicação (3), Gênero (4):");
                    int infoAlterar = scanner.nextInt();
                    Livro.alterarInfo(livros, IDAlterar, infoAlterar);
                    break;

                case 6:
                    System.out.println("Saindo...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    // * Menu da aplicação. 
     public static void menu() {
        clear();
        System.out.println("Bem-vindo ao sistema de biblioteca!");
        System.out.println("Selecione uma opção:");
        System.out.println("1 - Adicionar livro");
        System.out.println("2 - Listar livro");
        System.out.println("3 - Buscar livro");
        System.out.println("4 - Remover livro");
        System.out.println("5 - Sair");
    }

    // * Método que retorna ao menu principal.
    public static void continuar() {
        System.out.println("Pressione Enter para continuar...");
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // * Método que limpa a tela.  
    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
