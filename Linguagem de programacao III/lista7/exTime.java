public class exTime {
    public static void main(String[] args) {
        Time t1 = new Time(10, 30, 0);
        Time t2 = new Time(15, 45, 30);

        Time diff1 = Time.diffTime(t1, t2);
        System.out.println("Diferença de tempo entre t1 e t2: " + diff1.getHour() + " horas, " +
                diff1.getMinute() + " minutos, " + diff1.getSecond() + " segundos");

        Time diff2 = Time.diffTime(t1);
        System.out.println("Diferença de tempo entre t1 e a hora corrente: " + diff2.getHour() + " horas, " +
                diff2.getMinute() + " minutos, " + diff2.getSecond() + " segundos");

        System.out.println("t1 é AM? " + Time.isAm(t1));
        System.out.println("t2 é PM? " + Time.isPm(t2));
    }
}
