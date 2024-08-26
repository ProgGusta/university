public class ExemploData {
    public static void main(String[] args) {
        //Criando um objeto Data com a data atual
        Data dataAtual = new Data();
        System.out.print("Data atual: ");
        dataAtual.imprimir();

        //Definindo uma nova data
        dataAtual.setData(15, 05, 2023);
        System.out.print("Nova data: ");
        dataAtual.imprimir();

        //Avançando um dia e imprimindo a data novamente
        dataAtual.avancarUmDia();
        System.out.print("Data após avançar um dia: ");
        dataAtual.imprimir();

        //Definindo nova data
        dataAtual.setData(5);
        System.out.print("Nova data: ");
        dataAtual.imprimir();

        //Diferença de datas
        int diff = dataAtual.howManyDays(23, 12, 2001);
        System.out.println("DIferença: " + diff);
    }
}
