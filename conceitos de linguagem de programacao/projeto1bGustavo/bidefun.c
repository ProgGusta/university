#include <stdio.h> //entrada e saída
#include "bidefun.h" //struct dos dados

void interpreter(code arr[])
{
    int p=1; //pc pointer
    int t=0; //top of the stack
    int b=0; //base of the stack (RA)
    int i=0; //instruction number

    long long int stack[SIZE];
    stack[0] = 35;
    stack[1] = 36;
    stack[2] = 37;

    do
    {
        switch(arr[p].f)
        {
            case 0: //END
                p = stack[b];
                break;
            case 1: //LIT
                stack[t] = arr[p].a;
                p = p + 1;
                break;

            case 2: //OPR
                switch (arr[p].a)
                {
                    case 1: //NEG
                        stack[t] = stack[t] * -1;
                        p=p+1;
                        break;
                
                    case 2: //ADD
                        t = t-1;
                        stack[t] = stack[t] + stack[t+1];
                        p=p+1;
                        break;

                    case 3: //SUB
                        t=t-1;
                        stack[t] = stack[t] - stack[t+1];
                        p=p+1;
                        break;

                    case 4: //MUL
                        t=t-1;
                        stack[t] = stack[t] * stack[t+1];
                        p=p+1;
                        break;

                    case 5: //DIV (if possible)
                        t=t-1;
                        stack[t] = (stack[t+1] != 0) ? (stack[t]/stack[t+1]) : stack[t];
                        p=p+1;
                        break;

                    case 6: //ODD
                        stack[t] = stack[t] % 2;
                        p=p+1;
                        break;

                    case 7: //MOD
                        t=t-1;
                        stack[t] = stack[t] % stack[t+1];
                        p=p+1;
                        break;

                    case 8: //EQL
                        t=t-1;
                        stack[t] = (stack[t] == stack[t+1]);
                        p=p+1;
                        break;

                    case 9: //NEQ
                        t=t-1;
                        stack[t] = (stack[t] != stack[t+1]);
                        p=p+1;
                        break;

                    case 10: //LSS
                        t=t-1;
                        stack[t] = (stack[t] < stack[t+1]);
                        p=p+1;
                        break;

                    case 11: //LEQ
                        t=t-1;
                        stack[t] = (stack[t] <= stack[t+1]);
                        p=p+1;
                        break;

                    case 12: //GTR
                        t=t-1;
                        stack[t] = (stack[t] > stack[t+1]);
                        p=p+1;
                        break;

                    case 13: //GEQ
                        t=t-1;
                        stack[t] = (stack[t] >= stack[t+1]);
                        p=p+1;
                        break;
                }
                break;

            case 3: //LOD
                stack[t] = stack[arr[p].a];
                p=p+1;
                break;

            case 4: //STO
                stack[arr[p].a] = stack[t];
                p=p+1;
                break;

            case 5: //CAL
                stack[0] = 100; //RETURN ADDRESS
                stack[1] = SIZE; //DYNAMIC LINK
                stack[2] = 256; //STATIC LINK

                p = arr[p].a;
                break;

            case 6: //INC
                t = t+1;
                p=p+1;
                break;

            case 7: //JMP
                p = arr[p].a;
                break;

            case 8: //JPC
                if(!stack[t])
                    p=arr[p].a, t=t-1;
                else
                    p=p+1;
                break;

            case 9: //WRT
                printf("STACK[%d] = %lld", t, stack[t--]);
                break;

            case 10: //INT
                t = arr[p].a;
                p=p+1;
                break;
        }

        i++;
    } while (p != 35);

    printf("\tinstructions (i):\t%2d\n", i);
    printf("\tPC pointer (p):\t\t%2d\n", p);
    printf("\tBASE pointer (b):\t%2d\n", b);
    printf("\ttop of the stack (t):\t%2d\n", t);
    printf("\tstack positions:\n\t");
    for(int j=0; j<=t; j++)
        printf("\tarr[%d]: %lld ", j, stack[j]);
    printf("\n");

}

