#include <stdio.h>
#include <limits.h>
#include <string.h>

int main(int argc, char *argv[]){

    if(argc != 3)
    {
        printf("Falta de Argumentos");
        return 0;
    }

    FILE *fp, *fp2;

    char argument[100];
    int valor;

    fp = fopen(argv[1], "r");
    fp2 = fopen(argv[2], "w");

    if(fp == NULL)
    {
        printf("file not found");
        return 0;
    }
    
    while(!feof(fp))
    {
        valor = INT_MAX;

        fscanf(fp, "PUSH(%d)\n", &valor);
        if(valor != INT_MAX)
            fprintf(fp2, "LIT 0 %d\n", valor);
        
        strcpy(argument, "inf");
        fscanf(fp, "y=POP(); x=POP(); PUSH(x %s y)\n", argument);
        if(!strcmp(argument, "ADD"))
            fprintf(fp2, "OPR 0 2\n");
        else if(!strcmp(argument, "SUB"))
            fprintf(fp2, "OPR 0 3\n");
        else if(!strcmp(argument, "MUL"))
            fprintf(fp2, "OPR 0 4\n");
        else if(!strcmp(argument, "DIV"))
            fprintf(fp2, "OPR 0 5\n");
    }
    
    fclose(fp);
    fclose(fp2);
    return 0;
}