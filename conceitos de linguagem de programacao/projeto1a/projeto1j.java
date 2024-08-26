import java.util.Random;

public class projeto1j {
    static final int SIZE = 100;
    static final int ITERATIONS = 1024;

    // Função para ordenação por inserção
    static void insertionSort(int arr[]) 
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i) 
        {
            int key = arr[i];
            int j = i - 1;

            //Move elementos maiores
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    // Função para gerar vetor aleatório
    static void generateRandomArray(int[] arr) 
    {
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) 
            arr[i] = rand.nextInt(1000); // Números aleatórios entre 0 e 999
    }

    public static void main(String[] args) 
    {
        double[] processingTimes = new double[ITERATIONS];

        for (int i = 0; i < ITERATIONS; i++) {
            int[] arr = new int[SIZE];

            // Gerar vetor aleatório
            generateRandomArray(arr);

            long startTime = System.nanoTime();

            // Ordenar o vetor usando o algoritmo de ordenação por inserção
            insertionSort(arr);

            long endTime = System.nanoTime();

            // Calcular o tempo de processamento em segundos
            double cpuTimeUsed = (endTime - startTime) / 1e9; // Convertendo para segundos

            // Armazenar o tempo de processamento
            processingTimes[i] = cpuTimeUsed;
        }

        // Imprimir os tempos de processamento
        System.out.println("Tempos de processamento:");
        for (int i = 0; i < ITERATIONS; i++) 
            System.out.printf("%.8f\n", processingTimes[i]); 
    }
}