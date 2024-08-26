public class lampada
{
    private String lampada = "apagada";
    private int lightBulb = 0;

    //Construtor
    public lampada(String estado, int luminous)
    {
        if ((estado == "apagada" || estado == "acesa"))
            lampada = estado;            
        else 
            System.out.println("Estado inválido!!");
        
        if (luminous < 0 || luminous > 100)
            System.out.println("luminosidade não permitida!!");
        else 
            lightBulb = luminous;
    }

    //retorna true se lampada está acesa 
    public boolean estado()
    {
        if (lampada == "acesa")
            return true;
        else 
            return false;
    }

    //printa o estado da lampada 
    public void mostraEstado()
    {
        if (lampada == "acesa")
            System.out.println("A lampada está acesa");
        else
            System.out.println("A lmapada está apagada");
    }

    //liga a lampada
    public void on()
    {
        lampada = "acesa"; 
    }

    //desliga a lampada
    public void off()
    {
        lampada = "apagada";
    }

    //muda o nivel da luminosidade da lampada 2
    public void luminous(int nivel)
    {
        if (nivel >= 0 && nivel <= 100)
            this.lightBulb = nivel;
        else
        {
            System.out.println("Valor inválido!!");
            this.lightBulb = 0;
        }
    }

    //printa o nivel da lampada 2
    public void mostraNivel()
    {
        System.out.println("A lampada está com a luminosidade em " + lightBulb + "%.");
    }
}