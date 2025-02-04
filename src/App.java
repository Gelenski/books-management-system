import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void exibirMenu() {
        clear();
        System.out.println("Bem-vindo ao sistema de biblioteca!");
        System.out.println("Selecione uma opção:");
        System.out.println("1 - Adicionar livro");
        System.out.println("2 - Listar livros");
        System.out.println("3 - Buscar livro");
        System.out.println("4 - Remover livro");
        System.out.println("5 - Alterar informações de livro");
        System.out.println("6 - Sair");
    }

    // * Método que limpa a tela.  
    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) {
        
        // * Criação da tabela livros.
        DatabaseCreate.criarTabela();

        Livro livro1 = new Livro("O Senhor dos Anéis", "J.R.R. Tolkien", 1954, "Fantasia");
        Livro livro2 = new Livro("Harry Potter", "J.K. Rowling", 1997, "Fantasia");
        Livro livro3 = new Livro("O Hobbit", "J.R.R. Tolkien", 1937, "Fantasia");
        Livro livro4 = new Livro("A Game of Thrones", "George R.R. Martin", 1996, "Fantasia");
        Livro livro5 = new Livro("Ética à Nicômaco", "Aristóteles", 274, "Filosofia");

        ArrayList<Livro> livros = new ArrayList<Livro>();
        livros.add(livro1);
        livros.add(livro2);
        livros.add(livro3);
        livros.add(livro4);
        livros.add(livro5);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            exibirMenu();
            System.out.print("Escolha uma opção: ");
            int opcao;
            try {
            opcao = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Por favor insira uma opção válida.");
                scanner.next();
                continuar();
                continue;
            }

            switch (opcao) {
                case 1:
                    clear();
                    System.out.println("Digite o título do livro:");
                    String titulo = scanner.next();
                    System.out.println("Digite o autor do livro:");
                    String autor = scanner.next();
                    System.out.println("Digite o ano de publicação do livro:");
                    int anoPublicacao;
                    try {
                    anoPublicacao = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Por favor insira uma ano válido.");
                        scanner.next();
                        continuar();
                        continue;
                    }
                    System.out.println("Digite o gênero do livro:");
                    String genero = scanner.next();
                    Livro novoLivro = new Livro(titulo, autor, anoPublicacao, genero);
                    livros.add(novoLivro);
                    System.out.println("Livro adicionado com sucesso!");
                    break;

                case 2:
                    clear();
                    if (livros.isEmpty()) {
                        System.out.println("Nenhum livro cadastrado.");
                    } else {
                        for (Livro livro : livros) {
                            livro.exibirInformacoes();
                        }
                    }
                    continuar();
                    break;
                case 3:
                    clear();
                    System.out.println("Digite o título ou autor do livro:");
                    String busca = scanner.next();
                    Livro.buscarLivro(livros, busca);
                    continuar();
                    break;

                case 4:
                    clear();
                    System.out.println("Digite o ID do livro:");
                    int ID = scanner.nextInt();
                    Livro.deletarLivro(livros, ID);
                    break;

                case 5:
                    clear();
                    System.out.println("Digite o ID do livro:");
                    int IDAlterar = scanner.nextInt();
                    System.out.println("Que informação deseja alterar? Título (1), Autor (2), Ano de Publicação (3), Gênero (4):");
                    int infoAlterar = scanner.nextInt();
                    Livro.alterarInfo(livros, IDAlterar, infoAlterar);
                    break;

                case 6:
                    clear();    
                    System.out.println("Saindo...");
                    scanner.close();
                    System.exit(0);

                default:
                    clear();
                    System.out.println("Opção inválida. Tente novamente.");
                    continuar();
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
}
