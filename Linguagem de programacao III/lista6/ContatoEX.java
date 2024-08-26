public class ContatoEX {
    public static void main(String[] args) {
        Contato ex1 = new Contato("Gustavo", "gbscosta.cic@uesc.br", "(73)991919191");
        ex1.ContactPrint();

        Contato ex2 = new Contato("Gustavo");
        ex2.ContactPrint();
    }
}
