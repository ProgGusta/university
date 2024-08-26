# Jogo de Batalha Naval. Desenvolva um programa em Java que seja uma recriação do Jogo Batalha
# Naval, nele dois jogadores escolhem os locais dos navios em um tabuleiro e tentam afundar os navios
# do outro jogador escolhendo as coordenadas para atirar. O jogador que primeiro afundar todos os navios
# do oponente ganha o Jogo.

#biblioteca para gerar números aleatorios
import random

#variaveis de controle
linha = 0 
coluna = 0

#Declaração dos arrays player1/player2
player1 = [[],[],[],[],[]]
player2 = [[],[],[],[],[]]
HITplayer1 = [[],[],[],[],[]]
HITplayer2 = [[],[],[],[],[]]

#atribuição do caracter '-' a todas as posições
for x in range(0, 5):
    for y in range(0, 5):
        player1[x].append('-')
        player2[x].append('-')
        HITplayer1[x].append('-')
        HITplayer2[x].append('-')
        
print( "Bem-vindo ao encouraçado!!" )
print( "Comece inserindo as coordenadas dos navios\nserao cinco, insira dos numeros inteiros separados\npor um espaco menores que cinco, o primeiro referencial a linha\neo segundo a coluna onde o navio vai estar posicionado" )
print( "Começaremos pelo jogador 1" )

#coordenadas do jogador 1
for x in range(0, 5):
    while True:
        print("Digite as coordenadas do navio ", x)

        #valores aleatorios para linha e coluna 
        linha = random.randrange(0, 5)
        coluna = random.randrange(0, 5)

        #verifica alguma irregularidade
        if linha < 0 or linha > 4 or coluna < 0 or coluna > 4 or player1[linha][coluna] == '@':
            print("coordenada invalida. escolha outra\n")

        #se não
        else:
            break
    
    player1[linha][coluna] = '@'

print("Agora as coordenadas do jogador 2")

#coordenadas do jogador 2
for x in range(0, 5):
    while True:
        print("Digite as coordenadas do navio ", x)

        #valores aleatorios para linha e coluna 
        linha = random.randrange(0, 5)
        coluna = random.randrange(0, 5)

        #verifica alguma irregularidade
        if linha < 0 or linha > 4 or coluna < 0 or coluna > 4 or player2[linha][coluna] == '@':
            print("coordenada invalida. escolha outra\n")

        #se não
        else:
            break
    
    player2[linha][coluna] = '@'

print("Vamos começar o jogo!!\n")

#variaveis contadoras dos pontos de cada player 
ponto1 = 0
ponto2 = 0

