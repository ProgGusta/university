/*
    Aluno: Gustavo Barreto dos Santos Costa
    Matéria: Conceitos de Linguagens de Programação
    Professor: César Alberto Bravo Pariente
*/

#include <stdio.h>
#include <string.h>

// verifica digito da vez
#define digt(c) ((c == '0') || (c == '1') || (c == '2') || (c == '3') || (c == '4') || (c == '5') || (c == '6') || (c == '7') || (c == '8') || (c == '9'))
#define MAX_LINE_LENGTH 100 // Tamanho máximo da linha

// função main
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

    int len, i = -1; // control variables
    char linha[MAX_LINE_LENGTH]; // guarda a linha
    int word = 1; // quantidade de palavras
    
    // Lê e imprime as linhas até o final do arquivo
    while (fgets(linha, MAX_LINE_LENGTH, arquivo) != NULL) 
    {
        // tam string
        len = strlen(linha);

        // retirando \n da leitura
        len--;

        printf("==============================================================================================\n");

        // estado inicial
        Q0:
            i++;

            if(digt(linha[i]))
                goto Q1;
            else
                goto REJECT;

        // estado de aceitação
        Q1:
            i++;
            if(i >= len)
            {
                i=-1, printf("\t%3d - %s", word, linha);
                printf("\tCADEIA RECONHECIDA\n");
                goto END;
            }

            if(digt(linha[i]))
                goto Q1;
            else
                goto REJECT;

        // estado de rejeiçao
        REJECT:
            i = -1, printf("\t%3d - %s", word, linha);
            printf("\tCADEIA RECUSADA!\n");

        // fim ou preparação para a proxima
        END:
            printf("==============================================================================================\n");
            word ++;
    }

    // Fecha o arquivo
    fclose(arquivo);

    return 0;
}