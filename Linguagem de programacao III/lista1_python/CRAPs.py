# Um dos jogos de azar mais populares é o jogo conhecido como Craps. Escreva
# um programa em Java que simula o jogo de Craps.

#biblioteca para gerar números aleatorios
import random

#valores aleatorios atribuídos aos dois dados
dado1 = random.randrange(1, 7)
dado2 = random.randrange(1, 7)

#caso aconteça uma segunda rodada, guarda a soma dos dados
ponto = 0

print("dado 1: ", dado1, ", dado 2: ", dado2)

#se a soma for igual a 7 ou 11: venceu
if (dado1 + dado2) == 7 or (dado1 + dado2) == 11:
    print("voce ganhou :-)\n")

#se a soma for igual a 2, 3 ou 12: perdeu
elif (dado1 + dado2) == 2 or (dado1 + dado2) == 3 or (dado1 + dado2) == 12:
    print("voce perdeu :-(\n")

#caso contrário
else:
    #somas dos dados: critério para vitória
    ponto = dado1 + dado2

    #quantidades de jogadas até o jogo acabar
    control = 1

    print("ponto: ", ponto, "\nIniciando estagio 2\n")

    #loop que se encerra quando vence ou perde
    while True:
        #novos valores atribuidos aos dados a cada rodada
        dado1 = random.randrange(1, 7)
        dado2 = random.randrange(1, 7)

        print("dado 1: ", dado1, ", dado 2: ", dado2)
        print("jogada ", control, ": ", (dado1 + dado2))

        #condições de parada
        if (dado1 + dado2) == ponto:
            print("voce ganhou :-)\n")
            break
        elif (dado1 + dado2) == 7:
            print("voce perdeu :-(\n")
            break

        control += 1
