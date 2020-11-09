package be.technifutur.java2020.gestionstage;

import be.technifutur.java2020.gestionstage.commun.*;

public class Menu {
    private String input = null;
    private StageCtrlCreateStage stageCtrlCreateStage;
    private StageCtrlDisplayStage stageCtrlDisplayStage;
    private ParticipantCtrlDisplay participantCtrlDisplay;
    private MenuGestionStage menuGestionStage;
    private User user;


    public void displayMenu() {
        showMenu();
        input = user.getInput();
        while (!(input.equalsIgnoreCase("q"))) {
            int choice = (Integer.parseInt(input));
            switch (choice) {
                case 1:
                    stageCtrlCreateStage.createStage();
                    break;
                case 2:
                    stageCtrlDisplayStage.displayStage();
                    break;
                case 3:
                    menuGestionStage.menu();
                    break;
                case 4:
                    participantCtrlDisplay.displayParticipant();
                    break;

            }
            showMenu();
            input = user.getInput();
        }
    }

    private void showMenu() {
        System.out.println("" +
                "Veuillez choisir une option.\n" +
                "1. Créer un stage.\n" +
                "2. Afficher les stages\n" +
                "3. Gestion des stages.\n" +
                "4. Afficher les participants\n" + // gestion des stages
                "q. Quitter l'application.");
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setStageCtrlCreateStage(StageCtrlCreateStage stageCtrlCreateStage) {
        this.stageCtrlCreateStage = stageCtrlCreateStage;
    }

    public void setStageCtrlDisplayStage(StageCtrlDisplayStage stageCtrlDisplayStage) {
        this.stageCtrlDisplayStage = stageCtrlDisplayStage;
    }

    public void setMenuGestionStage(MenuGestionStage menuGestionStage) {
        this.menuGestionStage = menuGestionStage;
    }

    public void setParticipantCtrlDisplay(ParticipantCtrlDisplay participantCtrlDisplay) {
        this.participantCtrlDisplay = participantCtrlDisplay;
    }
}
