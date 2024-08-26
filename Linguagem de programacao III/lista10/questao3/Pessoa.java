package lista10.questao3;
import java.util.Date;

class Pessoa {
    private String nome;
    private long id;
    private Date nascimento;

    public Pessoa(String nome, long id, Date nascimento) {
        this.nome = nome;
        this.id = id;
        this.nascimento = nascimento;
    }

    public Pessoa(String nome2) 
    {
        this.nome = nome2;
    }

    public double calculaEmprestimo() {
        return 1000.0;
    }

    public String toString() {
        return "Nome: " + nome + ", ID: " + id + ", Data de Nascimento: " + nascimento;
    }
} 
    

