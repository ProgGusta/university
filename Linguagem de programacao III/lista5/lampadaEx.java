public class lampadaEx {
    public static void main(String[] args) {
        lampada ex1 = new lampada("azul", 200);
        ex1.mostraEstado();
        ex1.mostraNivel();

        lampada ex2 = new lampada("acesa", 95);
        ex2.mostraEstado();
        ex2.mostraNivel();
    }
}
