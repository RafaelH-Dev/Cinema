package Cinema;

import java.util.ArrayList;

public class Notas {
    private ArrayList<Double> notas = new ArrayList<>();
    private double classificacaoFilme;

    public int getAvaliacoes(){
        return notas.size();
    }

    public void adicionarNota(double nota) {
        notas.add(nota);
    }

    private double mediaNotaFilme() {
        if (notas.isEmpty()) {
            return 0;
        }
        double media = 0;
        for (double nota : notas) {
            media += nota;
        }
        return media / notas.size();
    }

    public double getClassificacaoFilme() {
        return mediaNotaFilme();
    }
}

