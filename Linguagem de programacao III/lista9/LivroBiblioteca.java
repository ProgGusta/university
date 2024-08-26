public class LivroBiblioteca extends Livro {
    private boolean emprestado;
    private String dataDevolucao;

    public LivroBiblioteca() 
    {
        super();
        this.emprestado = false;
        this.dataDevolucao = "";
    }

    public LivroBiblioteca(String titulo, String autor, int nroPaginas, int anoPublicacao) 
    {
        super(titulo, autor, nroPaginas, anoPublicacao);
        this.emprestado = false;
        this.dataDevolucao = "";
    }

    public String toString() 
    {
        return super.toString() + ", Emprestado: " + emprestado + ", Data de Devolução: " + dataDevolucao;
    }

    public boolean isAvailable() 
    {
        return !emprestado;
    }

    public void borrow(String dataDevolucao) 
    {
        if (isAvailable()) {
            this.emprestado = true;
            this.dataDevolucao = dataDevolucao;
            System.out.println("Livro emprestado com sucesso.");
        } else {
            System.out.println("Livro indisponível para empréstimo.");
        }
    }
}
