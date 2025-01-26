public class Livro {
    Integer ID;
    String titulo;
    String autor;
    Integer anoPublicacao;
    String genero;

    public Livro(Integer ID, String titulo, String autor, Integer anoPublicao, String genero) {
        this.ID = ID;
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicao;
        this.genero = genero;
    }

    public Integer getID() {
        return ID;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public Integer getAnoPublicacao() {
        return anoPublicacao;
    }

    public String getGenero() {
        return genero;
    }
}