public class exLivros {
    public static void main(String[] args) {
        Livro livro1 = new Livro("Java: Como Programar", "Deitel & Deitel", 1200, 2018);
        System.out.println(livro1);
        System.out.println("É mais antigo que 2015? " + livro1.isOlder(2015));

        System.out.println();

        LivroBiblioteca livro2 = new LivroBiblioteca("Clean Code", "Robert C. Martin", 464, 2008);
        System.out.println(livro2);
        System.out.println("Está disponível para empréstimo? " + livro2.isAvailable());
        livro2.borrow("2023-06-15");
        System.out.println("Está disponível para empréstimo? " + livro2.isAvailable());

        System.out.println();

        LivroLivraria livro3 = new LivroLivraria("The Pragmatic Programmer", "Andrew Hunt & David Thomas", 352, 1999, 99.90, 5);
        System.out.println(livro3);
        System.out.println("Está disponível para venda? " + livro3.isAvailable());
        livro3.sell();
        System.out.println("Está disponível para venda? " + livro3.isAvailable());
    }
}

