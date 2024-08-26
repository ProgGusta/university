import java.time.LocalDate;

class AlunoMestrado extends AlunoPosgraduacao 
{
    public AlunoMestrado(String nome, int matricula, LocalDate dataAdmissao, int semestre, String tipoCurso,
                         String orientador, String projetoPesquisa) 
    {
        super(nome, matricula, dataAdmissao, semestre, tipoCurso, orientador, projetoPesquisa, "M");
    }
}