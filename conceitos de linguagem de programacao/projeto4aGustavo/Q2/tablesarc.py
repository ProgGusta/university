import matplotlib.pyplot as plt
import csv

results = {
    "C": "c_ackerman_times.csv",
    "Java": "java_ackerman_times.csv",
    "Prolog": "prolog_ackerman_times.csv",
    "Lisp": "lisp_ackerman_times.csv"
}

for language, file in results.items():
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

    plt.plot(ms, times, label=f"{language} - m")

plt.xlabel("Valor de m")
plt.ylabel("Tempo de execução (segundos)")
plt.title("Comparação de desempenho da função de Ackerman")
plt.legend()
plt.savefig('ackerman_comparison.png')
plt.show()
