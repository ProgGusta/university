#include <stdio.h>

//Função de Ackerman
int ackerman(int m, int n) 
{
    if (m == 0) 
        return n + 1;
    else if (m > 0 && n == 0) 
        return ackerman(m - 1, 1);
    else if (m > 0 && n > 0) 
        return ackerman(m - 1, ackerman(m, n - 1));

    return 0; //Isso nunca deve ser alcançado
}

int main() 
{
    int m = 2, n = 3;
    printf("Ackerman(%d, %d) = %d\n", m, n, ackerman(m, n));
    return 0;
}