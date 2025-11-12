import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int escolha;
        do {

            System.out.println("1 - Cadastrar sala");
            System.out.println("2 - Exibir salas");
            System.out.println("3 - Exibir filmes disponíveis");
            System.out.println("4 - Vender ingresso");
            System.out.println("5 - Avaliar filme");
            System.out.println("6 - Cadastrar filme em uma sala");
            System.out.println("7 - Cadastrar filme sem sala");
            System.out.println("8 - Colocar um filme sem sala em uma sala");
            System.out.println("9 - Remover um filme");
            System.out.println("10 - Remover uma Sala");
            System.out.println("11 - Sair");
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
                case 3:{
                    Cinema.exibirFilmes();
                    break;
                }
                case 4: {
                    String numeroDaSala;
                    System.out.println("Digite o numero da sala: ");
                    input.nextLine();
                    numeroDaSala = input.nextLine();
                    if (Cinema.venderIngressos(numeroDaSala)) {
                        System.out.println("Ingresso vendido!");
                    } else {
                        System.out.println("Ingressos esgotados!");
                    }
                    break;
                }
                case 5: {
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
                case 6: {
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
                    break;
                }
                case 7:{
                    String nomeDoFilme;
                    String generoDoFilme;
                    int duracaoMinutos;
                    System.out.println("Digite o nome do filme: ");
                    input.nextLine();
                    nomeDoFilme = input.nextLine();
                    System.out.println("Digite o gênero do filme: ");
                    generoDoFilme = input.nextLine();
                    System.out.println("Digite a duração em minutos do filme: ");
                    duracaoMinutos = input.nextInt();
                    Filme novoFilme = new Filme(nomeDoFilme,generoDoFilme,duracaoMinutos);
                    Cinema.cadastrarFilmeSemSala(novoFilme);
                    break;
                }
                case 8:{
                    String numeroDaSala;
                    String nomeDoFilme;
                    System.out.println("Digite o numero da sala: ");
                    input.nextLine();
                    numeroDaSala = input.nextLine();
                    System.out.println("Digite o nome do filme:");
                    nomeDoFilme = input.nextLine();
                    Cinema.colocarFilmeSemSalaEmSala(numeroDaSala,nomeDoFilme);
                    break;
                }
                case 9: {
                    String nomeDoFilme;
                    System.out.println("Digite o nome do filme: ");
                    input.nextLine();
                    nomeDoFilme = input.nextLine();
                    Cinema.removerFilme(nomeDoFilme);
                    break;
                }
                case 10: {
                    String numeroDaSala;
                    System.out.println("Digite o numero da sala: ");
                    input.nextLine();
                    numeroDaSala = input.nextLine();
                    Cinema.removeSala(numeroDaSala);
                    break;
                }
            }
        } while (escolha != 11);
    }
}