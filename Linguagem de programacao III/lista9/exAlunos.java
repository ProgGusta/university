import java.time.LocalDate;

public class exAlunos 
{
    public static void main(String[] args) 
    {
        Aluno aluno1 = new Aluno("João", 1234, LocalDate.of(2020, 8, 1), 2, "Engenharias");
        aluno1.imprimirDados();

        System.out.println();

        AlunoPosgraduacao aluno2 = new AlunoPosgraduacao("Maria", 5678, LocalDate.of(2022, 1, 1), 1, "Letras",
                "Dr. Silva", "Estudo sobre Literatura Brasileira", "M");
        aluno2.imprimirDados();

        AlunoMestrado alunoMestrado = new AlunoMestrado("Pedro", 9876, LocalDate.of(2021, 2, 1), 1, "Computação",
        "Dr. Oliveira", "Estudo sobre Inteligência Artificial");
        alunoMestrado.imprimirDados();

        System.out.println();

        AlunoDoutorado alunoDoutorado = new AlunoDoutorado("Ana", 5432, LocalDate.of(2020, 9, 1), 3, "Biológicas",
                "Dra. Santos", "Estudo sobre Genética Molecular");
        alunoDoutorado.imprimirDados();

    }
}