public class Ponto2DUtils {
    public static float distance(Ponto2D P1, Ponto2D P2) 
    {
        float dx = P2.getX() - P1.getX();
        float dy = P2.getY() - P1.getY();
        return (float) Math.sqrt(dx * dx + dy * dy);
    }

    public static float distance(Ponto2D P) 
    {
        return (float) Math.sqrt((float) (P.getX() * P.getX() + P.getY() * P.getY()));
    }

    public static int quadrant(Ponto2D P) 
    {
        return P.quadrante();
    }
}