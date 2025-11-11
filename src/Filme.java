import java.util.ArrayList;

public class Filme {
    private String nomeFilme;
    private String generoFilme;
    private int duracaoMinutos;
    private double classificacaoFilme;
    ArrayList<Double> notas = new ArrayList<Double>();

    public Filme(String nomeFilme, String generoFilme, int duracaoMinutos) {
        setNomeFilme(nomeFilme);
        setGeneroFilme(generoFilme);
        setDuracaoMinutos(duracaoMinutos);

    }

    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }

    public void setGeneroFilme(String generoFilme) {
        this.generoFilme = generoFilme;
    }

    public void setDuracaoMinutos(int duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
    }

    public String getNomeFilme() {
        return nomeFilme;
    }

    public String getGeneroFilme() {
        return generoFilme;
    }

    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public double getClassificacaoFilme() {
        return classificacaoFilme;
    }

    public void avaliarFilme(double nota) {
        notas.add(nota);
        mediaNotaFilme();
    }

    public void mediaNotaFilme() {
        if (notas.isEmpty()) {
            classificacaoFilme = 0;
        } else {
            double notasSoma = 0;
            for (double nota : notas) {
                notasSoma += nota;
            }
            classificacaoFilme = notasSoma / notas.size();
        }
    }
}


