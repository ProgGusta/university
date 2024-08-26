#include <stdlib.h>
#include <time.h>
#include <stdio.h>

#define SIZE 1000
#define MAX 1024

// Função para ordenação por inserção
void ins_sort(int arr[], int n) {
    int i, key, j;
    for (i = 1; i < n; i++) {
        key = arr[i];
        j = i - 1;

        //mover elementos maiores
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j = j - 1;
        }
        arr[j + 1] = key;
    }
}

// Função para gerar vetor aleatório
void numRandom(int arr[], int n) 
{
    for (int i = 0; i < n; i++) 
        arr[i] = rand() % 1000;
}

int main() {
    srand(time(NULL)); //semente aleatória

    clock_t start, end;
    double cpu_time_used;
    
    // Arrays para armazenar os tempos de processamento
    double processing_times[MAX];

    for (int i = 0; i < MAX; i++) {
        int arr[SIZE];

        // Gerar vetor aleatório
        numRandom(arr, SIZE);

        // Registrar o tempo inicial
        start = clock();

        // Ordenar o vetor usando o algoritmo de ordenação por inserção
        ins_sort(arr, SIZE);

        // Registrar o tempo final
        end = clock();

        // Calcular o tempo de processamento em segundos
        cpu_time_used = ((double) (end - start)) / CLOCKS_PER_SEC;
        
        // Armazenar o tempo de processamento
        processing_times[i] = cpu_time_used;
    }

    // Imprimir os tempos de processamento
    printf("Tempo de Processamento:\n");
    for (int i = 0; i < MAX; i++) 
        printf("%.8f\n", processing_times[i]);

    return 0;
}