void soma()
{
    code arr[20];

    //0. END
    arr[0].f = 0;
    arr[0].l = 0;
    arr[0].a = 1;

    //1. topo da pilha alterado
    arr[1].f = 10;
    arr[1].l = 0;
    arr[1].a = 5;

    //2. setando o valor 1
    arr[2].f = 1;
    arr[2].l = 0;
    arr[2].a = 1;

    //3. copiando o valor incial
    arr[3].f = 4;
    arr[3].l = 0;
    arr[3].a = 3;

    //4. setando o valor 0
    arr[4].f = 1;
    arr[4].l = 0;
    arr[4].a = 0;

    //5. copiando o valor incial
    arr[5].f = 4;
    arr[5].l = 0;
    arr[5].a = 4;

    //6. carregando valor inicial para soma
    arr[6].f = 3;
    arr[6].l = 0;
    arr[6].a = 3;

    //7. opr add
    arr[7].f = 2;
    arr[7].l = 0;
    arr[7].a = 2;

    //7.5 inc topo
    arr[8].f = 6;
    arr[8].l = 0;
    arr[8].a = 0;

    //8. carregando valor inicial para incremento
    arr[9].f = 3;
    arr[9].l = 0;
    arr[9].a = 3;

    //8.5 inc topo
    arr[10].f = 6;
    arr[10].l = 0;
    arr[10].a = 0;

    //9. adicionando o outro operando
    arr[11].f = 1;
    arr[11].l = 0;
    arr[11].a = 1;

    //10. operando
    arr[12].f = 2;
    arr[12].l = 0;
    arr[12].a = 2;

    //11. salvando na posição
    arr[13].f = 4;
    arr[13].l = 0;
    arr[13].a = 3;

    //12. setando o 11
    arr[14].f = 1;
    arr[14].l = 0;
    arr[14].a = 11;

    //12.5 inc topo
    arr[15].f = 6;
    arr[15].l = 0;
    arr[15].a = 0;

    //13. setando a variavel
    arr[16].f = 3;
    arr[16].l = 0;
    arr[16].a = 3;

    //10. opr neg
    arr[17].f = 2;
    arr[17].l = 0;
    arr[17].a = 3;

    //11.jpc test
    arr[18].f = 8;
    arr[18].l = 0;
    arr[18].a = 0;

    //12. jmp
    arr[19].f = 7;
    arr[19].l = 0;
    arr[19].a = 6;

    printf("----------------------------------------------------------------------------------\n");
    printf("\tSoma de 1 a 10 na p-code:\n\n");

    interpreter(arr);

    printf("----------------------------------------------------------------------------------\n\n");
}

void quadrado()
{
    /*
        PS 3 = CONTADOR
        PS 4 = SOMADOR
        PS 5 = OP 1
        PS 6 = OP 2
        PS 7 = AUX
    */


    code arr[25];

    //0. END
    arr[0].f = 0;
    arr[0].l = 0;
    arr[0].a = 1;

    //1. topo da pilha alterado
    arr[1].f = 10;
    arr[1].l = 0;
    arr[1].a = 5;

    //2. setando o valor 1
    arr[2].f = 1;
    arr[2].l = 0;
    arr[2].a = 1;

    //3. copiando o valor cont
    arr[3].f = 4;
    arr[3].l = 0;
    arr[3].a = 3;

    //4. setando o valor 0
    arr[4].f = 1;
    arr[4].l = 0;
    arr[4].a = 0;

    //5. copiando o valor para somador
    arr[5].f = 4;
    arr[5].l = 0;
    arr[5].a = 4;

    //6. carregando valor para multiplicar
    arr[6].f = 3;
    arr[6].l = 0;
    arr[6].a = 3;

    //6.5 inc topo
    arr[7].f = 6;
    arr[7].l = 0;
    arr[7].a = 0;

    //7. carregando valor para multiplicar
    arr[8].f = 3;
    arr[8].l = 0;
    arr[8].a = 3;

    //8. operando mul
    arr[9].f = 2;
    arr[9].l = 0;
    arr[9].a = 4;

    //9. operando add
    arr[10].f = 2;
    arr[10].l = 0;
    arr[10].a = 2;

    //9.5 inc topo
    arr[11].f = 6;
    arr[11].l = 0;
    arr[11].a = 0;

    //10. carregando cont
    arr[12].f = 3;
    arr[12].l = 0;
    arr[12].a = 3;

    //10.5 inc topo
    arr[13].f = 6;
    arr[13].l = 0;
    arr[13].a = 0;

    //11. carregando o operando
    arr[14].f = 1;
    arr[14].l = 0;
    arr[14].a = 1;

    //12. operando add
    arr[15].f = 2;
    arr[15].l = 0;
    arr[15].a = 2;

    //13. save cont
    arr[16].f = 4;
    arr[16].l = 0;
    arr[16].a = 3;

    //14. carregando operando
    arr[17].f = 1;
    arr[17].l = 0;
    arr[17].a = 101;

    //14.5 inc topo
    arr[18].f = 6;
    arr[18].l = 0;
    arr[18].a = 0;

    //15. carregando cont
    arr[19].f = 3;
    arr[19].l = 0;
    arr[19].a = 3;

    //16. operando sub
    arr[20].f = 2;
    arr[20].l = 0;
    arr[20].a = 3;

    //17. jpc test
    arr[21].f = 8;
    arr[21].l = 0;
    arr[21].a = 0;

    //18. jmp
    arr[22].f = 7;
    arr[22].l = 0;
    arr[22].a = 6;

    printf("----------------------------------------------------------------------------------\n");
    printf("\tSoma dos quadrados de 1 a 100 na p-code:\n\n");

    interpreter(arr);

    printf("----------------------------------------------------------------------------------\n\n");
}

