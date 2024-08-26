# Multímetro quebrado? Uma equipe de manutenção elétrica deve determinar se o multímetro está disponível
# ópera corretamente. Para isso deve-se realizar 10 medidas de voltagem em um circuito de corrente
# criado diretamente para testes. Em seguida, deve-se calcular a média ou o desvio padrão das leituras. Se o desvio
# Padrão para superior a 10% do valor médio, o multímetro está com problemas e não pode ser utilizado.
# Crie um programa que processe os dados das leituras e informe se o multímetro se encontrar
# operacional. Seu programa deve imprimir no final todas as leituras, o valor médio o desvio padrão e
# uma mensagem informando o estado do dispositivo.
# Instruções:
# • Os dados de entrada podem ser fixos para fins de teste, lidos via teclado, ou lidos de um arquivo
# texto com formato livre.
# • As expressões para calculadas da média e o desvio padrão devem ser iniciados na literatura acadêmica
# ou Google.

import random

#lista com as voltagens
volts = []

#variavel para somar as medias
media = 0.0

print("teste de multimetro\n")

#loop para adicionar os valores 
for x in range(0, 10): 
    
    #gerando valores aleatorios 
    volts.append(random.uniform(1.0, 20.0))

    #adicionando as medias
    media += volts[x]

#calculo da média
media /= 10.0

#variavel para calculo do desvio padrão
despad = 0.0

#loop para calcular o desvio padrão
for x in range(0, 10):
    despad += ((volts[x] - media) * (volts[x] - media))

#resultado final do desvio padrão - raiz quadrada
despad = despad ** (1/2)

#verifica se o desvio é maior ou não a 10% do valor da média
if despad > (media * 0.1):
    print("desvio padrao: ", despad, "\nmedia: ", media)
    print("\n valor superior a 10% do valor da media")

else:
    print("desvio padrao: ", despad, "\nmedia: ", media)
    print("\n valor inferior a 10% do valor da media")