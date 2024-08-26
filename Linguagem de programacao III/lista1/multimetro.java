/* 
 * Multímetro quebrado? Uma equipe de manutenção elétrica deve determinar se o multímetro disponível
 * opera corretamente. Para isso devem realizar 10 medições de voltagem em um circuito de corrente
 * direta criado para testes. Em seguida devem calcular a média o desvio padrão das leituras. Se o desvio
 * padrão for superior a 10% do valor médio, o multímetro está com problemas e não pode ser utilizado.
 * Crie um programa que processe os dados das leituras e informe se o multímetro se encontra
 * operacional. Seu programa deve imprimir no final todas as leituras, o valor médio o desvio padrão e
 * uma mensagem informando o estado do dispositivo.
 * Instruções:
 * • Os dados de entrada podem ser fixos para fins de teste, lidos via teclado, ou lidos de um arquivo
 * texto com formato livre.
 * • As expressões para cálculo da média e o desvio padrão devem ser obtidas da literatura acadêmica
 * ou Google.
 */

import java.util.Scanner;

public class multimetro 
{
    public static void main(String[] args) 
    {
        // Ler entradas do teclado 
        Scanner input = new Scanner(System.in);

        // Variavel para armazenar as voltagens
        double volt[] = new double[10];

        // Variavel de controle
        int i;
        System.out.println("Teste de multimetro");

        //Obtenção dos valores de entrada
        for(i=0; i < 10; i++)
        {
            System.out.println("Entre com o valor da voltagem " + i);
            volt[i] = input.nextDouble(); 
        }

        // Variavel para guardar a media
        double media = 0.0d;

        // Somatorio das voltagens 
        for(i=0; i < 10; i++)
        {
            media += volt[i];
        }
        
        // Media calculada 
        media /= 10.0d;

        double Despad = 0.0d;
        //Somatorio para desvio
        for(i=0; i < 10; i++)
        {
            Despad += ((volt[i] - media) * (volt[i] - media));
        }

        // Desvio padrão 
        Despad = Math.sqrt(Despad/10.0d);

        // Decisão: se está funcionando
        if(Despad > (media * 0.1f))
        {
            System.out.printf("Desvio padrao: " + Despad + "\nMedia: " + media + "\n");
            System.out.println("Valor do desvio superior a 10% ao valor da media");
        }
        else
        {
            System.out.printf("Desvio padrao: " + Despad + "\nMedia: " + media + "\n");
            System.out.println("Valor do desvio inferior  a 10% ao valor da media");
        }

        input.close();
    }   
}
