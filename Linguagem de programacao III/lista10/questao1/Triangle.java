package lista10.questao1;

public class Triangle implements Shape2D
{
    private Ponto2D ponto1;
    private Ponto2D ponto2;
    private Ponto2D ponto3;

    public Triangle (int x, int y, int x2, int y2, int x3, int y3)
    {
        this.ponto1 = new Ponto2D(x, y);
        this.ponto2 = new Ponto2D(x2, y2);
        this.ponto3 = new Ponto2D(x3, y3);

        if (!isValidation(ponto3, ponto2, ponto1))
        {
            this.ponto1 = null;
            this.ponto2 = null;
            this.ponto3 = null;
        }
    }

    public Triangle (Triangle anterior)
    {
        this(anterior.getPonto(1).getX(), anterior.getPonto(1).getY(), anterior.getPonto(2).getX(), anterior.getPonto(2).getY(), anterior.getPonto(3).getX(), anterior.getPonto(3).getY());
    }

    public Triangle ( )
    {
        this(0,0,-1,-1,1,1);
    }

    public Ponto2D getPonto(int ponto)
    {
        if (ponto == 1)
            return this.ponto1;
        else if (ponto == 2)
            return this.ponto2;
        else if (ponto == 3)
            return this.ponto3;
        else
            return null;
    }

    private boolean isValidation(Ponto2D p1, Ponto2D p2, Ponto2D p3)
    {
        double p1p2 = Math.sqrt(((p1.getX() - p2.getX()) * (p1.getX() - p2.getX())) + ((p1.getY() - p2.getY()) * (p1.getY() - p2.getY())));
        double p1p3 = Math.sqrt(((p1.getX() - p3.getX()) * (p1.getX() - p3.getX())) + ((p1.getY() - p3.getY()) * (p1.getY() - p3.getY())));
        double p2p3 = Math.sqrt(((p2.getX() - p3.getX()) * (p2.getX() - p3.getX())) + ((p2.getY() - p3.getY()) * (p2.getY() - p3.getY())));

        if (p1p2 > Math.abs(p1p3 - p2p3) && p1p2 < (p1p3 + p2p3))
            return true;
        else if (p1p3 > Math.abs(p1p2 - p2p3) && p1p3 < (p1p2 + p2p3))
            return true;
        else if (p2p3 > Math.abs(p1p2 - p1p3) && p2p3 < (p1p2 + p1p3))
            return true;
        else 
            return false;
    }

    @Override
    public double getArea()
    {
        double p = this.getPerimetro() / 2.0; 
        double p1p2 = Math.sqrt(((this.ponto1.getX() - this.ponto2.getX()) * (this.ponto1.getX() - this.ponto2.getX())) + ((this.ponto1.getY() - this.ponto2.getY()) * (this.ponto1.getY() - this.ponto2.getY())));
        double p1p3 = Math.sqrt(((this.ponto1.getX() - this.ponto3.getX()) * (this.ponto1.getX() - this.ponto3.getX())) + ((this.ponto1.getY() - this.ponto3.getY()) * (this.ponto1.getY() - this.ponto3.getY())));
        double p2p3 = Math.sqrt(((this.ponto2.getX() - this.ponto3.getX()) * (this.ponto2.getX() - this.ponto3.getX())) + ((this.ponto2.getY() - this.ponto3.getY()) * (this.ponto2.getY() - this.ponto3.getY())));

        return Math.sqrt((p * (p - p1p2) * (p - p1p3) * (p - p2p3)));
    }   
    
    @Override
    public double getPerimetro()
    {
        double p1p2 = Math.sqrt(((this.ponto1.getX() - this.ponto2.getX()) * (this.ponto1.getX() - this.ponto2.getX())) + ((this.ponto1.getY() - this.ponto2.getY()) * (this.ponto1.getY() - this.ponto2.getY())));
        double p1p3 = Math.sqrt(((this.ponto1.getX() - this.ponto3.getX()) * (this.ponto1.getX() - this.ponto3.getX())) + ((this.ponto1.getY() - this.ponto3.getY()) * (this.ponto1.getY() - this.ponto3.getY())));
        double p2p3 = Math.sqrt(((this.ponto2.getX() - this.ponto3.getX()) * (this.ponto2.getX() - this.ponto3.getX())) + ((this.ponto2.getY() - this.ponto3.getY()) * (this.ponto2.getY() - this.ponto3.getY())));

        return (p1p2 + p1p3 + p2p3);
    }
    
    @Override
    public void desenha()
    {
        System.out.println("Desenhando triangulo!!\nPonto 1: (" + this.getPonto(1).getX() + ", " + this.getPonto(1).getY() + ")\nPonto 2: (" + this.getPonto(2).getX() + ", " + this.getPonto(2).getY() + ")\nPonto 3: (" + this.getPonto(3).getX() + ", " + this.getPonto(3).getY() + ")");
    }
}
