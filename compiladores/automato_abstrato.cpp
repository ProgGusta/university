#include <bits/stdc++.h>

using namespace std;

int main() {
    int states_count;
    printf("Me diga o número de estados: ");
    scanf("%d", &states_count);

    int initial_state;
    printf("Digite o número do estado inicial, indexado de 0 a n - 1: ");
    scanf("%d", &initial_state);

    int alphabet_length;
    printf("Me diga o tamanho do alfabeto: ");
    scanf("%d", &alphabet_length);

    vector<char> alphabet(alphabet_length);
    printf("Digite o alfabeto (utilize apenas caracteres ingleses), cada caractere separado por um espaço: ");
    for (int i = 0; i < alphabet_length; i++)
        scanf(" %c", &alphabet[i]);  // Leitura de caracteres com espaçamento

    int final_states_count;
    printf("Me diga a quantidade de estados finais: ");
    scanf("%d", &final_states_count);

    vector<bool> final_states(states_count, false);
    printf("Me diga todos os estados finais, separados por espaço, indexados de 0 a n - 1: ");
    for (int i = 0; i < final_states_count; i++) {
        int aux;
        scanf("%d", &aux);
        if (aux >= 0 && aux < states_count) {
            final_states[aux] = true;
        } else {
            printf("Estado final inválido: %d\n", aux);
            return 1;
        }
    }

    vector<vector<int>> transitions(states_count, vector<int>(128, -1));
    printf("Agora, me diga a tabela de transição, onde as linhas são os estados e as colunas são caracteres do alfabeto:\n");
    for (int i = 0; i < states_count; i++) {
        for (int j = 0; j < alphabet_length; j++) {
            int trans;
            scanf("%d", &trans);
            if (trans >= 0 && trans < states_count) {
                transitions[i][alphabet[j]] = trans;
            } else {
                printf("Transição inválida: %d\n", trans);
                return 1;
            }
        }
    }

    // Exibindo a tabela de transições
    printf("\nTabela de Transições:\n");
    for (int i = 0; i < states_count; i++) {
        for (char c : alphabet) {
            printf("Estado %d, '%c' -> %d\n", i, c, transitions[i][c]);
        }
    }

    int tests_count;
    printf("Me diga quantos testes você quer fazer: ");
    scanf("%d", &tests_count);

    getchar();  // Para consumir o caractere de nova linha restante após o último scanf

    for (int i = 0; i < tests_count; i++) {
        printf("Me dê a palavra de entrada w: ");
        string input;
        getline(cin, input);

        int actual_state = initial_state;
        bool rejected = false;
        for (char c : input) {
            if (transitions[actual_state][c] == -1) {
                printf("Erro: Caractere '%c' não encontrado no alfabeto.\n", c);
                rejected = true;
                break;
            }
            actual_state = transitions[actual_state][c];
        }

        if (!rejected)
            printf("Veredito: %s\n", final_states[actual_state] ? "Aceitou" : "Rejeitou");
    }

    return 0;
}