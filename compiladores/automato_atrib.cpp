#include <iostream>
#include <ctype.h>

using namespace std;

enum estados
{
    q0,
    q1,
    q2,
    qf,
    qr
};

int existe(char c, estados estado);

enum estados direciona(char c, estados estado);

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

enum estados direciona(char c, estados estado)
{
    switch (estado)
    {
        case q0:
            if (isalpha(c))
                return q1;
            else
                return qr;
            break;
        case q1:
            if (isalpha(c))
                return q1;
            else if (c == '=')
                return q2;
            else
                return qr;
            break;
        case q2:
            if(isdigit(c))
                return qf;
            else
                return qr;
            break;
        case qf:
            if (isdigit(c))
                return qf;
            else
                return qr;
            break;
        case qr:
            return qr;
            break;
    }

    return qr;
}

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
        case q1:
            if (isalpha(c))
                return 1;
            else if (c == '=')
                return 1;
            else
                return 0;
            break;
        case q2:
            if(isdigit(c))
                return 1;
            else
                return 0;
            break;
        case qf:
            if (isdigit(c))
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