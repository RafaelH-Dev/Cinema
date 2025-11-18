package Cinema;

public class Filme {
    private String nomeFilme;
    private String generoFilme;
    private int duracaoMinutos;


   private Notas notas = new Notas();

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
        return notas.getClassificacaoFilme();
    }
    public void adicionarNota(double nota){
        notas.adicionarNota(nota);
    }

    @Override
    public String toString() {
        return String.format("Filme: %s | Gênero: %s | Duração: %d min | Avaliação do filme: %.1f | Avaliações: %d",
                getNomeFilme(), getGeneroFilme(), getDuracaoMinutos(), getClassificacaoFilme(), notas.getAvaliacoes());
    }
}


