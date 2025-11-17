package Cinema;

import java.util.Scanner;

public class MenuFilme {
    public static void menu() {
        Scanner input = new Scanner(System.in);
        int escolha;
        do {
            System.out.println("\n---- MENU FILMES ----");
            System.out.println("1 - Cadastrar filme sem sala");
            System.out.println("2 - Exibir filmes");
            System.out.println("3 - Avaliar filme");
            System.out.println("4 - Colocar filme em sala");
            System.out.println("5 - Remover filme");
            System.out.println("6 - Remover filme de sala");
            System.out.println("0 - Voltar");
            escolha = input.nextInt();

            switch (escolha) {
                case 1: {
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
                    Filme novoFilme = new Filme(nomeDoFilme, generoDoFilme, duracaoMinutos);
                    Cinema.cadastrarFilmeSemSala(novoFilme);
                    break;
                }
                case 2: {
                    Cinema.exibirFilmes();
                    break;
                }
                case 3: {
                    String nomeDoFilme;
                    double nota;
                    System.out.println("Digite o nome do filme:");
                    input.nextLine();
                    nomeDoFilme = input.nextLine();
                    System.out.println("Digite uma nota de 0 a 5");
                    nota = input.nextDouble();
                    if (nota >= 0 && nota <= 5) {
                        Cinema.avaliarFilme(nomeDoFilme, nota);
                    }
                    break;
                }
                case 4: {
                    String numeroDaSala;
                    String nomeDoFilme;
                    System.out.println("Digite o numero da sala: ");
                    input.nextLine();
                    numeroDaSala = input.nextLine();
                    System.out.println("Digite o nome do filme:");
                    nomeDoFilme = input.nextLine();
                    Cinema.colocarFilmeSemSalaEmSala(numeroDaSala, nomeDoFilme);
                    break;
                }
                case 5: {
                    String nomeDoFilme;
                    System.out.println("Digite o nome do filme: ");
                    input.nextLine();
                    nomeDoFilme = input.nextLine();
                    Cinema.removerFilme(nomeDoFilme);
                    break;
                }
            }
        } while (escolha != 0);
    }
}