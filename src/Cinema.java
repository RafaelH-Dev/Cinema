import java.util.ArrayList;

public class Cinema {
    private static ArrayList<Sala> minhasSalas = new ArrayList<>();

    public static void cadastrarSala(Sala novaSala) {
        minhasSalas.add(novaSala);
    }

    public static void exibirSalas() {
        for (Sala sala : minhasSalas) {
            System.out.println(sala);
        }
    }

    public static void venderIngressos(String numeroDaSala) {
        for (Sala sala : minhasSalas) {
            if (sala.getNumeroSala().equals(numeroDaSala))
                sala.venderIngresso();
        }
    }

    public static boolean avaliarFilme(String numeroDaSala, double nota) {
        for (Sala sala : minhasSalas) {
            if (sala.getNumeroSala().equals(numeroDaSala)) {
                sala.getFilmeEmExibicao().avaliarFilme(nota);
                return true;
            }
        }
        return false;
    }

    public static void cadastrarFilme(String numeroDaSala, Filme novoFilme) {
        for (Sala sala : minhasSalas) {
            if (sala.getNumeroSala().equals(numeroDaSala)) {
                sala.setFilmeEmExibicao(novoFilme);
                return;
            }
        }
    }

}
