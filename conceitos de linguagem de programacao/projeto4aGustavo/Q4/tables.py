import matplotlib.pyplot as plt
import csv

results = {
    "C": "c_sort_times.csv",
    "Java": "java_sort_times.csv",
    "Prolog": "prolog_sort_times.csv",
    "Lisp": "lisp_sort_times.csv"
}

sort_algorithms = ["Insertion Sort", "Bubble Sort", "Merge Sort", "Quick Sort"]

for language, file in results.items():
    sizes = []
    times = {alg: [] for alg in sort_algorithms}
    with open(file, newline='') as csvfile:
        reader = csv.reader(csvfile)
        for row in reader:
            sizes.append(int(row[0]))
            for i, alg in enumerate(sort_algorithms):
                times[alg].append(float(row[i + 1]))

    for alg in sort_algorithms:
        plt.plot(sizes, times[alg], label=f"{language} - {alg}")

plt.xlabel("Tamanho da lista")
plt.ylabel("Tempo de execução (segundos)")
plt.title("Comparação de desempenho dos algoritmos de ordenação")
plt.legend()
plt.savefig('nome_do_arquivo.png')
plt.show()
