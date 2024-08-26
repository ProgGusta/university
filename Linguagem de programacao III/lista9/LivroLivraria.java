public class LivroLivraria extends Livro {
    private double preco;
    private int estoque;

    public LivroLivraria() 
    {
        super();
        this.preco = 0.0;
        this.estoque = 0;
    }

    public LivroLivraria(String titulo, String autor, int nroPaginas, int anoPublicacao, double preco, int estoque) 
    {
        super(titulo, autor, nroPaginas, anoPublicacao);
        this.preco = preco;
        this.estoque = estoque;
    }

    public String toString() 
    {
        return super.toString() + ", Preço: " + preco + ", Estoque: " + estoque;
    }

    public void sell() 
    {
        if (estoque > 0) {
            estoque--;
            System.out.println("Livro vendido com sucesso.");
        } else {
            System.out.println("Livro indisponível para venda.");
        }
    }

    public boolean isAvailable() 
    {
        return estoque > 0;
    }
}