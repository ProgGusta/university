public class TimeConventional {
    private int hora;
    private int min;
    private int seg;

    //construtor da classe
    public TimeConventional(int hora, int min, int seg)
    {
        if (validateTime(hora, min, seg)) {
            this.hora = hora;
            this.min = min;
            this.seg = seg;
        }
        else{
            System.out.println("Hora inválida");
            this.hora = 0;
            this.min = 0;
            this.seg = 0;
        }
    }

    //retorna verdadeiro se horário for até 12:00 AM
    public boolean isAM()
    {
        if (this.hora < 12)
            return true;
        else if (this.hora == 12 && this.min == 0 && seg == 0)
            return true;
        else 
            return false;
    }

    //Tempo transcorrido de uma hora para a outra
    public int cron(int hora, int min, int seg)
    {
        if (validateTime(hora, min, seg))
        {
            if(this.hora == hora && this.min == min && this.seg == seg)
                return 0;
            else
            {
                //conversão para segundos
                int aux = hora * 3600 + min * 60 + seg;
                int aux2 = this.hora * 3600 + this.min * 60 + this.seg;

                if (aux < aux2)
                {
                    aux = aux2 - aux;
                    return aux;
                }

                else
                {
                    aux = aux - aux2;
                    return aux;
                }
            }
        }

        else
        {
            System.out.println("Hora inválida");
            return 0;
        }
    }

    //Adição de segundos
    public void addSeconds(int secs)
    {
        //convertendo hora do objeto para segundos
        int aux = this.hora * 3600 + this.min * 60 + this.seg;

        aux += secs;

        this.hora = aux / 3600;
        this.min = (aux % 3600) / 60;
        this.seg = (aux % 3600) % 60;

        //se a hora resultante for do dia seguinte
        if(this.hora > 24)
            this.hora = this.hora % 24;
        else if (this.hora == 24 && (this.min != 0 || this.seg != 0))
            this.hora = 0;
    }

    private boolean validateTime(int hora, int min, int seg){
        return validateHour(hora) && 
               validateMinOrSec(min) && 
               validateMinOrSec(seg);
    }

    private boolean validateHour(int hora){
        if((hora>=0) && (hora<25))
            return true;
        else
            return false;
    }

    private boolean validateMinOrSec(int param){
        if((param>=0) && (param<61))
            return true;
        else
            return false;
    }

    /* public void setTime(int hora, int min, int seg){
        if (validateTime(hora, min, seg)) {
            this.hora = hora;
            this.min = min;
            this.seg = seg;
        }
        else{
            this.hora = 0;
            this.min = 0;
            this.seg = 0;
        }
    } */

    public String getTime(){
        String res = this.hora + ":" + this.min + ":" + this.seg;
        return res;
    }

    public void prnTime(){
        System.out.println(getTime());
    }
}