/* Um dos jogos de azar mais populares é o jogo conhecido como Craps. Escreva
 * um programa em Java que simule o jogo de Craps.
 */

import java.util.Random;

public class craps {
  public static void main(String[] args) 
  {
    // função geradora de numeros aleatorios 
    Random random = new Random();

    // Variaveis que serão os dois dados do jogo
    int dado1, dado2;

    dado1 = random.nextInt(5) + 1; // gera um numero aleatorio de 1 a 6
    dado2 = random.nextInt(5) + 1; // e atribui ao dado 1 e 2

    // variavel que sera usado caso ocorra o segundo estágio
    int ponto; 

    System.out.println("Dado 1: " + dado1 + ", Dado 2: " + dado2); // print dados

    // Se soma for igual a 7 ou 11: ganhou
    if((dado1 + dado2) == 7 || (dado1 + dado2) == 11)
      System.out.println("Voce ganhou :-)");
    // se soma for igual a 2, 3 ou 12: perdeu
    else if((dado1 + dado2) == 2 || (dado1 + dado2) == 3 || (dado1 + dado2) == 12)
      System.out.println("Voce perdeu :-(");
    // caso contrario, entra no loop
    else 
    {
      //Atribuição do valor do ponto
      ponto = dado1 + dado2;
      int i = 1; // Contador de jogadas
      
      System.out.println("ponto: " + ponto); // print ponto
      System.out.println("iniciando estagio 2");

      //loop que se encerra ou quando vence ou perde
      while(true)
      {
        // Gerando novos valores aleatorios
        dado1 = random.nextInt(5) + 1;
        dado2 = random.nextInt(5) + 1;
        
        System.out.println("Dado 1: " + dado1 + ", Dado 2: " + dado2); // print dados
        System.out.println("Jogada " + i + ": " + (dado1 + dado2));

        // condiçoes de parada 
        if((dado1 + dado2) == ponto)
        {
          System.out.println("Voce ganhou :-)");
          break;
        }
        else if((dado1 + dado2) == 7)
        {
          System.out.println("Voce perdeu :-(");
          break;
        }

        i++; // incremento do contador
      }
    }
  }
}