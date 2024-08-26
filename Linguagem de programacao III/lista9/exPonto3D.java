public class exPonto3D {
    public static void main(String[] args) {
        Ponto3D ponto1 = new Ponto3D();  // Ponto na origem (0, 0, 0)
        System.out.println(ponto1);  // Saída: (0, 0), 0
        System.out.println(ponto1.inAxisX());  // Saída: true
        System.out.println(ponto1.inAxisY());  // Saída: true
        System.out.println(ponto1.inAxisZ());  // Saída: true
        System.out.println(ponto1.inAxis());  // Saída: true
        System.out.println(ponto1.isOrigin());  // Saída: true

        Ponto3D ponto2 = new Ponto3D(3, 4, 5);  // Ponto na posição (3, 4, 5)
        System.out.println(ponto2);  // Saída: (3, 4), 5
        System.out.println(ponto2.inAxisX());  // Saída: false
        System.out.println(ponto2.inAxisY());  // Saída: false
        System.out.println(ponto2.inAxisZ());  // Saída: false
        System.out.println(ponto2.inAxis());  // Saída: false
        System.out.println(ponto2.isOrigin());  // Saída: false

        Ponto2D ponto = new Ponto2D(3, 4); 
        Ponto3D ponto3 = new Ponto3D(ponto, 0); 
        System.out.println(ponto3);  
        System.out.println(ponto3.distance(7, 2, 1));  
        System.out.println(ponto3.distance(ponto1)); 
    }
}
