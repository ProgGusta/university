import java.text.ParseException;

public class dataEx {
    public static void main(String[] args) throws ParseException {
        Data ex1 = new Data(30, 04, 2023);
        if(ex1.isPrevious(23, 12, 2001))
            ex1.dateFormat();
        int dias = ex1.howManyDays(23, 12, 2001);
        System.out.println(dias);
        String dia = ex1.dayOfWeek();
        System.out.println(dia);
    }
}
