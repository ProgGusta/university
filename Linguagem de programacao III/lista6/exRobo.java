public class exRobo {
    public static void main(String[] args) {
        RoboSimples ex1 = new RoboSimples();
        ex1.move(3, null);
        String aux = ex1.toString();
        System.out.println(aux);

        ex1.move(12, "NE");
        aux = ex1.toString();
        System.out.println(aux);
    }
}
