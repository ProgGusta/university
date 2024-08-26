//usado na função dateRun para iniciar com uma data aleatória 
import java.util.Random;

public class data
{
    private int dia; 
    private int mes;
    private int ano;

    //retornar o dia
    public int getDia()
    {
        return dia;
    }

    //retornar o mes
    public int getMes()
    {
        return mes;
    }

    //retornar o ano
    public int getAno()
    {
        return ano;
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

    //inicializa data
    public void dateRun()
    {
        Random random = new Random();
        // dia aleatório
        int num1 = random.nextInt(31) + 1;

        //mes aleatório
        int num2 = random.nextInt(12) + 1;

        //ano aleatório
        int num3 = random.nextInt(2030) + 1;

        if(dateValidation(num1, num2, num3))
        {
            dia = num1;
            mes = num2;
            ano = num3;
        }

        // se não for válida, chama a função novamente
        else
            dateRun();
    }

    //usuário insere a data
    public void setDate(int dia, int mes, int ano)
    {
        if (dateValidation(dia, mes, ano))
        {
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        }

        else
        {
            System.out.println("Data inválida!!");
            this.dia = 0;
            this.mes = 0;
            this.ano = 0;
        }
    }

    //print data formato dd/mm/aaaa
    public void dateFormat()
    {
        System.out.println(dia + "/" + mes + "/" + ano);
    }

    //print data por extenso
    public void dateExtensive()
    {
        String[] mes = {"janeiro", "fevereiro", "março", "abril",
                 "maio", "junho", "julho", "agosto", "setembro",
                 "outubro", "novembro", "dezembro"};
        
        System.out.println(this.dia + " de " + mes[this.mes - 1] + " de " + this.ano);
    }
}