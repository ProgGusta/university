
public class exUnidadeDePesoUtils {
    public static void main(String[] args) {
        double pesoEmGramas = 1000.0;

        double pesoEmQuilogramas = UnidadeDePesoUtils.gramasParaQuilogramas(pesoEmGramas);
        System.out.println("Peso em Quilogramas: " + pesoEmQuilogramas);

        double pesoEmLibras = UnidadeDePesoUtils.gramasParaLibras(pesoEmGramas);
        System.out.println("Peso em Libras: " + pesoEmLibras);

        double pesoEmOunces = UnidadeDePesoUtils.gramasParaOunces(pesoEmGramas);
        System.out.println("Peso em Onças: " + pesoEmOunces);

    }
}
