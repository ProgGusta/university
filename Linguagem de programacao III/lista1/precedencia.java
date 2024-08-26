public class precedencia 
{
    public static void main(String[] args) 
    {
        /*  * / %	Multiplicação Divisão Resto	Avaliado primeiro. Se houver vários operadores desse tipo serão avaliados da esquerda para a direita
         *  + -	    Adição Subtração	Avaliado em seguida. Se houver vários operadores desse tipo, serão avaliados da esquerda para a direita.
         *  =	    Atribuição	Avaliado por último 
         *          O que está dentro do parenteses tem maior precedencia de resolução 
         */

        int a = 30;
        int b = 5;
        int c = 10;
        int total = (a + b + c) / 10;
        System.out.println("O resultado = "+total);
    }
}
