public class exPonto2D {
    public static void main(String[] args) {
        Ponto2D P1 = new Ponto2D(3, 4);
        Ponto2D P2 = new Ponto2D(6, 8);
        Ponto2D P3 = new Ponto2D(-2, -2);

        float dist1 = Ponto2DUtils.distance(P1, P2);
        System.out.println("Distância entre P1 e P2: " + dist1);

        float dist2 = Ponto2DUtils.distance(P3);
        System.out.println("Distância entre P3 e a origem: " + dist2);

        int quad1 = Ponto2DUtils.quadrant(P1);
        System.out.println("Quadrante de P1: " + quad1);

        int quad2 = Ponto2DUtils.quadrant(P3);
        System.out.println("Quadrante de P3: " + quad2);
    }
}
