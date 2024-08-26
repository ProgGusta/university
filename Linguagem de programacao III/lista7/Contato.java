public class Contato {
    private String nome;
    private String telefone;
    private String email;
    private static int totalContatos; // atributo estático para armazenar o total de contatos

    public Contato(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        totalContatos++; // incrementa o total de contatos ao criar um novo objeto Contato
    }

    // getters e setters

    public static int getTotalContatos() {
        return totalContatos;
    }

    public static void mostrarTotalContatos() {
        System.out.println("Total de contatos: " + totalContatos);
    }
}