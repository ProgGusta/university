package lista10.questao1;

public class Square implements Shape2D
{
    private Ponto2D infEsq;
    private double aresta;

    public Square(double aresta, int x, int y)
    {
        this.infEsq = new Ponto2D(x, y);
        this.aresta = aresta;
    }

    public Square (Square anterior)
    {
        this(anterior.getAresta(), anterior.getInferior().getX(), anterior.getInferior().getY());
    }

    public Square ()
    {
        this(1, 0, 0); 
    }

    public double getAresta()
    {
        return this.aresta;
    }

    public Ponto2D getInferior()
    {
        return this.infEsq;
    }

    @Override
    public double getArea()
    {
        return this.aresta * this.aresta;
    }   
    
    @Override
    public double getPerimetro()
    {
        return 4 * this.aresta;
    }
    
    @Override
    public void desenha()
    {
        System.out.println("Desenhando Quadrado!!\nPonto inferior esquerdo: (" + this.getInferior().getX() + ", " + this.getInferior().getY() + ")\nAresta: " + this.aresta);
    }
}
