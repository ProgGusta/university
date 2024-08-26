package lista10.questao2;

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

    public double calculaEmprestimo() {
        return 1000.0;
    }

    public String toString() {
        return "Nome: " + nome + ", ID: " + id + ", Data de Nascimento: " + nascimento;
    }
}