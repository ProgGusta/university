digit[0-9]
letter[a-zA-Z]
ID[a-zA-Z][a-zA-Z0-9]*
WHITESPACE[ ]
quebra[\n]
TAB[\t]
OP_SUM[+]
CM_ATR[=]

%{
    //Questão 7 já com as melhorias propostas na aula

    #define YY_DECL extern "C" int yylex()
    #include <stdio.h>
%}

%%

[1-9]{digit}* fprintf(yyout, "%s - number greater than zero", yytext);
[0]+ fprintf(yyout, "%s - number equal to zero", yytext);
[-{digit}]{digit}* fprintf(yyout, "%s - number less than zero", yytext);
{letter}{letter}* fprintf(yyout, "%s - identifier", yytext);
{OP_SUM} fprintf(yyout, "%s - sum operator", yytext);
{CM_ATR} fprintf(yyout, "%s - assignment command", yytext);

%%

int yywrap() {
    return 1;
}

int main(int argc, char **argv)
{
    if (argc > 1) {
        // Abrir o arquivo de entrada
        yyin = fopen(argv[1], "r");
        if (!yyin) {
            fprintf(stderr, "Não foi possível abrir o arquivo de entrada %s\n", argv[1]);
            return 1;
        }
    }

    if (argc > 2) {
        // Abrir o arquivo de saída
        yyout = fopen(argv[2], "w");
        if (!yyout) {
            fprintf(stderr, "Não foi possível abrir o arquivo de saída %s\n", argv[2]);
            return 1;
        }
    }

    yylex();

    if (yyin) fclose(yyin);
    if (yyout) fclose(yyout);

    return 0;
}
