import java.util.Scanner;

public class Filme {
    private String nomeFilme;
    private String generoFilme;
    private int duracaoMinutos;
    private double classificacaoFilme;
    public static final int QUANTIDADE_DE_INGRESSOS_DISPONIVEIS = 50;
    private double[] notaFilme = new double[QUANTIDADE_DE_INGRESSOS_DISPONIVEIS];
    private int quantidadeDeAvaliacoes = 0;

    Scanner input = new Scanner(System.in);

    public Filme(String nomeFilme, String generoFilme, int duracaoMinutos, double classificacaoFilme) {

    }

    public void setnomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }

    public void setGeneroFilme(String generoFilme) {
        this.generoFilme = generoFilme;
    }

    public void setDuracaoMinutos(int duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
    }

    public void setClassificacaoFilme(double classificacaoFilme) {
        this.classificacaoFilme = classificacaoFilme;
    }

    public void setNotaFilme(int indice, double nota) {
        this.notaFilme[indice] = nota;
        indice++;
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
        notaFilme[quantidadeDeAvaliacoes++] = nota;
    }


    public void mediaNotaFilme() {
        double notasSoma = 0;
        for (int i = 0; i <quantidadeDeAvaliacoes; i++) {
            notasSoma+=notaFilme[i];
        }
        classificacaoFilme = notasSoma / quantidadeDeAvaliacoes;
    }

}


