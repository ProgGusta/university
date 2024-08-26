public class Livro {
    protected String titulo;
    protected String autor;
    protected int nroPaginas;
    protected int anoPublicacao;

    public Livro() 
    {
        this.titulo = "";
        this.autor = "";
        this.nroPaginas = 0;
        this.anoPublicacao = 0;
    }

    public Livro(String titulo, String autor, int nroPaginas, int anoPublicacao) 
    {
        this.titulo = titulo;
        this.autor = autor;
        this.nroPaginas = nroPaginas;
        this.anoPublicacao = anoPublicacao;
    }

    public String toString() 
    {
        return "Título: " + titulo + ", Autor: " + autor + ", Número de Páginas: " + nroPaginas + ", Ano de Publicação: " + anoPublicacao;
    }

    public boolean isOlder(int ano) 
    {
        return anoPublicacao < ano;
    }
}