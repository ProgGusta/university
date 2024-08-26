package lista10.questao4;

public class AgendaApp {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();

        // Adicionar contatos
        PessoaFisica pessoaFisica1 = new PessoaFisica("João", "Rua A", "123456789", "joao@email.com",
                "111.111.111-11", new Data(1, 1, 2000));
        PessoaJuridica pessoaJuridica1 = new PessoaJuridica("Empresa A", "Rua B", "987654321", "empresa@email.com",
                "12345678901234", 1000000.0);

        agenda.adicionarContato(pessoaFisica1);
        agenda.adicionarContato(pessoaJuridica1);

        // Listar contatos
        agenda.listarContatos();

        // Buscar contato por CPF
        String cpf = "111.111.111-11";
        Contato contatoCPF = agenda.buscarContatoPorCpf(cpf);
        if (contatoCPF != null) {
            System.out.println("Contato encontrado:\n" + contatoCPF.toString());
        } else {
            System.out.println("Contato com CPF " + cpf + " não encontrado.");
        }

        // Buscar contato por CNPJ
        String cnpj = "12345678901234";
        Contato contatoCNPJ = agenda.buscarContatoPorCnpj(cnpj);
        if (contatoCNPJ != null) {
            System.out.println("Contato encontrado:\n" + contatoCNPJ.toString());
        } else {
            System.out.println("Contato com CNPJ " + cnpj + " não encontrado.");
        }
    }
}

