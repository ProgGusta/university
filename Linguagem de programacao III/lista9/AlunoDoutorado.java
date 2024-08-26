import java.time.LocalDate;

class AlunoDoutorado extends AlunoPosgraduacao {
    public AlunoDoutorado(String nome, int matricula, LocalDate dataAdmissao, int semestre, String tipoCurso,
                          String orientador, String projetoPesquisa) 
    {
        super(nome, matricula, dataAdmissao, semestre, tipoCurso, orientador, projetoPesquisa, "D");
    }
}