package lista10.questao4;

public class PessoaFisica extends Contato {
    private String cpf;
    private Data dataAniversario;

    public PessoaFisica(String nome, String endereco, String telefone, String email, String cpf, Data dataAniversario) {
        super(nome, endereco, telefone, email);
        this.cpf = cpf;
        this.dataAniversario = dataAniversario;
    }

    public String toString() {
        return super.toString() + "\nCPF: " + cpf + "\nData de Aniversário: " + dataAniversario.toString();
    }

    public String getCpf() {
        return cpf;
    }
}