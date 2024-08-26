public class circuloEx {
    public static void main(String[] args) {
        ponto2D ex = new ponto2D(15, 10);
        circulo ex1 = new circulo(12, 11, 8);

        if(ex1.isInnerPoint(ex))
            ex1.getCircle();

        if(ex1.isBiggerThan(6))
        {
            float area = ex1.areaCircle();
            float perimetro = ex1.perimeter();
            System.out.println("Area: " + area + "\nperimetro: " + perimetro);
        }
    }
}
