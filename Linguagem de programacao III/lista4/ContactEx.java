public class ContactEx {
    public static void main(String[] args) {
        Contato ex1 = new Contato();
        ex1.contactRun("Gustavo Barreto", "gbscosta.cic@uesc.br", "(73)991103123", 23, 12, 2001);
        ex1.ContactPrint();
        ex1.calculateAge();
    }
}
