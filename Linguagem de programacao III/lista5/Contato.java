import java.util.Calendar;
import java.util.GregorianCalendar;

public class Contato 
{
    private String nome;
    private String email;
    private String telefone;
    private int dia, mes, ano;

    public Contato (String nome, String email, String telefone, int dia, int mes, int ano)
    {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        if (dateValidation(dia, mes, ano))
        {
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        }
        else
        {
            this.dia = 0;
            this.mes = 0;
            this.ano = 0;
        }
    }

    //validação data 
    private boolean dateValidation(int dia, int mes, int ano)
    {
        //se for ano bissexto e o mes de fevereiro
        if ((ano % 4) == 0 && mes == 2)
        {
            if (dia <= 29)
                return true;
            else
                return false;
        }

        //se não for um ano bissexto e mes de fevereiro
        else if (mes == 2)
        {
            if (dia <= 28)
                return true;
            else 
                return false;
        }

        //se for um mes que vai até o dia 30
        else if (mes == 4 || mes == 6 || mes == 9 || mes == 11)
        {
            if (dia <= 30)
                return true;
            else 
                return false;
        }

        //ou se for um mes que vai até 31
        else 
        {
            if (dia <= 31)
                return true;
            else
                return false;
        }
    }
    
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
    public Data getNascimento()
    {
        Data nascimento = new Data(this.dia, this.mes, this.ano);
        return nascimento;
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
