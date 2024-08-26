import java.lang.Math;

public class Ponto3Dh extends Ponto2D {
    private int z;

    public Ponto3Dh() 
    {
        super();
        this.z = 0;
    }

    public Ponto3Dh(int x, int y, int z) 
    {
        super(x, y);
        this.z = z;
    }

    public String toString() 
    {
        return "(" + getX() + ", " + getY() + ", " + z + ")";
    }

    public boolean inAxisZ() 
    {
        return getX() == 0 && getY() == 0 && z != 0;
    }

    public boolean inAxis() 
    {
        return super.inAxis() || inAxisZ();
    }

    public boolean isOrigin() 
    {
        return super.isOrigin() && z == 0;
    }

    public double distance(int x, int y, int z) 
    {
        return Math.sqrt(Math.pow((getX() - x), 2) + Math.pow((getY() - y), 2) + Math.pow((this.z - z), 2));
    }

    public double distance(Ponto3Dh ponto) 
    {
        return distance(ponto.getX(), ponto.getY(), ponto.z);
    }

}
