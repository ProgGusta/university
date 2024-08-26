public class Circuloex {
    public static void main(String[] args) {
        Circulo circulo1 = new Circulo(5, 5, 3);
        circulo1.getCircle(); // Exibir as informações do círculo

        Circulo circulo2 = new Circulo();
        circulo2.getCircle(); // Exibir as informações do círculo

        Circulo circulo3 = new Circulo(5, 5);
        circulo3.getCircle(); // Exibir as informações do círculo

        Circulo circulo4 = new Circulo(5);
        circulo4.getCircle(); // Exibir as informações do círculo
    }
}
