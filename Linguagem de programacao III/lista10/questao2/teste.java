package lista10.questao2;

import java.util.Date;

public class teste {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa("João", 1, new Date());
        Funcionario funcionario = new Funcionario("Maria", 2, new Date(), new Date(), 2000.0);
        ChefeDeDepartamento chefe = new ChefeDeDepartamento("Carlos", 3, new Date(), new Date(), 3000.0, "TI", new Date());

        System.out.println("Empréstimo para pessoa: " + pessoa.calculaEmprestimo());
        System.out.println("Empréstimo para funcionário: " + funcionario.calculaEmprestimo());
        System.out.println("Empréstimo para chefe de departamento: " + chefe.calculaEmprestimo());
    }
}
