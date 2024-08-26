package lista10.questao3;

import java.util.ArrayList;
import java.util.List;

public class PoliticosApp {
    public static void main(String[] args) {
        List<Politico> politicos = new ArrayList<>();

        Politico politico1 = new Politico("João", "ABC", 1);
        Prefeito prefeito1 = new Prefeito("Maria", "DEF", 2, "Cidade A");
        Governador governador1 = new Governador("Carlos", "GHI", 3, "Estado X");

        politicos.add(politico1);
        politicos.add(prefeito1);
        politicos.add(governador1);

        for (Politico politico : politicos) {
            System.out.println(politico.toString());
        }
    }
}