void cubo()
{
     /*
        PS 3 = CONTADOR
        PS 4 = SOMADOR
        PS 5 = OP 1
        PS 6 = OP 2
        PS 7 = OP 3
    */


    code arr[30];

    //0. END
    arr[0].f = 0;
    arr[0].l = 0;
    arr[0].a = 1;

    //1. topo da pilha alterado
    arr[1].f = 10;
    arr[1].l = 0;
    arr[1].a = 5;

    //2. setando o valor 1
    arr[2].f = 1;
    arr[2].l = 0;
    arr[2].a = 1;

    //3. copiando o valor cont
    arr[3].f = 4;
    arr[3].l = 0;
    arr[3].a = 3;

    //4. setando o valor 0
    arr[4].f = 1;
    arr[4].l = 0;
    arr[4].a = 0;

    //5. copiando o valor para somador
    arr[5].f = 4;
    arr[5].l = 0;
    arr[5].a = 4;

    //6. carregando valor para multiplicar
    arr[6].f = 3;
    arr[6].l = 0;
    arr[6].a = 3;

    //6.5 inc topo
    arr[7].f = 6;
    arr[7].l = 0;
    arr[7].a = 0;

    //7. carregando valor para multiplicar
    arr[8].f = 3;
    arr[8].l = 0;
    arr[8].a = 3;

    //7.5 inc topo
    arr[9].f = 6;
    arr[9].l = 0;
    arr[9].a = 0;

    //8. carregando valor para multiplicar
    arr[10].f = 3;
    arr[10].l = 0;
    arr[10].a = 3;

    //9. operando mul
    arr[11].f = 2;
    arr[11].l = 0;
    arr[11].a = 4;

    //10. operando mul
    arr[12].f = 2;
    arr[12].l = 0;
    arr[12].a = 4;

    //11. operando add
    arr[13].f = 2;
    arr[13].l = 0;
    arr[13].a = 2;

    //11.5 inc topo
    arr[14].f = 6;
    arr[14].l = 0;
    arr[14].a = 0;

    //12. carregando cont
    arr[15].f = 3;
    arr[15].l = 0;
    arr[15].a = 3;

    //12.5 inc topo
    arr[16].f = 6;
    arr[16].l = 0;
    arr[16].a = 0;

    //13. carregando o operando
    arr[17].f = 1;
    arr[17].l = 0;
    arr[17].a = 1;

    //14. operando add
    arr[18].f = 2;
    arr[18].l = 0;
    arr[18].a = 2;

    //15. save cont
    arr[19].f = 4;
    arr[19].l = 0;
    arr[19].a = 3;

    //16. carregando operando
    arr[20].f = 1;
    arr[20].l = 0;
    arr[20].a = 1001;

    //16.5 inc topo
    arr[21].f = 6;
    arr[21].l = 0;
    arr[21].a = 0;

    //17. carregando cont
    arr[22].f = 3;
    arr[22].l = 0;
    arr[22].a = 3;

    //18. operando sub
    arr[23].f = 2;
    arr[23].l = 0;
    arr[23].a = 3;

    //19. jpc test
    arr[24].f = 8;
    arr[24].l = 0;
    arr[24].a = 0;

    //20. jmp
    arr[25].f = 7;
    arr[25].l = 0;
    arr[25].a = 6;

    printf("----------------------------------------------------------------------------------\n");
    printf("\tSoma dos cubos de 1 a 1000 na p-code:\n\n");

    interpreter(arr);

    printf("----------------------------------------------------------------------------------\n\n");
}