public class Circulo{    
    private int x; // abscissa do centro
    private int y; // ordenada do centro
    private int raio; // raio do circulo

    // Construtores
    public Circulo() // sem parâmetros
    { 
        this.x = 0;
        this.y = 0;
        this.raio = 1;
    }

    public Circulo(int x, int y) // dois parâmetros
    { 
        this.x = x;
        this.y = y;
        this.raio = 1;
    }

    public Circulo(int x, int y, int raio) // três parâmetros
    { 
        if (isValidation(raio)) {
            this.raio = raio;
        } else {
            this.raio = 0;
        }
        this.x = x;
        this.y = y;
    }

    public Circulo(int raio) // um parâmetro
    { 
        if (isValidation(raio)) 
            this.raio = raio;
        else 
            this.raio = 0;

        this.x = 0;
        this.y = 0;
    }

    // Valida círculo
    private boolean isValidation(int raio) 
    {
        if (raio < 1) 
            return false;
        else
            return true;
        
    }

    // Inserir novos valores
    public void setCircle(int x, int y, int raio) {
        if (isValidation(raio)) {
            this.raio = raio;
        } else {
            this.raio = 0;
        }
        this.x = x;
        this.y = y;
    }

    // Obter valores
    public void getCircle() {
        System.out.println("Coordenada x do centro: " + this.x + "\nCoordenada y do centro: " + this.y +
                            "\nRaio do circulo: " + this.raio);
    }

    // Verificar se o ponto está dentro do círculo
    public boolean isInnerPoint(Ponto2D ponto) 
    {
        float eixoX = ponto.getX();
        float eixoY = ponto.getY();
        double k, d;
        k = (double) (this.x - eixoX) * (this.x - eixoX) + (double) (this.y - eixoY) * (this.y - eixoY);
        d = Math.sqrt(k);
        if (d <= raio)
            return true;
        else
            return false;
    }

    // Calcular área do círculo
    public double area() 
    {
        double area = Math.PI * Math.pow(this.raio, 2);
        return area;
    }

    // Calcular perímetro do círculo
    public double perimeter() 
    {
        double perimetro = 2 * Math.PI * this.raio; 
        return perimetro;
    }

    // Comparar tamanhos de círculos
    public boolean isBiggerThan(Circulo outroCirculo) {
        if (this.raio > outroCirculo.getRaio())
            return true;
        else 
            return false;
    }

    // Getters
    public int getX() 
    {
        return x;
    }

    public int getY() 
    {
        return y;
    }

    public int getRaio()
    {
        return raio;
    }
}