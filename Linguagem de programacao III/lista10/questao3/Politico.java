package lista10.questao3;

class Politico extends Pessoa {
    private String siglaPartido;
    private int numeroPartido;

    public Politico(String nome, String siglaPartido, int numeroPartido) {
        super(nome);
        this.siglaPartido = siglaPartido;
        this.numeroPartido = numeroPartido;
    }

    @Override
    public String toString() {
        return super.toString() + ", Sigla do Partido: " + siglaPartido + ", Número do Partido: " + numeroPartido;
    }
}



