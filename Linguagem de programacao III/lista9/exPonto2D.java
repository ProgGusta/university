public class exPonto2D {
    public static void main(String[] args) {
        Ponto2D ponto1 = new Ponto2D(); 
        System.out.println(ponto1);  
        System.out.println(ponto1.inAxisX()); 
        System.out.println(ponto1.inAxisY());  
        System.out.println(ponto1.inAxis());  
        System.out.println(ponto1.isOrigin());  

        Ponto2D ponto2 = new Ponto2D(3, 4); 
        System.out.println(ponto2);  
        System.out.println(ponto2.inAxisX());  
        System.out.println(ponto2.inAxisY());  
        System.out.println(ponto2.inAxis());  
        System.out.println(ponto2.isOrigin()); 

        Ponto2D ponto3 = new Ponto2D(ponto2); 
        System.out.println(ponto3);  
        System.out.println(ponto3.distance(7, 2)); 
        System.out.println(ponto3.distance(ponto1)); 
    }
}
