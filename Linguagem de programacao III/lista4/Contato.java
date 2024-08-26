import java.util.Calendar;
import java.util.GregorianCalendar;

public class Contato 
{
    private String nome;
    private String email;
    private String telefone;
    private int dia, mes, ano;
    
    //retorna o nome
    public String getNome()
    {
        return nome;
    }

    //retorna o email
    public String getEmail()
    {
        return email;
    }

    //retorna o telefone
    public String getTelefone()
    {
        return telefone;
    }

    //retorna data de nascimento
    public data getNascimento()
    {
        data nascimento = new data();
        nascimento.setDate(this.dia, this.mes, this.ano);
        return nascimento;
    }

    //set contato
    public void  contactRun(String nome, String email, String telefone, int dia, int mes, int ano)
    {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }
    
    //print contato
    public void ContactPrint()
    {
        System.out.println("nome: " + this.nome + "\nemail: " + this.email + "\ntelefone: "
                            + this.telefone + "\nnascimento: " + this.dia + "/" + this.mes + "/" + this.ano);
    }

    //calcular idade 
    public void calculateAge()
    {
        //pega a data atual do computador 
        Calendar now = GregorianCalendar.getInstance();
        int diaAtual = now.get(Calendar.DAY_OF_MONTH);
        int mesAtual = now.get(Calendar.MONTH);
        int anoAtual = now.get(Calendar.YEAR);

        //data de nascimento do usuário
        int nasc = this.ano * 365;
        nasc = nasc + (this.mes * 31);
        nasc = nasc + this.dia;

        //conversão da data
        int atual = anoAtual *  365;
        atual = atual + (mesAtual * 31);
        atual = atual  + diaAtual;

        System.out.println("Você tem " + (atual - nasc) + " dias ou "
                            + ((atual - nasc) / 31) + " meses ou " + ((atual - nasc) / 365) + " anos.");
    }
}
