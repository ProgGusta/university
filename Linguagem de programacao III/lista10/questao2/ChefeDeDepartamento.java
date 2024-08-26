package lista10.questao2;
import java.util.Date;

public class ChefeDeDepartamento extends Funcionario {
    private String departamento;
    private Date promocaoChefe;

    public ChefeDeDepartamento(String nome, long id, Date nascimento, Date admissao, double salario, String departamento, Date promocaoChefe) {
        super(nome, id, nascimento, admissao, salario);
        this.departamento = departamento;
        this.promocaoChefe = promocaoChefe;
    }

    @Override
    public double calculaEmprestimo() {
        double valorEmprestimo = super.calculaEmprestimo();
        return valorEmprestimo * 3;
    }

    public String getDepartamento() {
        return "Departamento: " + departamento;
    }

    public String toString() {
        return super.toString() + ", Departamento: " + departamento + ", Promoção do Chefe: " + promocaoChefe;
    }
}