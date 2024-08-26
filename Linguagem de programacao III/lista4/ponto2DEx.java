public class ponto2DEx {
    public static void main(String[] args) {
        ponto2D ex1 = new ponto2D();

        ex1.setPonto(5, 12);
        ex1.printPonto();
        System.out.println("Quadrante: " + ex1.quadrante());
        ex1.distancia(-7, 12);
    }
}
