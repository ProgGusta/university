package lista10.questao1;

public class Circle implements Shape2D
{
    private double raio;
    private Ponto2D centro;
    
    public Circle (double raio, int x, int y)
    {
        this.raio = raio;
        this.centro = new Ponto2D(x, y);
    }

    public Circle (Circle anterior)
    {
        this(anterior.getRaio(), anterior.getCentro().getX(), anterior.getCentro().getY());
    }

    public Circle()
    {
        this(1, 0, 0);
    }

    public double getRaio()
    {
        return this.raio;
    }

    public Ponto2D getCentro()
    {
        return this.centro;
    }

    @Override
    public double getArea()
    {
        return Math.PI * this.raio * this.raio;
    }   
    
    @Override
    public double getPerimetro()
    {
        return 2 * Math.PI * this.raio;
    }

    @Override
    public void desenha()
    {
        System.out.println("Desenhando circulo!!!\nRaio: " + this.getRaio() + "\nCoordenada x: " + this.getCentro().getX() + "\nCoordenada y: " + this.getCentro().getY());
    }
}
