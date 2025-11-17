import Cinema.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int escolha;
        do {
            System.out.println("\n---- MENU PRINCIPAL ----");
            System.out.println("1 - Menu Salas");
            System.out.println("2 - Menu Filmes");
            System.out.println("0 - Sair");
            escolha = input.nextInt();
            switch (escolha) {
                case 1: {
                    MenuSala.menu();
                    break;
                }
                case 2: {
                    MenuFilme.menu();
                    break;
                }
            }
        } while (escolha != 0);
    }
}
