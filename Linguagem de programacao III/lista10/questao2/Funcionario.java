package lista10.questao2;
import java.util.Date;

public class Funcionario extends Pessoa {
    private Date admissao;
    private double salario;

    public Funcionario(String nome, long id, Date nascimento, Date admissao, double salario) {
        super(nome, id, nascimento);
        this.admissao = admissao;
        this.salario = salario;
    }

    @Override
    public double calculaEmprestimo() {
        double valorMinimo = 1000.0;
        double valorEmprestimo = Math.max(salario * 0.75, valorMinimo);
        return valorEmprestimo;
    }

    public String qualSalario() {
        return "Salário: " + salario;
    }

    public String toString() {
        return super.toString() + ", Admissão: " + admissao;
    }
}
