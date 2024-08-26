/*
    Aluno: Gustavo Barreto dos Santos Costa
    Matéria: Conceitos de Linguagens de Programação
    Professor: César Alberto Bravo Pariente
*/

#include <stdio.h>
#include <string.h>

#define MAX_LINE_LENGTH 100 // Tamanho máximo da linha
#define MAX_SIZE 1024 // tamanho da pilha do autômato
#define PMAX_SIZE 128 // tamanho da pilha resultante

char stack[MAX_SIZE];
char Pstack[PMAX_SIZE];

int top = -1; //top of the stack
int ins = 0; //number of instructions
int Ptop = -1; //top of the Pstack
int i = 0; // pointer line
char linha[MAX_LINE_LENGTH]; // guarda a linha
int len; // // control variables

void impressArv()
{
    printf("\n\n\t\tARVORE P\n\n");

    printf("\t\tS\t\n\n");
    for(int j=1; j<=Ptop; j++)
    {
        if(Pstack[j] == 'c')
            printf("\t\tc\t\n");
        else
            printf("\t%c", Pstack[j]);

        if(!(j % 3))
            printf("\n\n");
    }

    printf("\n");
}

void impress(int options)
{
    if(len <= 5)
        printf("\t");

    for(int a=0; a<strlen(linha)-1; a++)
        if(a == i)
            printf(".%c", linha[a]);
        else
            printf("%c", linha[a]);
    printf("\t|");

    if(top == 0)
        printf("\t%c\t", stack[top]);
    else if(top < 3)
    {
        printf("\t");
        for(int a=0; a<=top;a++)
            printf("%c", stack[a]);
        printf("\t");
    }
    else if(top > 0)
    {
        printf("\t");
        for(int a=0; a<=top;a++)
            printf("%c", stack[a]);
        printf("\t");
    }
    else
        printf("\t-\t");

    if(options == 1)
        printf("| s1 | P1 |\n");
    else if(options == 2)
        printf("| s2 | P2 |\n");
    else if(options == 3)
        printf("| s3 |  - |\n");
    else if(options == 4)
        printf("| s4 |  - |\n");
    else if(options == 5)
        printf("| s5 |  - |\n");
    else
        printf("|  - |  - |\n");
}

int main(int argc, char *argv[])
{
    // verifica quantidade de parametros
    if(argc != 2)
    {
        printf("Uso: %s <nome_do_arquivo>\n", argv[0]);
        return 1;
    }

    // ponteiro para o arquivo
    FILE *arquivo;

    // Abre o arquivo para leitura
    arquivo = fopen(argv[1], "r");

    //verifica se leitura foi bem sucedida
    if (arquivo == NULL) 
    {
        printf("Erro ao abrir o arquivo.\n");
        return 1;
    }

    int word = 1; // quantidade de palavras
    int flag = 0;
    
    // Lê e imprime as linhas até o final do arquivo
    while (fgets(linha, MAX_LINE_LENGTH, arquivo) != NULL) 
    {
        // tam string
        len = strlen(linha);

        // retirando \n da leitura
        if(linha[len-1] == '\n')
            len--;
          

        printf("| i  | q  |\tw\t|\tstack\t| Si | Pi |\n");

        // estado inicial
        Q0:
            printf("| %2d | q0 |", ins++);
            if(len <= 5)
                printf("\t");

            for(int a=0; a<len; a++)
                if(a == i)
                    printf(".%c", linha[a]);
                else
                    printf("%c", linha[a]);
            printf("\t|\tS\t| S0 |  - |\n");

            stack[++top] = 'S', Pstack[++Ptop] = 'S';
            goto Q1;

        // estado de aceitação
        Q1:
            if(i >= len)
                goto END;

            if(top >= 0)
            {
                if(stack[top] == 'S')
                {
                    if(linha[i] == 'a')
                    {
                        printf("| %2d | q1 |", ins++);
                        impress(1);

                        stack[top++] = 'b', stack[top++] = 'S', stack[top] = 'a';
                        Pstack[++Ptop] = 'b', Pstack[++Ptop] = 'S', Pstack[++Ptop] = 'a';
                    }
                    else if(linha[i] == 'c' && !flag)
                    {
                        printf("| %2d | q1 |", ins++);
                        impress(2);

                        stack[top] = 'c';
                        Pstack[++Ptop] = 'c';
                        flag = 1;
                    }
                    else 
                        goto REJECT;

                    goto Q1;
                }
                else if(stack[top] == 'a' && linha[i] == 'a')
                {
                    printf("| %2d | q1 |", ins++);
                    impress(3);
                    
                    top--, i++;
                    goto Q1;
                }
                else if(stack[top] == 'b' && linha[i] == 'b')
                {
                    printf("| %2d | q1 |", ins++);
                    impress(4);

                    top--, i++;
                    goto Q1;
                }
                else if(stack[top] == 'c' && linha[i] == 'c')
                {
                    printf("| %2d | q1 |", ins++);
                    impress(5);

                    top--, i++;
                    goto Q1;
                }
                else
                    goto REJECT;
                    
            }
            else
                goto REJECT;

        // estado de rejeiçao
        REJECT:
            printf("\t%3d - %s", word++, linha);
            printf("\tCADEIA RECUSADA!\n");
            printf("===========================================================================================================\n\n");
            goto CONTINUE;

        // fim ou preparação para a proxima
        END:
            if(top >= 0)
                goto REJECT;

            printf("| %2d |  - |", ins);
            if(len <= 5)
                printf("\t");
                
            for(int a=0; a<len; a++)
                if(a == i)
                    printf(".%c", linha[a]);
                else
                    printf("%c", linha[a]);

            printf("\t|\t-\t|  - |  - |\n");
            impressArv();
            printf("\t%3d - %s", word++, linha);
            printf("\tCADEIA ACEITA!\n");
            printf("===========================================================================================================\n\n");

        CONTINUE:
            Ptop=-1, flag=0, top=-1, i=0, ins=0;
    }

    // Fecha o arquivo
    fclose(arquivo);

    return 0;
}