public class timeEX {
    public static void main(String[] args) {
        //Exemplo 1
        TimeConventional ex1 = new TimeConventional(30, 320, 61);
        ex1.prnTime();

        //Exemplo 2
        TimeConventional ex2 = new TimeConventional(22, 48, 34);
        if (ex2.isAM())
            ex2.prnTime();
        else
        {
            int tempo = ex2.cron(23, 0, 0);
            System.out.println(tempo);
            
            ex2.addSeconds(5000);
            ex2.prnTime();
        }
    }
}
