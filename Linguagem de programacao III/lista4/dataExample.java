public class dataExample {
    public static void main(String[] args) {
        data ex1 = new data();
        ex1.setDate(28, 02, 2010);
        ex1.dateFormat();
        ex1.dateExtensive();

        data ex2 = new data();
        ex2.dateRun();
        System.out.println("dia: " + ex2.getDia() + "\nmes: " + ex2.getMes() + "\nano: " + ex2.getAno());
    }
}
