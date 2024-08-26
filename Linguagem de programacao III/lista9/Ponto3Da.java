import java.lang.Math;

public class Ponto3Da {
    private Ponto2D ponto2Da;
    private int z;

    public Ponto3Da() {
        this.ponto2Da = null;
        this.z = 0;
    }

    public Ponto3Da(int x, int y, int z) {
        this.ponto2Da = new Ponto2D(x, y);
        this.z = z;
    }

    public Ponto3Da(Ponto2D ponto2D, int z) {
        this.ponto2Da = ponto2D;
        this.z = z;
    }

    public String toString() {
        return ponto2Da.toString() + ", " + z;
    }

    public boolean inAxisX() {
        return ponto2Da != null && ponto2Da.inAxisX() && z == 0;
    }

    public boolean inAxisY() {
        return ponto2Da != null && ponto2Da.inAxisY() && z == 0;
    }

    public boolean inAxisZ() {
        return ponto2Da == null && z != 0;
    }

    public boolean inAxis() {
        return (ponto2Da != null && ponto2Da.inAxis()) || inAxisZ();
    }

    public boolean isOrigin() {
        return ponto2Da == null && z == 0;
    }

    public double distance(int x, int y, int z) {
        if (ponto2Da != null) {
            return Math.sqrt(Math.pow((ponto2Da.getX() - x), 2) + Math.pow((ponto2Da.getY() - y), 2) + Math.pow((this.z - z), 2));
        } else {
            return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow((this.z - z), 2));
        }
    }

    public double distance(Ponto3Da ponto) 
    {
        return distance(ponto.ponto2Da.getX(), ponto.ponto2Da.getY(), ponto.z);
    }
}