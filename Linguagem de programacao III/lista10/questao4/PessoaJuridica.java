package lista10.questao4;

public class PessoaJuridica extends Contato {
    private String cnpj;
    private double faturamento;

    public PessoaJuridica(String nome, String endereco, String telefone, String email, String cnpj, double faturamento) {
        super(nome, endereco, telefone, email);
        this.cnpj = cnpj;
        this.faturamento = faturamento;
    }

    public String toString() {
        return super.toString() + "\nCNPJ: " + cnpj + "\nFaturamento: " + faturamento;
    }

    public String getCnpj() {
        return cnpj;
    }
}