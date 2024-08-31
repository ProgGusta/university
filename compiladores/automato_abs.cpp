#include <iostream>
#include <fstream>
#include <sstream>
#include <vector>
#include <map>
#include <set>

using namespace std;

struct AFD 
{
    vector<string> estados;
    vector<char> alfabeto;
    map<pair<string, char>, string> transicoes;
    string estadoInicial;
    set<string> estadosFinais;
    string cadeia;

    bool processarCadeia() 
    {
        string estadoAtual = estadoInicial;
        for (char simbolo : cadeia) {
            pair<string, char> chave = make_pair(estadoAtual, simbolo);
            if (transicoes.find(chave) == transicoes.end()) {
                return false; // Transição inexistente, cadeia rejeitada
            }
            estadoAtual = transicoes[chave];
        }
        return estadosFinais.find(estadoAtual) != estadosFinais.end();
    }

    void mostrarAFD() const 
    {
        cout << "Estados: ";
        for (const string& estado : estados)
            cout << estado << " ";
        
        cout << endl;

        cout << "Alfabeto: ";
        for (char simbolo : alfabeto)
            cout << simbolo << " ";

        cout << endl;

        cout << "Transicoes:" << endl;
        for (const auto& transicao : transicoes)
            cout << transicao.first.first << " -- " << transicao.first.second << " --> " << transicao.second << endl;

        cout << "Estado inicial: " << estadoInicial << endl;

        cout << "Estados finais: ";
        for (const string& estadoFinal : estadosFinais)
            cout << estadoFinal << " ";

        cout << endl;
    }
};

AFD lerArquivoEntrada(string nomeArquivo) 
{
    AFD afd;
    ifstream arquivo(nomeArquivo);
    string linha;

    // Verifica se o arquivo foi aberto com sucesso
    if (!arquivo.is_open()) 
    {
        cerr << "Erro ao abrir o arquivo!" << endl;
        return afd;
    }

    // Leitura dos estados
    if (getline(arquivo, linha)) 
    {
        istringstream ss(linha);
        string estado;
        while (ss >> estado)
            afd.estados.push_back(estado);
    }

    // Leitura do alfabeto
    if (getline(arquivo, linha)) 
    {
        istringstream ss(linha);
        char simbolo;
        while (ss >> simbolo)
            afd.alfabeto.push_back(simbolo);
    }

    // Leitura das transições
    while (getline(arquivo, linha) && !linha.empty() && linha.find(' ') != string::npos) 
    {
        istringstream ss(linha);
        string estadoOrigem, estadoDestino;
        char simbolo;
        ss >> estadoOrigem >> simbolo >> estadoDestino;
        afd.transicoes[make_pair(estadoOrigem, simbolo)] = estadoDestino;
    }

    // Leitura do estado inicial
    if (!linha.empty())
        afd.estadoInicial = linha;

    // Leitura dos estados finais
    if (getline(arquivo, linha)) 
    {
        istringstream ss(linha);
        string estadoFinal;
        while (ss >> estadoFinal)
            afd.estadosFinais.insert(estadoFinal);
    }

    // Leitura da cadeia
    if (getline(arquivo, linha))
        afd.cadeia = linha;

    return afd;
}

int main() 
{
    AFD afd = lerArquivoEntrada("entrada.txt");

    // Mostrar os detalhes do AFD antes de processar a cadeia
    afd.mostrarAFD();

    // Processar a cadeia
    if (afd.processarCadeia())
        cout << "ACEITA" << endl;
    else
        cout << "REJEITA" << endl;

    return 0;
}