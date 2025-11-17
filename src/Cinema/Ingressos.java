package Cinema;

public class Ingressos {
    private int capacidadeIngressos;
    private int ingressosVendidos;

    public Ingressos(int capacidadeIngressos) {
        setCapacidadeIngressos(capacidadeIngressos);
    }

    public void setCapacidadeIngressos(int capacidadeIngressos) {
        this.capacidadeIngressos = capacidadeIngressos;
    }
    public int getCapacidadeIngressos(){
        return capacidadeIngressos;
    }
    public int getIngressosVendidos(){
        return ingressosVendidos;
    }
    public boolean venderIngressos() {
        if(ingressosVendidos<capacidadeIngressos){
            ingressosVendidos++;
            return true;
        }
        return false;
    }
}
