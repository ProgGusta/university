//usado na função dateRun para iniciar com uma data aleatória 
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Random;

public class Data
{
    private int dia; 
    private int mes;
    private int ano;

    //Construtor
    public Data(int dia, int mes, int ano)
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
    
    //Se a data for anterior retorna verdadeiro
    public boolean isPrevious(int dia, int mes, int ano)
    {
        if (dateValidation(dia, mes, ano))
        {
            if (ano > this.ano || 
            (ano == this.ano && mes > this.mes) || 
            (ano == this.ano && mes == this.mes && dia > this.dia))
                return false;
            else
                return true;
        }

        else
            return false;
    }

    //Quantidade de dias até a data enviada
    public int howManyDays (int dia, int mes, int ano)
    {
        if(dateValidation(dia, mes, ano))
        {
            int dias = 0;
            int aux;
            int aux2;
            int aux3;

            if (this.dia <= dia)
                aux = dia - this.dia;
            else
                aux = this.dia - dia;

            if (this.mes <= mes)
                aux2 = mes - this.mes;
            else 
                aux2 = this.mes - mes;

            if (this.ano <= ano)
                aux3 = ano - this.ano;
            else
                aux3 = this.ano - ano;

            int x = aux3 / 4;
            dias += (365 * aux3) + x;

            for (int i=1; i <= aux2; i++)
            {
                if(i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12)
                    dias += 31;
                else if (i == 2)
                    dias += 28;
                else
                    dias += 30; 
            }

            dias += aux;
            
            if (ano < this.ano || 
            (ano == this.ano && mes < this.mes) || 
            (ano == this.ano && mes == this.mes && dia < this.dia))
                dias *= (-1);

            return dias;
        }

        else 
            return 0;
    }

    //retorna o dia da semana
    public String dayOfWeek() throws ParseException
    {
        String data = this.mes + "/" + this.dia + "/" + this.ano;
        String dayWeek = "---";
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(new SimpleDateFormat("MM/dd/yyyy", new Locale("pt", "BR")).parse(data));
        switch (gc.get(Calendar.DAY_OF_WEEK))
        {
            case Calendar.SUNDAY:
                dayWeek = "DOMINGO";
                break;
            case Calendar.MONDAY:
                dayWeek = "SEGUNDA";
                break;
            case Calendar.TUESDAY:
                dayWeek = "TERÇA";
                break;
            case Calendar.WEDNESDAY:
                dayWeek = "QUARTA";
                break;
            case Calendar.THURSDAY:
                dayWeek = "QUINTA";
                break;
            case Calendar.FRIDAY:
                dayWeek = "SEXTA";
                break;
            case Calendar.SATURDAY:
                dayWeek = "SABADO";
                break;
        }

        return dayWeek;
    }


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

    /*//usuário insere a data
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
    } */

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
