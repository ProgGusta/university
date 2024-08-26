package lista10.questao1;

public class teste {
    public static void main(String[] args) {
        Shape2D ex1 = new Circle(2, 0, 0);
        Shape2D ex2 = new Square(5, 0, 0);
        Shape2D ex3 = new Rectangle(0, 0, 5, 5);
        Shape2D ex4 = new Triangle(0, 0, 1, 1, -1, -1);

        ex1.desenha();
        ex2.desenha();
        ex3.desenha();
        ex4.desenha();
    }
}
