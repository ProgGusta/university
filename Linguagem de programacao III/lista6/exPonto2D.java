public class exPonto2D {
    public static void main(String[] args) {
        Ponto2D ex1 = new Ponto2D(21, -74);
        ex1.printPonto();

        float diff = ex1.distance((float) 7.1, (float) 2.3);
        System.out.println("distancia :" + diff + "\n");

        diff = ex1.distance();
        System.out.println("distancia :" + diff + "\n");
    }
}
