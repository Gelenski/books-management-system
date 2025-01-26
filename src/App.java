public class App {
    public static void main(String[] args) throws Exception {
        Livro livro = new Livro(1, "O Senhor dos Anéis", "J.R.R. Tolkien", 1954, "Fantasia");
        System.out.println("ID: " + livro.getID());
        System.out.println("Título: " + livro.getTitulo());
        System.out.println("Autor: " + livro.getAutor());
        System.out.println("Ano de Publicação: " + livro.getAnoPublicacao());
        System.out.println("Gênero: " + livro.getGenero());
    }
}
