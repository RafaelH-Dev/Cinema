public class Sala {
    private String numeroSala;
    private int capacidadeIngressos;
    private int ingressosVendidos;
    private Filme filmeEmExibicao;

    public Sala(String numeroSala, int capacidadeIngressos) {
        setNumeroSala(numeroSala);
        setCapacidadeIngressos(capacidadeIngressos);
        Cinema.cadastrarSala(this);
    }

    public Sala(String numeroSala, Filme filmeEmExibicao, int capacidadeIngressos) {
        setNumeroSala(numeroSala);
        setFilmeEmExibicao(filmeEmExibicao);
        setCapacidadeIngressos(capacidadeIngressos);
        Cinema.cadastrarSala(this);

    }

    public void setCapacidadeIngressos(int capacidadeIngressos) {
        this.capacidadeIngressos = capacidadeIngressos;
    }

    public void setNumeroSala(String numeroSala) {
        this.numeroSala = numeroSala;
    }

    public void setIngressosVendidos(int ingressosVendidos) {
        this.ingressosVendidos = ingressosVendidos;
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

    public int getIngressosVendidos() {
        return ingressosVendidos;
    }

    public Filme getFilmeEmExibicao() {
        return filmeEmExibicao;
    }

    public void venderIngresso() {
        ingressosVendidos++;
    }

    public int ocupacaoDeIngressos() {
        return capacidadeIngressos - ingressosVendidos;
    }

    @Override
    public String toString() {
        return String.format(
                "Número da sala: %s\nCapacidade de ingressos: %d\nIngressos vendidos: %d\nFilme em exibição: %s",
                numeroSala, capacidadeIngressos, ingressosVendidos, getFilmeEmExibicao() == null?"Filme não cadastrado":filmeEmExibicao.getNomeFilme()
        );
    }

}
