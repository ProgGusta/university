public class exContato {
    public static void main(String[] args) {
        Contato contato1 = new Contato("João", "123456789", "joao@example.com");
        Contato contato2 = new Contato("Maria", "987654321", "maria@example.com");
        Contato contato3 = new Contato("Carlos", "555555555", "carlos@example.com");

        Contato.mostrarTotalContatos(); // exibe o número de contatos na tela
    }
}
