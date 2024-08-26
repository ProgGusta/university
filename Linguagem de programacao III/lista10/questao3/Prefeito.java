package lista10.questao3;

public  class Prefeito extends Politico {
    private String cidadeGovernada;

    public Prefeito(String nome, String siglaPartido, int numeroPartido, String cidadeGovernada) {
        super(nome, siglaPartido, numeroPartido);
        this.cidadeGovernada = cidadeGovernada;
    }

    @Override
    public String toString() {
        return super.toString() + ", Cidade Governada: " + cidadeGovernada;
    }
}
