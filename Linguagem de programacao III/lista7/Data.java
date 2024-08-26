import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public class Data {
    private int day;
    private int month;
    private int year;

    public Data(int day, int month, int year) 
    {
        if(dateValidation(day, month, year))
        {
            this.day = day;
            this.month = month;
            this.year = year;
        }

        else
        {
            this.day = 0;
            this.month = 0;
            this.year = 0;
        }
    }

    public int getDay()
    {
        return day;
    }

    public int getMonth()
    {
        return month;
    }

    public int getYear()
    {
        return year;
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

    public static int howManyDaysUntilEndYear(Data d) {
        LocalDate currentDate = LocalDate.of(d.getYear(), d.getMonth(), d.getDay());
        LocalDate endOfYear = LocalDate.of(d.getYear(), 12, 31);
        return currentDate.until(endOfYear).getDays();
    }

    public static int howManyDaysUntilNextMonth(Data d) {
        LocalDate currentDate = LocalDate.of(d.getYear(), d.getMonth(), d.getDay());
        LocalDate firstDayOfNextMonth = currentDate.plusMonths(1).withDayOfMonth(1);
        return currentDate.until(firstDayOfNextMonth).getDays();
    }

    public static boolean isBisexto(Data d) {
        int year = d.getYear();
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static String dayOfWeek(Data d) {
        LocalDate currentDate = LocalDate.of(d.getYear(), d.getMonth(), d.getDay());
        return currentDate.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault());
    }

    public static String dayToPrintShort(Data d) {
        LocalDate currentDate = LocalDate.of(d.getYear(), d.getMonth(), d.getDay());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return currentDate.format(formatter);
    }

    public static String dayToPrintLong(Data d) {
        LocalDate currentDate = LocalDate.of(d.getYear(), d.getMonth(), d.getDay());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d 'de' MMMM 'de' yyyy", Locale.getDefault());
        return currentDate.format(formatter);
    }
}
