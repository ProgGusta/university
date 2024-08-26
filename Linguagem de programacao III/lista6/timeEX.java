public class timeEX {
    public static void main(String[] args) {
        // criando um objeto TimeConventional utilizando o construtor sem parâmetros
        TimeConventional time1 = new TimeConventional();
        System.out.println("time1 = " + time1.getTime()); 

        // criando um objeto TimeConventional utilizando o construtor com um parâmetro
        TimeConventional time2 = new TimeConventional(5);
        System.out.println("time2 = " + time2.getTime()); 

        // criando um objeto TimeConventional utilizando o construtor com dois parâmetros
        TimeConventional time3 = new TimeConventional(15, 30);
        System.out.println("time3 = " + time3.getTime()); 

        // criando um objeto TimeConventional utilizando o construtor com três parâmetros
        TimeConventional time4 = new TimeConventional(23, 45, 30);
        System.out.println("time4 = " + time4.getTime());

        // criando um objeto TimeConventional utilizando o construtor que recebe um objeto TimeConventional como parâmetro
        TimeConventional time5 = new TimeConventional(time2);
        System.out.println("time5 = " + time5.getTime());

        // adicionando 1 hora, 30 minutos e 45 segundos ao objeto time1
        time1.addTime(1, 30, 45);
        System.out.println("time1 = " + time1.getTime());

        // adicionando 15 segundos ao objeto time2
        time2.addTime(15);
        System.out.println("time2 = " + time2.getTime()); 

        // adicionando 1 hora e 10 minutos ao objeto time3
        time3.addTime(1, 10);
        System.out.println("time3 = " + time3.getTime());

        // adicionando 1 hora e 30 segundos ao objeto time4
        time4.addTime(1, 0, 30);
        System.out.println("time4 = " + time4.getTime()); 

        // calculando o tempo transcorrido entre o objeto time3 e o objeto time4
        int diff = time3.cron(time4.getHora(), time4.getMin(), time4.getSeg());
        System.out.println("diff = " + diff); 
    }
}