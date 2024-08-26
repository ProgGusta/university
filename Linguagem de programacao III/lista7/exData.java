public class exData {
    public static void main(String[] args) {
        Data d1 = new Data(15, 5, 2023);
        Data d2 = new Data(28, 2, 2024);

        System.out.println("Dias até o final do ano para d1: " + Data.howManyDaysUntilEndYear(d1));
        System.out.println("Dias até o primeiro dia do mês seguinte para d1: " + Data.howManyDaysUntilNextMonth(d1));
        System.out.println("d1 é bissexto? " + Data.isBisexto(d1));
        System.out.println("Dia da semana de d1: " + Data.dayOfWeek(d1));
        System.out.println("Data formatada de d1 (curto): " + Data.dayToPrintShort(d1));
        System.out.println("Data formatada de d1 (longo): " + Data.dayToPrintLong(d1));

        System.out.println("Dias até o final do ano para d2: " + Data.howManyDaysUntilEndYear(d2));
        System.out.println("Dias até o primeiro dia do mês seguinte para d2: " + Data.howManyDaysUntilNextMonth(d2));
        System.out.println("d2 é bissexto? " + Data.isBisexto(d2));
        System.out.println("Dia da semana de d2: " + Data.dayOfWeek(d2));
        System.out.println("Data formatada de d2 (curto): " + Data.dayToPrintShort(d2));
        System.out.println("Data formatada de d2 (longo): " + Data.dayToPrintLong(d2));
    }
}