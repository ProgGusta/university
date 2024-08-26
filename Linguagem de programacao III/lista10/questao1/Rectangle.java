package lista10.questao1;

public class Rectangle implements Shape2D
{
    private Ponto2D infEsq;
    private Ponto2D supDir;

    public Rectangle (int x, int y, int supX, int supY)
    {
        this.infEsq = new Ponto2D(x, y);
        this.supDir = new Ponto2D(supX, supY);
    }

    public Rectangle (Ponto2D inf, Ponto2D sup)
    {
        this(inf.getX(), inf.getY(), sup.getX(), sup.getY());
    }

    public Rectangle ()
    {
        this(0, 0, 1, 1);
    }

    public Ponto2D getInferior()
    {
        return this.infEsq;
    }

    public Ponto2D getSuperior()
    {
        return this.supDir;
    }

    @Override
    public double getArea()
    {
        return Math.abs(infEsq.getY() - supDir.getY()) * Math.abs(infEsq.getX() - supDir.getX());
    }   
    
    @Override
    public double getPerimetro()
    {
        return (2 * Math.abs(infEsq.getY() - supDir.getY())) * (2 * Math.abs(infEsq.getX() - supDir.getX()));
    }

    @Override
    public void desenha()
    {
        System.out.println("Desenhando retangulo!!\nPonto inferior esquerdo: (" + this.getInferior().getX() + ", " + this.getInferior().getY() + 
                            ")\nPonto superior direito: (" + this.getSuperior().getX() + ", " + this.getSuperior().getY() + ")");
    }
}
