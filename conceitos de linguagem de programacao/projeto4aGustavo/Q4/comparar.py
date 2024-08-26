import matplotlib.pyplot as plt
import csv

# Paths to the CSV files
sort_results = {
    "C": "c_sort_times.csv",
    "Java": "java_sort_times.csv",
    "Prolog": "prolog_sort_times.csv",
    "Lisp": "lisp_sort_times.csv"
}

ackerman_results = {
    "C": "c_ackerman_times.csv",
    "Java": "java_ackerman_times.csv",
    "Prolog": "prolog_ackerman_times.csv",
    "Lisp": "lisp_ackerman_times.csv"
}

# Function to read sorting times
def read_sort_times(file):
    sizes = []
    times = {"Insertion Sort": [], "Bubble Sort": [], "Merge Sort": [], "Quick Sort": []}
    with open(file, newline='') as csvfile:
        reader = csv.reader(csvfile)
        next(reader)  # Skip header
        for row in reader:
            sizes.append(int(row[0]))
            for i, alg in enumerate(times.keys()):
                times[alg].append(float(row[i + 1]))
    return sizes, times

# Function to read Ackerman times
def read_ackerman_times(file):
    ms = []
    ns = []
    times = []
    with open(file, newline='') as csvfile:
        reader = csv.reader(csvfile)
        next(reader)  # Skip header
        for row in reader:
            ms.append(int(row[0]))
            ns.append(int(row[1]))
            times.append(float(row[2]))
    return ms, ns, times

# Plot sorting times
plt.figure(figsize=(14, 7))
for language, file in sort_results.items():
    sizes, times = read_sort_times(file)
    for alg, alg_times in times.items():
        plt.plot(sizes, alg_times, label=f"{language} - {alg}")

plt.xlabel("Tamanho da lista")
plt.ylabel("Tempo de execução (segundos)")
plt.title("Comparação de desempenho dos algoritmos de ordenação")
plt.legend()
plt.savefig('sorting_comparison.png')
plt.show()

# Plot Ackerman times
plt.figure(figsize=(14, 7))
for language, file in ackerman_results.items():
    ms, ns, times = read_ackerman_times(file)
    plt.scatter(ms, times, label=f"{language} - Ackerman", marker='x')

plt.xlabel("Valor de m")
plt.ylabel("Tempo de execução (segundos)")
plt.title("Comparação de desempenho da função de Ackerman")
plt.legend()
plt.savefig('ackerman_comparison.png')
plt.show()

# Combined Plot
plt.figure(figsize=(14, 7))
# Sorting
for language, file in sort_results.items():
    sizes, times = read_sort_times(file)
    for alg, alg_times in times.items():
        plt.plot(sizes, alg_times, label=f"{language} - {alg}")

# Ackerman
for language, file in ackerman_results.items():
    ms, ns, times = read_ackerman_times(file)
    plt.scatter(ms, times, label=f"{language} - Ackerman", marker='x')

plt.xlabel("Tamanho da lista / Valor de m")
plt.ylabel("Tempo de execução (segundos)")
plt.title("Comparação de desempenho dos algoritmos de ordenação e da função de Ackerman")
plt.legend()
plt.savefig('combined_comparison.png')
plt.show()
