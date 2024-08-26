public class TimeConventional {
    private int hora;
    private int min;
    private int seg;

    //get hora
    public int getHora()
    {
        return this.hora;
    }

    //get min
    public int getMin()
    {
        return this.min;
    }

    //get seconds
    public int getSeg()
    {
        return this.seg;
    }

    //construtor da classe sem parâmetros
    public TimeConventional() {
        this.hora = 0;
        this.min = 0;
        this.seg = 0;
    }

    //construtor da classe com um parâmetro para a hora
    public TimeConventional(int hora) {
        if (validateHour(hora)) {
            this.hora = hora;
            this.min = 0;
            this.seg = 0;
        }
        else{
            System.out.println("Hora inválida");
            this.hora = 0;
            this.min = 0;
            this.seg = 0;
        }
    }

    //construtor da classe com dois parâmetros para hora e minutos
    public TimeConventional(int hora, int min) {
        if (validateTime(hora, min, 0)) {
            this.hora = hora;
            this.min = min;
            this.seg = 0;
        }
        else{
            System.out.println("Hora inválida");
            this.hora = 0;
            this.min = 0;
            this.seg = 0;
        }
    }

    //construtor da classe com três parâmetros para hora, minutos e segundos
    public TimeConventional(int hora, int min, int seg) {
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

    //construtor que recebe um objeto TimeConventional como parâmetro
    public TimeConventional(TimeConventional time) {
        this.hora = time.getHora();
        this.min = time.getMin();
        this.seg = time.getSeg();
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

    //retorna verdadeiro se horário for até 12:00 AM
    public boolean isAM() {
        if (this.hora < 12)
            return true;
        else if (this.hora == 12 && this.min == 0 && seg == 0)
            return true;
        else 
            return false;
    }

    //Tempo transcorrido de uma hora para a outra
    public int cron(int hora, int min, int seg) {
        if (validateTime(hora, min, seg)) {
            if(this.hora == hora && this.min == min && this.seg == seg)
                return 0;
            else {
                //conversão para segundos
                int aux = hora * 3600 + min * 60 + seg;
                int aux2 = this.hora * 3600 + this.min * 60 + this.seg;

                if (aux < aux2) {
                    aux = aux2 - aux;
                    return aux;
                }
                else {
                    aux = aux - aux2;
                    return aux;
                }
            }
        }
        else {
            System.out.println("Hora inválida");
            return 0;
        }
    }

    //Adição de segundos
    private void addSeconds(int secs)
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

    public void addTime(int s) {
        addSeconds(s);
    }
    
    public void addTime(int m, int s) {
        addSeconds(m * 60 + s);
    }
    
    public void addTime(int h, int m, int s) {
        addSeconds(h * 3600 + m * 60 + s);
    }
    
    public void addTime(TimeConventional obj) {
        addSeconds(obj.getHora() * 3600 + obj.getMin() * 60 + obj.getSeg());
    }

    public String getTime(){
        String res = this.hora + ":" + this.min + ":" + this.seg;
        return res;
    }

    public void prnTime(){
        System.out.println(getTime());
    }
}

