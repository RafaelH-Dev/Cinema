package Cinema;

public class Sala {
    private String numeroSala;
    private int capacidadeIngressos;
    private Filme filmeEmExibicao;
    private Ingressos ingresso;

    public Sala(String numeroSala, int capacidadeIngressos) {
        setNumeroSala(numeroSala);
        setCapacidadeIngressos(capacidadeIngressos);
        ingresso = new Ingressos(capacidadeIngressos);
    }

    public Sala(String numeroSala, Filme filmeEmExibicao, int capacidadeIngressos) {
        setNumeroSala(numeroSala);
        setFilmeEmExibicao(filmeEmExibicao);
        setCapacidadeIngressos(capacidadeIngressos);
        ingresso = new Ingressos(capacidadeIngressos);

    }

    public void setCapacidadeIngressos(int capacidadeIngressos) {
        this.capacidadeIngressos = capacidadeIngressos;
    }

    public void setNumeroSala(String numeroSala) {
        this.numeroSala = numeroSala;
    }

    public void setFilmeEmExibicao(Filme filmeEmExibicao) {
        this.filmeEmExibicao = filmeEmExibicao;
    }

    public String getNumeroSala() {
        return numeroSala;
    }

    public int getCapacidadeIngressos() {
        return capacidadeIngressos;
    }

    public Filme getFilmeEmExibicao() {
        return filmeEmExibicao;
    }

    public String getNomeFilmeOuPadrao() {
        if (filmeEmExibicao == null) {
            return "Filme não cadastrado";
        }
        return filmeEmExibicao.getNomeFilme();
    }

    public double getAvaliacaoFilmeOuZero() {
        if (filmeEmExibicao == null) {
            return 0.0;
        }
        return filmeEmExibicao.getClassificacaoFilme();
    }

    public boolean venderIngresso() {
        return ingresso.venderIngressos();
    }

    @Override
    public String toString() {
        return String.format(
                "Número da sala: %s\nCapacidade de ingressos: %d\nIngressos vendidos: %d\nFilme em exibição: %s\nAvaliação do Filme: %.1f",
                getNumeroSala(),
                getCapacidadeIngressos(),
                ingresso.getIngressosVendidos(),
                getNomeFilmeOuPadrao(),
                getAvaliacaoFilmeOuZero()
        );
    }
}
