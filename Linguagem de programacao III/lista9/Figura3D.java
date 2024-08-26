class Figura3D {
    protected double raioBase;
    protected double altura;

    public Figura3D(double raioBase, double altura) {
        this.raioBase = raioBase;
        this.altura = altura;
    }

    public void imprimirDados() {
        System.out.println("Raio da base: " + raioBase);
        System.out.println("Altura: " + altura);
    }

    public double calcularVolume() {
        return 0; // Implementação será feita nas subclasses
    }

    public double calcularAreaSuperficial() {
        return 0; // Implementação será feita nas subclasses
    }
}