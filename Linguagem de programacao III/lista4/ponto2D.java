public class ponto2D {
    private int x = 0;
    private int y = 0;

    public void printPonto()
    {
        System.out.println("eixo X: " + x + "\neixo Y: " + y);
    }

    private boolean isX()
    {
        if (this.y == 0)
            return true;
        else
            return false;
    }

    private boolean isY()
    {
        if (this.x == 0)
            return true;
        else 
            return false; 
    }

    private boolean isEixo()
    {
        if(isX() || isY())
            return true;
        else
            return false;
    }

    public void setPonto(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int quadrante()
    {
        if (isEixo())
            return 0;
        else if (this.x > 0 && this.y > 0)
            return 1;
        else if (this.x < 0 && this.y > 0)
            return 2;
        else if(this.x < 0 && this.y < 0)
            return 3;
        else 
            return 4;
    }

    public void distancia(int x, int y)
    {
        double k, d;
        k = (double) (this.x - x) * (this.x - x) + (double) (this.y - y) * (this.y - y);
        d = Math.sqrt(k);

        System.out.println("A distancia entre os pontos é " + d + ".");
    }
}
