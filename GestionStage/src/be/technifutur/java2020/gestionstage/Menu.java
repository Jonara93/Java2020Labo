package be.technifutur.java2020.gestionstage;

import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    String input = null;

    public void displayMenu() {
        showMenu();
        input = scanner.nextLine();
        while (!(input.equalsIgnoreCase("q"))) {
            int choice = (Integer.parseInt(input));
            switch (choice){
                case 1 :
                    break;
            }
        }
    }

    private void showMenu() {
        System.out.println("" +
                "Veuillez choisir une option.\n" +
                "1. Créer un stage.\n" +
                "q. Quitter l'application.");
    }
}