#loop até existir um vencedor
while True:
    print("Jogador 1 digite uma coordenada\n")

    #verifica se a coordenada é válida
    while True:
        print("Digite as coordenadas do navio ", x)

        #valores aleatorios para linha e coluna 
        linha = random.randrange(0, 5)
        coluna = random.randrange(0, 5)

        #verifica alguma irregularidade
        if linha < 0 or linha > 4 or coluna < 0 or coluna > 4 or HITplayer1[linha][coluna] != '-':
            print("coordenada invalida. escolha outra\n")

        #se não
        else:
            break

    #se acertar um navio
    if player2[linha][coluna] == '@':
        ponto1 += 1
        HITplayer1[linha][coluna] = 'X'
        print("Jogador 1 atingiu a nave do jogador 2")
        print("\t1\t2\t3\t4\t5")
        for x in range(0, 5):
            print(x + 1, "\t", HITplayer1 [ x ][ 0 ], "\t", HITplayer1 [ x ][ 1 ], "\t", HITplayer1 [ x ][ 2 ], "\t", HITplayer1 [ x ][ 3 ], "\t", HITplayer1 [ x ][ 4 ])
        
    #se não
    else:
        HITplayer1[linha][coluna] = 'O'
        print("Jogador 1 falhou!")
        print("\t1\t2\t3\t4\t5")
        for x in range(0, 5):
            print(x + 1, "\t", HITplayer1 [ x ][ 0 ], "\t", HITplayer1 [ x ][ 1 ], "\t", HITplayer1 [ x ][ 2 ], "\t", HITplayer1 [ x ][ 3 ], "\t", HITplayer1 [ x ][ 4 ])
    
    #verificação de vitória
    if ponto1 == 5:
        print("Jogador 1 venceu! voce afundou todos os navios do seu adversário\n\n")

        #painel do vencedor
        print("\t1\t2\t3\t4\t5")
        for x in range(0, 5):
            print(x + 1, "\t", HITplayer1 [ x ][ 0 ], "\t", HITplayer1 [ x ][ 1 ], "\t", HITplayer1 [ x ][ 2 ], "\t", HITplayer1 [ x ][ 3 ], "\t", HITplayer1 [ x ][ 4 ])

        print("\n")

        #painel do derrotado
        print("\t1\t2\t3\t4\t5")
        for x in range(0, 5):
            print(x + 1, "\t", HITplayer2 [ x ][ 0 ], "\t", HITplayer2 [ x ][ 1 ], "\t", HITplayer2 [ x ][ 2 ], "\t", HITplayer2 [ x ][ 3 ], "\t", HITplayer2 [ x ][ 4 ])

        #fim do loop
        break

    #vez do jogador 2 
    print("agora, jogador 2 digite uma coordenada\n")

    #verifica se a coordenada é válida
    while True:
        print("Digite as coordenadas do navio ", x)

        #valores aleatorios para linha e coluna 
        linha = random.randrange(0, 5)
        coluna = random.randrange(0, 5)

        #verifica alguma irregularidade
        if linha < 0 or linha > 4 or coluna < 0 or coluna > 4 or HITplayer2[linha][coluna] != '-':
            print("coordenada invalida. escolha outra\n")

        #se não
        else:
            break
    
    #se acertar um navio
    if player1[linha][coluna] == '@':
        ponto2 += 1
        HITplayer2[linha][coluna] = 'X'
        print("Jogador 2 atingiu a nave do jogador 1")
        print("\t1\t2\t3\t4\t5")
        for x in range(0, 5):
            print(x + 1, "\t", HITplayer2 [ x ][ 0 ], "\t", HITplayer2 [ x ][ 1 ], "\t", HITplayer2 [ x ][ 2 ], "\t", HITplayer2 [ x ][ 3 ], "\t", HITplayer2 [ x ][ 4 ])
        
    #se não
    else:
        HITplayer2[linha][coluna] = 'O'
        print("Jogador 2 falhou!")
        print("\t1\t2\t3\t4\t5")
        for x in range(0, 5):
            print(x + 1, "\t", HITplayer2 [ x ][ 0 ], "\t", HITplayer2 [ x ][ 1 ], "\t", HITplayer2 [ x ][ 2 ], "\t", HITplayer2 [ x ][ 3 ], "\t", HITplayer2 [ x ][ 4 ])

    #verificação de vitória
    if ponto2 == 5:
        print("Jogador 2 venceu! voce afundou todos os navios do seu adversário\n\n")

        #painel do vencedor
        print("\t1\t2\t3\t4\t5")
        for x in range(0, 5):
            print(x + 1, "\t", HITplayer2 [ x ][ 0 ], "\t", HITplayer2 [ x ][ 1 ], "\t", HITplayer2 [ x ][ 2 ], "\t", HITplayer2 [ x ][ 3 ], "\t", HITplayer2 [ x ][ 4 ])

        print("\n")
        
        #painel do derrotado
        print("\t1\t2\t3\t4\t5")
        for x in range(0, 5):
            print(x + 1, "\t", HITplayer1 [ x ][ 0 ], "\t", HITplayer1 [ x ][ 1 ], "\t", HITplayer1 [ x ][ 2 ], "\t", HITplayer1 [ x ][ 3 ], "\t", HITplayer1 [ x ][ 4 ])

        #fim do loop
        break