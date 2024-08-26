public class lampadaEx {
    public static void main(String[] args) {
        //inicio
        lampada ex1 = new lampada();

        //ligando e mostrando o estado
        ex1.on();
        if(ex1.estado())
            ex1.mostraEstado();

        //ajudando a luminosidade
        ex1.luminous(111);
        ex1.luminous(48);
        ex1.mostraNivel();
    }
}
