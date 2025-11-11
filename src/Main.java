import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int escolha;
        do {

            System.out.println("1 - Cadastrar sala");
            System.out.println("2 - Exibir salas");
            System.out.println("3 - Vender ingresso");
            System.out.println("4 - Avaliar filme");
            System.out.println("5 - Cadastrar filme");
            System.out.println("6 - Sair");
            escolha = input.nextInt();

            switch (escolha) {
                case 1: {
                    String numeroDaSala;
                    int capacidadeDeIngressos;
                    System.out.println("Digite o numero da sala: ");
                    input.nextLine();
                    numeroDaSala = input.nextLine();
                    System.out.println("Digite a capacidade máxima da sala:");
                    capacidadeDeIngressos = input.nextInt();

                    Sala novaSala = new Sala(numeroDaSala, capacidadeDeIngressos);
                    break;
                }
                case 2: {
                    Cinema.exibirSalas();
                    break;
                }
                case 3: {
                    String numeroDaSala;
                    System.out.println("Digite o numero da sala: ");
                    input.nextLine();
                    numeroDaSala = input.nextLine();
                    Cinema.venderIngressos(numeroDaSala);
                    break;
                }
                case 4: {
                    String numeroDaSala;
                    double nota;
                    System.out.println("Digite o numero da Sala: ");
                    input.nextLine();
                    numeroDaSala = input.nextLine();
                    System.out.println("Digite uma nota de 0 a 5");
                    nota = input.nextDouble();
                    if (nota >= 0 && nota <= 5) {
                        Cinema.avaliarFilme(numeroDaSala, nota);
                    }
                    break;
                }
                case 5: {
                    String numeroDaSala;
                    String nomeDoFilme;
                    String generoDoFilme;
                    int duracaoMinutos;
                    System.out.println("Digite o nome do filme: ");
                    input.nextLine();
                    nomeDoFilme = input.nextLine();
                    System.out.println("Digite o gênero do filme: ");
                    generoDoFilme = input.nextLine();
                    System.out.println("Digite a duração do filme em minutos: ");
                    duracaoMinutos = input.nextInt();
                    System.out.println("Digite o numero da sala: ");
                    input.nextLine();
                    numeroDaSala = input.nextLine();
                    Filme novoFilme = new Filme(nomeDoFilme, generoDoFilme, duracaoMinutos);
                    Cinema.cadastrarFilme(numeroDaSala, novoFilme);
                }
            }
        } while (escolha != 6);
    }
}