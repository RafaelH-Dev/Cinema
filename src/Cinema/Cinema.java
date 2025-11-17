package Cinema;

import java.util.ArrayList;

public class Cinema {
    private static ArrayList<Sala> minhasSalas = new ArrayList<>();
    private static ArrayList<Filme> meusFilmes = new ArrayList<>();

    public static void cadastrarSala(Sala novaSala) {
        Sala sala = verificadorSala(novaSala.getNumeroSala());
        if (sala == null) {
            minhasSalas.add(novaSala);
        }
    }

    public static void exibirSalas() {
        for (Sala sala : minhasSalas) {
            System.out.println(sala);
        }
    }

    private static Sala verificadorSala(String numeroDaSala) {
        for (Sala sala : minhasSalas) {
            if (sala.getNumeroSala().equals(numeroDaSala)) {
                return sala;
            }
        }
        return null;
    }

    public static boolean removeSala(String numeroDaSala) {
        Sala sala = verificadorSala(numeroDaSala);
        if (sala != null) {
            minhasSalas.remove(sala);
            return true;
        }
        return false;
    }

    public static boolean venderIngressos(String numeroDaSala) {
        Sala sala = verificadorSala(numeroDaSala);
            if(sala!=null) {
                return sala.venderIngresso();
            }
            return false;
        }

    private static Filme verificadorFilme(String nomeDoFilme) {
        for (Filme filme : meusFilmes) {
            if (filme.getNomeFilme().equals(nomeDoFilme)) {
                return filme;
            }
        }
        return null;
    }

    public static boolean avaliarFilme(String nomeDoFilme, double nota) {
        Filme filme = verificadorFilme(nomeDoFilme);
        if (filme != null) {
            filme.adicionarNota(nota);
            return true;
        }
        return false;
    }

    public static void exibirFilmes() {
        for (Filme filme : meusFilmes) {
            System.out.println(filme);
        }
    }

    public static void cadastrarFilme(String numeroDaSala, Filme novoFilme) {
        for (Sala sala : minhasSalas) {
            if (sala.getNumeroSala().equals(numeroDaSala)) {
                sala.setFilmeEmExibicao(novoFilme);
                return;
            }
        }
    }

    public static boolean cadastrarFilmeSemSala(Filme novoFilme) {
        for (Filme filme : meusFilmes) {
            if (filme.getNomeFilme().equals(novoFilme.getNomeFilme())) {
                return false;
            }
        }
        return meusFilmes.add(novoFilme);
    }

    public static boolean colocarFilmeSemSalaEmSala(String numeroDaSala, String nomeDoFilme) {
        Sala sala = verificadorSala(numeroDaSala);
        Filme filme = verificadorFilme(nomeDoFilme);
        if (filme != null && sala != null) {
            sala.setFilmeEmExibicao(filme);
            return true;
        }
        return false;
    }

    //erro documentar
    public static boolean removerFilme(String nomeDoFilme) {
        Filme filme = verificadorFilme(nomeDoFilme);
        if (filme != null) {
            for (Sala sala : minhasSalas) {
                if (sala.getFilmeEmExibicao() == filme) {
                    sala.setFilmeEmExibicao(null);
                }
            }
            return meusFilmes.remove(filme);
        }
        return false;
    }

    public static boolean removerFilmeDaSala(String numeroDaSala, String nomeDoFilme) {
        Filme filme = verificadorFilme(nomeDoFilme);
        Sala sala = verificadorSala(numeroDaSala);
        if (filme != null) {
            for (Sala salas : minhasSalas) {
                if (salas.getFilmeEmExibicao() == filme && salas == sala) {
                    salas.setFilmeEmExibicao(null);
                    return true;
                }
            }
        }
        return false;
    }
}
