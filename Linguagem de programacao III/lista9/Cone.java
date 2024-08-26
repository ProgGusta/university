import java.lang.Math;

public class Cone extends Figura3D 
{
    public Cone(double raioBase, double altura) 
    {
        super(raioBase, altura);
    }

    @Override
    public void imprimirDados() 
    {
        super.imprimirDados();
        System.out.println("Tipo: Cone");
    }

    @Override
    public double calcularVolume() 
    {
        return (1.0 / 3.0) * Math.PI * Math.pow(raioBase, 2) * altura;
    }

    @Override
    public double calcularAreaSuperficial() 
    {
        double geratriz = Math.sqrt(Math.pow(raioBase, 2) + Math.pow(altura, 2));
        return Math.PI * raioBase * (raioBase + geratriz);
    }
}