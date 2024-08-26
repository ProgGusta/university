import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class AlunoPosgraduacao extends Aluno 
{
    protected String orientador;
    protected String projetoPesquisa;
    protected String nivel;

    public AlunoPosgraduacao(String nome, int matricula, LocalDate dataAdmissao, int semestre, String tipoCurso,
                             String orientador, String projetoPesquisa, String nivel) {
        super(nome, matricula, dataAdmissao, semestre, tipoCurso);
        this.orientador = orientador;
        this.projetoPesquisa = projetoPesquisa;
        this.nivel = nivel;
    }

    @Override
    public void imprimirDados() {
        super.imprimirDados();
        System.out.println("Orientador: " + orientador);
        System.out.println("Projeto de Pesquisa: " + projetoPesquisa);
        System.out.println("Nível: " + nivel);
    }

    @Override
    protected double calcularMensalidade() {
        double mensalidadeBase = 700.00;
        double mensalidadeFinal = super.calcularMensalidade();

        long meses = ChronoUnit.MONTHS.between(dataAdmissao, LocalDate.now());

        if ((nivel.equals("M") && meses > 24) || (nivel.equals("D") && meses > 48)) {
            mensalidadeFinal += mensalidadeBase * 0.20;
        }

        return mensalidadeFinal;
    }
}