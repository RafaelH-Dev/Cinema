public class Sala {
    private int numeroSala;
    private int capacidadeIngressos;
    private int ingressosVendidos;
    private Filme filmeExibicao;
    public int[] ingressosCinema = new int[50];

    public Sala(int numeroSala, int capacidadeIngressos, Filme filmeExibicao){

    }
    public void setNumeroSala(int numeroSala){
        this.numeroSala = numeroSala;
    }
    public void setCapacidadeIngressos(int capacidadeIngressos) {
        this.capacidadeIngressos = capacidadeIngressos;
    }
    public void setIngressosVendidos(int ingressosVendidos){
        this.ingressosVendidos = ingressosVendidos;
    }
    public void setFilmeExibicao(Filme filmeExibicao){
        this.filmeExibicao = filmeExibicao;
    }
    public int getNumeroSala(){
        return numeroSala;
    }
    public int getCapacidadeIngressos(){
        return capacidadeIngressos;
    }
    public int getIngressosVendidos(){
        return ingressosVendidos;
    }
    public Filme getFilmeExibicao(){
        return filmeExibicao;
    }
    public void venderIngresso(){

    }
}
