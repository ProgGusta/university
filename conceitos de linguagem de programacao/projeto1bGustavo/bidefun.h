#define SIZE 500

/*
    Functions:
        0. END
        1. LIT
        2. OPR
            2.1 - NEG
            2.2 - ADD
            2.3 - SUB
            2.4 - MUL
            2.5 - DIV
            2.6 - ODD
            2.7 - MOD
            2.8 - EQL
            2.9 - NEQ
            2.10 - LSS
            2.11 - LEQ
            2.12 - GTR
            2.13 - GEQ
        3. LOD
        4. STO
        5. CAL
        6. INC
        7. JMP
        8. JPC
        9. WRT
        10.
*/

typedef struct 
{
    int f;
    int l;
    int a;
}code;

void interpreter(code arr[]);
void soma();
void quadrado();
void cubo();