import java.lang.Math;

public class Cilindro extends Figura3D 
{
    public Cilindro(double raioBase, double altura) 
    {
        super(raioBase, altura);
    }

    @Override
    public void imprimirDados() 
    {
        super.imprimirDados();
        System.out.println("Tipo: Cilindro");
    }

    @Override
    public double calcularVolume() 
    {
        return Math.PI * Math.pow(raioBase, 2) * altura;
    }

    @Override
    public double calcularAreaSuperficial() 
    {
        return 2 * Math.PI * raioBase * (raioBase + altura);
    }
}