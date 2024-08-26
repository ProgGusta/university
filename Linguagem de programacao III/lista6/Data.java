public class Data {
    private int dia;
    private int mes;
    private int ano;

    //Construtor com três parâmetros
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

    //Construtor sem parâmetros
    public Data()
    {
        this.dia = 1;
        this.mes = 1;
        this.ano = 1970;
    }

    //Construtor que recebe um objeto Data
    public Data(Data data)
    {
        this.dia = data.getDia();
        this.mes = data.getMes();
        this.ano = data.getAno();
    }

    public void setData(Data novaData) {
        if (dateValidation(novaData.getDia(), novaData.getMes(), novaData.getAno())) {
            this.dia = novaData.getDia();
            this.mes = novaData.getMes();
            this.ano = novaData.getAno();
        } else {
            System.out.println("Data inválida!!");
        }
    }
    
    public void setData(int dia, int mes, int ano) {
        if (dateValidation(dia, mes, ano)) {
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        } else {
            System.out.println("Data inválida!!");
        }
    }
    
    public void setData(int primeiroDiaDoMesX) {
        setData(1, primeiroDiaDoMesX, getAno());
    }

    //Métodos getters e setters
    public int getDia()
    {
        return dia;
    }

    public void setDia(int dia)
    {
        if (dateValidation(dia, this.mes, this.ano))
        {
            this.dia = dia;
        }
        else
        {
            System.out.println("Data inválida!!");
        }
    }

    public int getMes()
    {
        return mes;
    }

    public void setMes(int mes)
    {
        if (dateValidation(this.dia, mes, this.ano))
        {
            this.mes = mes;
        }
        else
        {
            System.out.println("Data inválida!!");
        }
    }

    public int getAno()
    {
        return ano;
    }

    public void setAno(int ano)
    {
        if (dateValidation(this.dia, this.mes, ano))
        {
            this.ano = ano;
        }
        else
        {
            System.out.println("Data inválida!!");
        }
    }

    //Método para validação da data
    private boolean dateValidation(int dia, int mes, int ano)
    {
        //Verifica se o ano é bissexto
        boolean bissexto = (ano % 4 == 0 && ano % 100 != 0) || ano % 400 == 0;

        //Verifica se o mês é válido
        if (mes < 1 || mes > 12)
        {
            return false;
        }

        //Verifica se o dia é válido
        switch (mes)
        {
            case 2:
                if (bissexto)
                {
                    return dia >= 1 && dia <= 29;
                }
                else
                {
                    return dia >= 1 && dia <= 28;
                }
            case 4:
            case 6:
            case 9:
            case 11:
                return dia >= 1 && dia <= 30;
            default:
                return dia >= 1 && dia <= 31;
        }
    }

    //Método para imprimir a data
    public void imprimir()
    {
        System.out.printf("%02d/%02d/%04d\n", dia, mes, ano);
    }

    public void avancarUmDia() {
        int ultimoDiaDoMes = 31;
        boolean bissexto = (ano % 4 == 0 && ano % 100 != 0) || ano % 400 == 0;
        
        switch (mes) {
            case 2:
                if (bissexto) {
                    ultimoDiaDoMes = 29;
                } else {
                    ultimoDiaDoMes = 28;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                ultimoDiaDoMes = 30;
                break;
        }
        
        dia++;
        
        if (dia > ultimoDiaDoMes) {
            dia = 1;
            mes++;
            
            if (mes > 12) {
                mes = 1;
                ano++;
            }
        }
    }
    
    public int howManyDays(Data outraData) {
        return howManyDays(outraData.getDia(), outraData.getMes(), outraData.getAno());
    }
    
    public int howManyDays(int day, int month, int year) {
        int dias = 0;
    
        // Verifica se a data atual é anterior à data enviada como parâmetro
        boolean dataAtualMenor = this.ano < year || 
                                (this.ano == year && this.mes < month) || 
                                (this.ano == year && this.mes == month && this.dia < day);
    
        if (dataAtualMenor)
        {
            // Calcula a quantidade de dias entre a data atual e a data enviada como parâmetro
            Data dataAtual = new Data(this.dia, this.mes, this.ano);
            while (dataAtual.getAno() != year || dataAtual.getMes() != month || dataAtual.getDia() != day)
            {
                dias++;
                dataAtual.avancarUmDia();
            }
            dias = -dias;
        }
        else
        {
            // Calcula a quantidade de dias entre a data enviada como parâmetro e a data atual
            Data dataParametro = new Data(day, month, year);
            while (dataParametro.getAno() != this.ano || dataParametro.getMes() != this.mes || dataParametro.getDia() != this.dia)
            {
                dias++;
                dataParametro.avancarUmDia();
            }
        }
    
        return dias;
    }
    
}
