import java.util.Scanner;
import java.util.InputMismatchException;

public class App {

    // Método para exibir o menu principal
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

    // Método para limpar a tela
    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // Método principal
    public static void main(String[] args) {

        // Criação da tabela livros no banco
        DatabaseCreate.criarTabela();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            exibirMenu();
            System.out.print("Escolha uma opção: ");
            int opcao = getInputInt(scanner, "Escolha uma opção válida: ");  // Chama o método para ler inteiro

            switch (opcao) {
                case 1: // Adicionar livro
                    clear();  
                    System.out.println("Digite o título do livro:");
                    String titulo = scanner.next();
                    System.out.println("Digite o autor do livro:");
                    String autor = scanner.next();
                    System.out.println("Digite o ano de publicação do livro:");
                    int anoPublicacao = scanner.nextInt();
                    System.out.println("Digite o gênero do livro:");
                    String genero = scanner.next();
                    Livro novoLivro = new Livro(titulo, autor, anoPublicacao, genero);
                    novoLivro.salvar(); // Salvar diretamente no banco de dados
                    System.out.println("Livro adicionado com sucesso!");
                    continuar();
                    break;

                case 2: // Listar livros
                    clear();
                    Livro.listarLivros(); // Chama para buscar todos os livros
                    continuar();
                    break;

                case 3: // Buscar livro
                    clear();
                    String busca = getInputString(scanner, "Digite o título ou autor do livro:");
                    Livro.buscarLivro(busca); // Busca pelo título ou autor
                    continuar();
                    break;

                case 4: // Remover livro
                    clear();
                    int IDDeletar = getInputInt(scanner, "Digite o ID do livro a ser deletado:");
                    Livro.deletarLivro(IDDeletar); // Deleta pelo ID
                    continuar();
                    break;

                case 5: // Alterar informações de livro
                    clear();
                    int IDAlterar = getInputInt(scanner, "Digite o ID do livro:");
                    System.out.println("Que informação deseja alterar? Título (1), Autor (2), Ano de Publicação (3), Gênero (4):");
                    int infoAlterar = getInputInt(scanner, "Digite a opção de alteração: ");
                    String novoValor = getInputString(scanner, "Digite o novo valor:");
                    Livro.alterarInfo(IDAlterar, infoAlterar, novoValor); // Alteração no banco
                    continuar();
                    break;

                case 6: // Sair
                    clear();
                    System.out.println("Saindo...");
                    scanner.close();
                    System.exit(0);

                default: // Opção inválida
                    clear();
                    System.out.println("Opção inválida. Tente novamente.");
                    continuar();
                    break;
            }
        }
    }

    // Método para capturar entrada do usuário do tipo inteiro com mensagem personalizada
    public static int getInputInt(Scanner scanner, String mensagem) {
        int valor = 0;
        boolean inputValido = false;

        while (!inputValido) {
            try {
                System.out.println(mensagem); // Exibe a mensagem solicitando o input
                valor = scanner.nextInt();
                inputValido = true; // Se a entrada for válida, sai do loop
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                scanner.next(); // Limpa o buffer de entrada
            }
        }
        return valor;
    }

    // Método para capturar entrada do usuário do tipo String com mensagem personalizada
    public static String getInputString(Scanner scanner, String mensagem) {
        System.out.println(mensagem);
        scanner.nextLine(); // Consome a linha restante
        return scanner.nextLine(); // Captura a linha inteira
    }

    // Método para continuar no menu
    public static void continuar() {
        System.out.println("Pressione Enter para continuar...");
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
