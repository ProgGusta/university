import java.lang.Math;

public class Ponto3D {
    private Ponto2D ponto2D;
    private int z;

    public Ponto3D() 
    {
        this.ponto2D = new Ponto2D();
        this.z = 0;
    }

    public Ponto3D(int x, int y, int z) 
    {
        this.ponto2D = new Ponto2D(x, y);
        this.z = z;
    }

    public Ponto3D(Ponto2D ponto2D, int z) 
    {
        this.ponto2D = ponto2D;
        this.z = z;
    }

    public String toString() 
    {
        return ponto2D.toString() + ", " + z;
    }

    public boolean inAxisX() 
    {
        return ponto2D.inAxisX() && z == 0;
    }

    public boolean inAxisY() 
    {
        return ponto2D.inAxisY() && z == 0;
    }

    public boolean inAxisZ() 
    {
        return ponto2D.isOrigin() && z != 0;
    }

    public boolean inAxis() 
    {
        return ponto2D.inAxis() && z == 0;
    }

    public boolean isOrigin() 
    {
        return ponto2D.isOrigin() && z == 0;
    }

    public double distance(int x, int y, int z) 
    {
        return Math.sqrt(Math.pow((ponto2D.getX() - x), 2) + Math.pow((ponto2D.getY() - y), 2) + Math.pow((this.z - z), 2));
    }

    public double distance(Ponto3D ponto) 
    {
        return distance(ponto.ponto2D.getX(), ponto.ponto2D.getY(), ponto.z);
    }
}

