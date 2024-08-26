public class RoboSimples 
{
    private  String nomeDoRobo;
    private int posicaoXAtual,posicaoYAtual;
    private char direcaoAtual;
    private int diaNE = 0;
    private int diaNO = 0;
    private int diaSE = 0;
    private int diaSO = 0;

    RoboSimples(String nome, int px, int py, char d)
    {
        if(validaRobo(nome, d))
        {
            nomeDoRobo = nome;
            posicaoXAtual = px;
            posicaoYAtual = py;
            direcaoAtual = d;
        }
    }

    RoboSimples(String nome)
    {
        if(name(nome))
            nomeDoRobo = nome;
        else
            nomeDoRobo = "Sem nome";
        
        posicaoXAtual = 0;
        posicaoYAtual = 0;
        direcaoAtual = 'N';
    }

    RoboSimples()
    {
        nomeDoRobo = "Wally";
        posicaoXAtual = 0;
        posicaoYAtual = 0;
        direcaoAtual = 'N';
    }

    //Validação nome
    private boolean name(String nome)
    {
        return nome != null;
    }

    //valida robo
    private boolean validaRobo(String nome, char d)
    {
        return name(nome) && (d == 'N' || d == 'S' || d == 'L' || d == 'O');
    }

    public void move()
    {

        if (direcaoAtual == 'N') posicaoYAtual += 1;
        if (direcaoAtual == 'S') posicaoYAtual -= 1;
        if (direcaoAtual == 'E') posicaoXAtual += 1;
        if (direcaoAtual == 'O') posicaoXAtual -= 1;
    }

    public void move(int passos, String diagonal)
    {
        if(diagonal != null)
        {
            if (diagonal == "NE")
                posicaoYAtual += passos;
            else if (diagonal == "SO") 
                posicaoYAtual -= passos;
            else if (diagonal == "SE") 
                posicaoXAtual += passos;
            else if (diagonal == "NO") 
                posicaoXAtual -= passos;
        }

        else
        {
            if (direcaoAtual == 'N') 
                posicaoYAtual += passos;
            if (direcaoAtual == 'S') 
                posicaoYAtual -= passos;
            if (direcaoAtual == 'E') 
                posicaoXAtual += passos;
            if (direcaoAtual == 'O') 
                posicaoXAtual -= passos;
        }
    }

    public void move(int passos)
    {
        if (direcaoAtual == 'N') posicaoYAtual += passos;
        if (direcaoAtual == 'S') posicaoYAtual -= passos;
        if (direcaoAtual == 'E') posicaoXAtual += passos;
        if (direcaoAtual == 'O') posicaoXAtual -= passos;
    }

    public void mudaDireção(char novaDirecao)
    {
        direcaoAtual = novaDirecao;
    }

    public String toString(){
        String str = "\nNome do robo: "+nomeDoRobo+"\n";
        str = str + "Posicao do robo: ("+posicaoXAtual+", "+posicaoYAtual+")\n";
        str = str + "Direcao do robo: "+direcaoAtual;

        return str;
    }
}