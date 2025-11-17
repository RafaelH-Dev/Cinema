package Cinema;

import java.util.Scanner;

public class MenuSala {
    public static void menu() {
        Scanner input = new Scanner(System.in);
        int escolha;

        do {
            System.out.println("\n---- MENU SALAS ----");
            System.out.println("1 - Cadastrar sala");
            System.out.println("2 - Exibir salas");
            System.out.println("3 - Vender ingresso");
            System.out.println("4 - Remover sala");
            System.out.println("0 - Voltar");
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
                    Sala sala = new Sala(numeroDaSala, capacidadeDeIngressos);
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
                    if (Cinema.venderIngressos(numeroDaSala)) {
                        System.out.println("Ingresso vendido!");
                    } else {
                        System.out.println("Ingressos esgotados!");
                    }
                    break;
                }
                case 4: {
                    String numeroDaSala;
                    System.out.println("Digite o numero da sala: ");
                    input.nextLine();
                    numeroDaSala = input.nextLine();
                    Cinema.removeSala(numeroDaSala);
                    break;
                }
                case 5:{
                    String nomeDoFilme;
                    String numeroDaSala;
                    System.out.println("Digite o numero da sala: ");
                    input.nextLine();
                    numeroDaSala = input.nextLine();
                    System.out.println("Digite o nome do filme: ");
                    nomeDoFilme = input.nextLine();
                    Cinema.removerFilmeDaSala(numeroDaSala,nomeDoFilme);
                    break;
                }
            }
        } while (escolha != 0);
    }
}
