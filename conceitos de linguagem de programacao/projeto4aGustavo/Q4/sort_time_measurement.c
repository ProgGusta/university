#include <stdio.h>
#include <stdlib.h>
#include <time.h>

// Funções de ordenação
void insertionSort(int arr[], int n) {
    for (int i = 1; i < n; i++) {
        int key = arr[i];
        int j = i - 1;
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j = j - 1;
        }
        arr[j + 1] = key;
    }
}

void bubbleSort(int arr[], int n) 
{
    for (int i = 0; i < n-1; i++) {
        for (int j = 0; j < n-i-1; j++) {
            if (arr[j] > arr[j+1]) {
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }
    }
}

void merge(int arr[], int l, int m, int r) {
    int n1 = m - l + 1;
    int n2 = r - m;
    int L[n1], R[n2];

    for (int i = 0; i < n1; i++)
        L[i] = arr[l + i];
    for (int j = 0; j < n2; j++)
        R[j] = arr[m + 1 + j];

    int i = 0, j = 0, k = l;
    while (i < n1 && j < n2) {
        if (L[i] <= R[j]) {
            arr[k] = L[i];
            i++;
        } else {
            arr[k] = R[j];
            j++;
        }
        k++;
    }
    while (i < n1) {
        arr[k] = L[i];
        i++;
        k++;
    }
    while (j < n2) {
        arr[k] = R[j];
        j++;
        k++;
    }
}

void mergeSort(int arr[], int l, int r) {
    if (l < r) {
        int m = l + (r - l) / 2;
        mergeSort(arr, l, m);
        mergeSort(arr, m + 1, r);
        merge(arr, l, m, r);
    }
}

void swap(int* a, int* b) {
    int t = *a;
    *a = *b;
    *b = t;
}

int partition(int arr[], int low, int high) {
    int pivot = arr[high];
    int i = (low - 1);
    for (int j = low; j < high; j++) {
        if (arr[j] < pivot) {
            i++;
            swap(&arr[i], &arr[j]);
        }
    }
    swap(&arr[i + 1], &arr[high]);
    return (i + 1);
}

void quickSort(int arr[], int low, int high) {
    if (low < high) {
        int pi = partition(arr, low, high);
        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
    }
}

// Gerar lista de números aleatórios
void generate_list(int* arr, int size) {
    for (int i = 0; i < size; i++) {
        arr[i] = rand() % 10000;
    }
}

// Medir tempo de execução para funções com dois parâmetros
double measure_sort_time_two(void (*sort_function)(int*, int), int* arr, int size) {
    clock_t start, end;
    start = clock();
    sort_function(arr, size);
    end = clock();
    return ((double) (end - start)) / CLOCKS_PER_SEC;
}

// Medir tempo de execução para funções com três parâmetros
double measure_sort_time_three(void (*sort_function)(int*, int, int), int* arr, int low, int high) {
    clock_t start, end;
    start = clock();
    sort_function(arr, low, high);
    end = clock();
    return ((double) (end - start)) / CLOCKS_PER_SEC;
}

int main() 
{
    int list_sizes[] = {10, 100, 1000, 10000, 100000, 1000000};
    int num_sizes = 6;
    FILE* results = fopen("c_sort_times.csv", "w");

    for (int i = 0; i < num_sizes; i++) {
        int size = list_sizes[i];
        int* arr = (int*)malloc(size * sizeof(int));
        generate_list(arr, size);

        fprintf(results, "%d,", size);
        double time = measure_sort_time_two(insertionSort, arr, size);
        fprintf(results, "%f,", time);

        generate_list(arr, size);
        time = measure_sort_time_two(bubbleSort, arr, size);
        fprintf(results, "%f,", time);

        generate_list(arr, size);
        time = measure_sort_time_three(mergeSort, arr, 0, size - 1);
        fprintf(results, "%f,", time);

        generate_list(arr, size);
        time = measure_sort_time_three(quickSort, arr, 0, size - 1);
        fprintf(results, "%f\n", time);

        free(arr);
    }

    fclose(results);
    return 0;
}