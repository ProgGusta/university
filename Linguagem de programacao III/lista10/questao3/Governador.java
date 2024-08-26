package lista10.questao3;

public class Governador extends Politico {
    private String estadoGovernado;

    public Governador(String nome, String siglaPartido, int numeroPartido, String estadoGovernado) {
        super(nome, siglaPartido, numeroPartido);
        this.estadoGovernado = estadoGovernado;
    }

    @Override
    public String toString() {
        return super.toString() + ", Estado Governado: " + estadoGovernado;
    }
}