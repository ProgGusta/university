package lista10.questao1;
import java.lang.Math;

public class Ponto2D {
    private int x;
    private int y;

    public Ponto2D() 
    {
        this.x = 0;
        this.y = 0;
    }

    public Ponto2D(int x, int y) 
    {
        this.x = x;
        this.y = y;
    }

    public Ponto2D(Ponto2D ponto) 
    {
        this.x = ponto.x;
        this.y = ponto.y;
    }

    public int getX()
    {
        return this.x;
    }

    public int getY()
    {
        return this.y;
    }

    public String toString() 
    {
        return "(" + x + ", " + y + ")";
    }

    public boolean inAxisX() 
    {
        return y == 0;
    }

    public boolean inAxisY() 
    {
        return x == 0;
    }

    public boolean inAxis() 
    {
        return inAxisX() || inAxisY();
    }

    public boolean isOrigin() 
    {
        return x == 0 && y == 0;
    }

    public double distance(int x, int y) 
    {
        return Math.sqrt(Math.pow((this.x - x), 2) + Math.pow((this.y - y), 2));
    }

    public double distance(Ponto2D ponto) 
    {
        return distance(ponto.x, ponto.y);
    }

}