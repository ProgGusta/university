public class exPonto3Dh {
    public static void main(String[] args) 
    {
        Ponto3Dh ponto1 = new Ponto3Dh();  
        System.out.println(ponto1);  
        System.out.println(ponto1.inAxisX());  
        System.out.println(ponto1.inAxisY()); 
        System.out.println(ponto1.inAxisZ()); 
        System.out.println(ponto1.inAxis()); 
        System.out.println(ponto1.isOrigin());  

        Ponto3Dh ponto2 = new Ponto3Dh(3, 4, 5); 
        System.out.println(ponto2);  
        System.out.println(ponto2.inAxisX());  
        System.out.println(ponto2.inAxisY());  
        System.out.println(ponto2.inAxis()); 
        System.out.println(ponto2.isOrigin());  

        Ponto3Dh ponto3 = new Ponto3Dh(ponto2.getX(), ponto2.getY(), 0); 
        System.out.println(ponto3);  
        System.out.println(ponto3.distance(7, 2, 1)); 
        System.out.println(ponto3.distance(ponto1));  
    }
}
