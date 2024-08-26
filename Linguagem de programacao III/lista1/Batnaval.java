/* Jogo de Batalha Naval. Desenvolva um programa em Java que seja uma recriação do Jogo Batalha
 * Naval, nele dois jogadores escolherão os locais dos navios em um tabuleiro e tentarão afundar os navios
 * do outro jogador escolhendo as coordenadas para atirar. O jogador que primeiro afundar todos os navios
 * do oponente ganha o Jogo. 
 */

import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;

public class Batnaval 
{
    public static void main(String[] args) 
    {
        // variaveis de controle
        int i, j;
        int linha, coluna;
        boolean control;

        // Declaração dos arrays player 1 / player 2
        char[][] player1 = new char[5][5];
        char[][] player2 = new char[5][5];
        char[][] Hitplayer1 = new char[5][5];
        char[][] Hitplayer2 = new char[5][5];

        // preenchimento de todas as posições com o caracter '-'
        for(i = 0; i<5; i++)
            for(j = 0; j < 5; j++)
            {
                player1[i][j] = '-';
                player2[i][j] = '-';
                Hitplayer1[i][j] = '-';
                Hitplayer2[i][j] = '-';
            }

        System.out.println("Welcome to battleship!!");
        System.out.println("Comece inserindo as coordenadas dos navios\nserao cinco, insira dos numeros inteiro separados\npor um espaco menores que cinco, o primeiro referente a linha\n e o segundo a coluna onde o navio vai estar posicionado");
        System.out.println("Comecaremos pelo player 1");

        // variavel para obter entradas do teclado 
        Scanner input = new Scanner(System.in);

        // coordenadas dos navios do jogador 1
        for(i = 0; i < 5; i++)
        {
            // controle das entradas de valores do usuario
            do{
                control = false;
                System.out.printf("Digite as coordenadas do navio %d: ", i);
                linha = input.nextInt();
                coluna = input.nextInt();
                if(linha > 4 || linha < 0 || coluna > 4 || coluna < 0)
                    System.out.println("Coordenada invalida. Digite novamente");
                else if(player1[linha][coluna] == '@')
                {
                    System.out.println("Coordenada ja selecionada. Escolha outra");
                    control = true;
                }
            }while(linha > 4 || linha < 0 || coluna > 4 || coluna < 0 || control);
            
            // atribuição da coordenada
            player1[linha][coluna] = '@';
        }

        System.out.println("\n\nAgora as coordenadas do player 2");

        // coordenadas dos navios do jogador 2
        for(i = 0; i < 5; i++)
        {
            // controle das entradas de valores do usuario
            do{
                control = false;
                System.out.printf("Digite as coordenadas do navio %d: ", i);
                linha = input.nextInt();
                coluna = input.nextInt();
                if(linha > 4 || linha < 0 || coluna > 4 || coluna < 0)
                    System.out.println("Coordenada invalida. Digite novamente");
                else if(player2[linha][coluna] == '@')
                {
                    System.out.println("Coordenada ja selecionada. Escolha outra");
                    control = true;
                }
            }while(linha > 4 || linha < 0 || coluna > 4 || coluna < 0 || control);
            
            // atribuição da coordenada
            player2[linha][coluna] = '@';
        }

        System.out.println("Vamos começar o jogo!!");

        // variaveis contadoras de navios derrubados
        int point1 = 0;
        int point2 = 0;

        // repetição de procedimentos até existir um vencedor
        while(true)
        {
            System.out.println("Player 1 digite uma coordenada:");

            // controle das entradas de valores do usuario
            do{
                control = false;
                linha = input.nextInt();
                coluna = input.nextInt();
                if(linha > 4 || linha < 0 || coluna > 4 || coluna < 0)
                    System.out.println("Coordenada invalida. Digite novamente");
                else if(Hitplayer1[linha][coluna] != '-')
                {
                    System.out.println("Coordenada ja selecionada. Escolha outra");
                    control = true;
                }
            }while(linha > 4 || linha < 0 || coluna > 4 || coluna < 0 || control);

            // Verificação de coordenada
            if(player2[linha][coluna] == '@')
            {
                point1++;
                Hitplayer1[linha][coluna] = 'X';
                System.out.println("Player1 hit player2's ship!!!");
                System.out.println("\t1\t2\t3\t4\t5\n");
                for(i=0;i<5;i++)
                    System.out.println(i+1 + "\t" + Hitplayer1[i][0] + "\t" + Hitplayer1[i][1] + "\t" + Hitplayer1[i][2] + "\t" + Hitplayer1[i][3] + "\t" + Hitplayer1[i][4]);
            }
            else
            {
                Hitplayer1[linha][coluna] = 'O';
                System.out.println("Player 1 MISSED!!");
                System.out.println("\t1\t2\t3\t4\t5\n");
                for(i=0;i<5;i++)
                    System.out.println(i+1 + "\t" + Hitplayer1[i][0] + "\t" + Hitplayer1[i][1] + "\t" + Hitplayer1[i][2] + "\t" + Hitplayer1[i][3] + "\t" + Hitplayer1[i][4]);
            }

            // verificação de vitoria
            if(point1 == 5)
            {
                System.out.println("PLAYER 1 WINS! YOU SUNK ALL OF YOUR OPPONENT'S SHIPS!");
                System.out.println("Final boards");

                // painel do vencedor
                System.out.println("\t1\t2\t3\t4\t5\n");
                for(i=0;i<5;i++)
                    System.out.println(i+1 + "\t" + Hitplayer1[i][0] + "\t" + Hitplayer1[i][1] + "\t" + Hitplayer1[i][2] + "\t" + Hitplayer1[i][3] + "\t" + Hitplayer1[i][4]);
                
                // painel do derrotado
                System.out.println("\t1\t2\t3\t4\t5\n");
                for(i=0;i<5;i++)
                    System.out.println(i+1 + "\t" + Hitplayer2[i][0] + "\t" + Hitplayer2[i][1] + "\t" + Hitplayer2[i][2] + "\t" + Hitplayer2[i][3] + "\t" + Hitplayer2[i][4]);

                break;
            }

            // vez do player 2 jogar
            System.out.println("Agora, player 2 digite uma coordenada:");

            // controle das entradas de valores do usuario
            do{
                control = false;
                linha = input.nextInt();
                coluna = input.nextInt();
                if(linha > 4 || linha < 0 || coluna > 4 || coluna < 0)
                    System.out.println("Coordenada invalida. Digite novamente");
                else if(Hitplayer2[linha][coluna] != '-')
                {
                    System.out.println("Coordenada ja selecionada. Escolha outra");
                    control = true;
                }
            }while(linha > 4 || linha < 0 || coluna > 4 || coluna < 0 || control);

            // Verificação de coordenada
            if(player1[linha][coluna] == '@')
            {
                point2++;
                Hitplayer2[linha][coluna] = 'X';
                System.out.println("Player1 hit player2's ship!!!");
                System.out.println("\t1\t2\t3\t4\t5\n");
                for(i=0;i<5;i++)
                    System.out.println(i+1 + "\t" + Hitplayer2[i][0] + "\t" + Hitplayer2[i][1] + "\t" + Hitplayer2[i][2] + "\t" + Hitplayer2[i][3] + "\t" + Hitplayer2[i][4]);
            }
            else
            {
                Hitplayer2[linha][coluna] = 'O';
                System.out.println("Player 1 MISSED!!");
                System.out.println("\t1\t2\t3\t4\t5\n");
                for(i=0;i<5;i++)
                    System.out.println(i+1 + "\t" + Hitplayer2[i][0] + "\t" + Hitplayer2[i][1] + "\t" + Hitplayer2[i][2] + "\t" + Hitplayer2[i][3] + "\t" + Hitplayer2[i][4]);
            }

            // verificação de vitoria
            if(point2 == 5)
            {
                System.out.println("PLAYER 2 WINS! YOU SUNK ALL OF YOUR OPPONENT'S SHIPS!");
                System.out.println("Final boards");

                // painel do vencedor
                System.out.println("\t1\t2\t3\t4\t5\n");
                for(i=0;i<5;i++)
                    System.out.println(i+1 + "\t" + Hitplayer2[i][0] + "\t" + Hitplayer2[i][1] + "\t" + Hitplayer2[i][2] + "\t" + Hitplayer2[i][3] + "\t" + Hitplayer2[i][4]);
                
                // painel do derrotado
                System.out.println("\t1\t2\t3\t4\t5\n");
                for(i=0;i<5;i++)
                    System.out.println(i+1 + "\t" + Hitplayer1[i][0] + "\t" + Hitplayer1[i][1] + "\t" + Hitplayer1[i][2] + "\t" + Hitplayer1[i][3] + "\t" + Hitplayer1[i][4]);
                
                break;
            }
        }
        input.close();   
    }
}
