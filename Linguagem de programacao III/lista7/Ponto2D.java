public class Ponto2D{    
    private float x;
    private float y;

    public Ponto2D(int x, int y) 
    {
        this.x = x;
        this.y = y;
    }

    public Ponto2D() 
    {
        this(0, 0);
    }

    public float getX() 
    {
        return this.x;
    }

    public float getY() 
    {
        return this.y;
    }

    public void printPonto()
    {
        System.out.println("Eixo X: " + x + "\nEixo Y: " + y);
    }

    private boolean isX() 
    {
        return this.y == 0;
    }

    private boolean isY() 
    {
        return this.x == 0;
    }

    private boolean isEixo() 
    {
        return isX() || isY();
    }

    public int quadrante() {
        if (isEixo()) {
            return 0;
        } else if (this.x > 0 && this.y > 0) {
            return 1;
        } else if (this.x < 0 && this.y > 0) {
            return 2;
        } else if (this.x < 0 && this.y < 0) {
            return 3;
        } else {
            return 4;
        }
    }

    public float distance(Ponto2D outroPonto) 
    {
        return (float) Math.sqrt(Math.pow(outroPonto.getX() - this.x, 2) + Math.pow(outroPonto.getY() - this.y, 2));
    }
    
    public float distance() 
    {
        return distance(new Ponto2D(0, 0));
    }
    
    public float distance(float x, float y) 
    {
        return (float) Math.sqrt(Math.pow(x - this.x, 2) + Math.pow(y - this.y, 2));
    }
}