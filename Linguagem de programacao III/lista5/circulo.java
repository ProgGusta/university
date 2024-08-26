public class circulo {
    
    private int x; //abscissa do centro
    private int y; //ordenada do centro
    private int raio; //raio do circulo

    //construtor
    public circulo(int x, int y, int raio)
    {
        if(isValidation(raio))
            this.raio = raio;
        else 
            raio = 0;

        this.x = x;
        this.y = y;
    }

    //valida circulo
    private boolean isValidation(int raio)
    {
        if (raio < 1)
            return false;
        else 
            return true;
    }

    //inserir novos valores
    public void setCircle(int x, int y, int raio)
    {
        if(isValidation(raio))
            this.raio = raio;
        else 
            raio = 0;

        this.x = x;
        this.y = y;
    }

    //get 
    public void getCircle()
    {
        System.out.println("coordenada x do centro: " + this.x + "\ncoordenada y do centro: " + this.y +
                            "\nraio do circulo: " + this.raio);
    }

    //se o ponto estiver dentro do circulo retorna verdadeiro
    public boolean isInnerPoint(ponto2D ex1)
    {
        int eixoX = ex1.getX();
        int eixoY = ex1.getY();

        double k, d;
        k = (double) (this.x - eixoX) * (this.x - eixoX) + (double) (this.y - eixoY) * (this.y - eixoY);
        d = Math.sqrt(k);

        if (d <= raio)
            return true;
        else
            return false;
    }

    //area do circulo
    public float areaCircle()
    {
        float area = (float) ((this.raio * this.raio) * Math.PI);
        return area;
    }

    //perimetro do circulo
    public float perimeter()
    {
        float perimetro = (float) (2 * this.raio * Math.PI); 
        return perimetro;
    }

    //qual circulo é maior
    public boolean isBiggerThan (int raio)
    {
        if (this.raio > raio)
            return true;
        else 
            return false;
    }
}
