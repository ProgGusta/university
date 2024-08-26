public class exPonto3Da {
    public static void main(String[] args) 
    {
        Ponto3Da ponto1 = new Ponto3Da();  
        System.out.println(ponto1);  
        System.out.println(ponto1.inAxisX());
        System.out.println(ponto1.inAxisY());  
        System.out.println(ponto1.inAxisZ());  
        System.out.println(ponto1.inAxis());  
        System.out.println(ponto1.isOrigin());  

        Ponto2D ponto2D = new Ponto2D(3, 4);
        Ponto3Da ponto2 = new Ponto3Da(ponto2D, 5);  
        System.out.println(ponto2); 
        System.out.println(ponto2.inAxisX()); 
        System.out.println(ponto2.inAxisY());  
        System.out.println(ponto2.inAxisZ()); 
        System.out.println(ponto2.inAxis());  
    }
}
