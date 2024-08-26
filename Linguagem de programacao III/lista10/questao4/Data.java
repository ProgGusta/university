package lista10.questao4;

import java.util.ArrayList;
import java.util.List;

public class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public String toString() {
        return dia + "/" + mes + "/" + ano;
    }
}


class Agenda {
    private List<Contato> contatos;

    public Agenda() {
        contatos = new ArrayList<>();
    }

    public void adicionarContato(Contato contato) {
        contatos.add(contato);
    }

    public void listarContatos() {
        for (Contato contato : contatos) {
            System.out.println(contato.toString() + "\n");
        }
    }

    public Contato buscarContatoPorCpf(String cpf) {
        for (Contato contato : contatos) {
            if (contato instanceof PessoaFisica) {
                PessoaFisica pessoaFisica = (PessoaFisica) contato;
                if (pessoaFisica.getCpf().equals(cpf)) {
                    return pessoaFisica;
                }
            }
        }
        return null;
    }

    public Contato buscarContatoPorCnpj(String cnpj) {
        for (Contato contato : contatos) {
            if (contato instanceof PessoaJuridica) {
                PessoaJuridica pessoaJuridica = (PessoaJuridica) contato;
                if (pessoaJuridica.getCnpj().equals(cnpj)) {
                    return pessoaJuridica;
                }
            }
        }
        return null;
    }
}