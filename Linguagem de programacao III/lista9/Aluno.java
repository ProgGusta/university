import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class Aluno {
    protected String nome;
    protected int matricula;
    protected LocalDate dataAdmissao;
    protected int semestre;
    protected String tipoCurso;
    protected double mensalidade;

    public Aluno(String nome, int matricula, LocalDate dataAdmissao, int semestre, String tipoCurso) 
    {
        this.nome = nome;
        this.matricula = matricula;
        this.dataAdmissao = dataAdmissao;
        this.semestre = semestre;
        this.tipoCurso = tipoCurso;
        this.mensalidade = calcularMensalidade();
    }

    public void imprimirDados() 
    {
        System.out.println("Nome: " + nome);
        System.out.println("Matrícula: " + matricula);
        System.out.println("Data de Admissão: " + dataAdmissao);
        System.out.println("Semestre: " + semestre);
        System.out.println("Tipo de Curso: " + tipoCurso);
        System.out.println("Mensalidade: R$ " + mensalidade);
    }

    protected double calcularMensalidade() 
    {
        double mensalidadeBase = 700.00;
        double mensalidadeFinal = mensalidadeBase;

        if (tipoCurso.equals("Engenharias")) {
            mensalidadeFinal += mensalidadeBase * 0.20;
        } else if (tipoCurso.equals("Computação")) {
            mensalidadeFinal += mensalidadeBase * 0.10;
        } else if (tipoCurso.equals("Letras")) {
            mensalidadeFinal += mensalidadeBase * 0.05;
        }

        long meses = ChronoUnit.MONTHS.between(dataAdmissao, LocalDate.now());

        if (meses > semestre) {
            mensalidadeFinal += mensalidadeBase * 0.20;
        }

        return mensalidadeFinal;
    }
}