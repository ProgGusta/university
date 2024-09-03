#include <iostream>
#include <ctype.h>

using namespace std;

enum estados
{
    q0,
    qf,
    qr
};

int existe(char c, estados estado)
{
    switch (estado)
    {
        case q0:
            if (isalpha(c))
                return 1;    
            else 
                return 0;
            break;
        case qf:
            if (isalpha(c) || isdigit(c))
                return 1;
            else
                return 0;
            break;
        case qr:
            return 0;
            break;
    }
    
    return 0;
}

enum estados direciona(char c, estados estado)
{
    switch (estado)
    {
        case q0:
            if (isalpha(c))
                return qf;
            break;
        case qf:
            if (isalpha(c) || isdigit(c))
                return qf;
            break;
        case qr:
            return qr;
            break;
    }

    return qr;
}

int main(void)
{
    estados estado = q0;
    char c;
    cout << "Digite uma sequencia de caracteres: ";

    while (cin.get(c))
    {
        if (c == '\n')
            break;
        
        cout << "Caracter lido: " << c << " - " <<  " estado atual: " << (estado == 0 ? "q0" : "qf") << " - ";

        if(existe(c, estado))
            estado = direciona(c, estado);
        else
        {
            estado = qr;
            break;
        }

        cout << "estado apos tratamento do caracter: " << (estado == 0 ? "q0" : "qf") << endl;
    }

    if(estado == qf)
        cout << "Palavra aceita!" << endl;
    else
        cout << "Palavra rejeitada!" << endl;

    return 0;
}