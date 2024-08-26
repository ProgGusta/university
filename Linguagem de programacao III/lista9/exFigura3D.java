public class exFigura3D {
    public static void main(String[] args) {
        Cilindro cilindro = new Cilindro(5.0, 10.0);
        cilindro.imprimirDados();
        System.out.println("Volume: " + cilindro.calcularVolume());
        System.out.println("Área Superficial: " + cilindro.calcularAreaSuperficial());

        System.out.println();

        Cone cone = new Cone(3.0, 7.0);
        cone.imprimirDados();
        System.out.println("Volume: " + cone.calcularVolume());
        System.out.println("Área Superficial: " + cone.calcularAreaSuperficial());
    }
}
