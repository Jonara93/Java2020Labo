package be.technifutur.java2020.gestionstage;

import be.technifutur.java2020.gestionstage.commun.*;

public class MenuGestionStage {

    /*
    FIELD
     */
    private String input = null;
    private DisplayHoraireCtrl displayHoraireCtrl;
    private ActivityCtrlCreateActivity activityCtrlCreateActivity;
    private ParticipantCtrlGestion participantCtrlGestion;
    private User user;
    private Utility utility;


    /*
    METHOD
     */

    public void menu() {
        showMenu();
        input = user.getInput();
        while (!(input.equalsIgnoreCase("q"))) {
            int choice = (Integer.parseInt(input));
            switch (choice) {
                case 1:
                    activityCtrlCreateActivity.createActivity();
                    break;
                case 2:
                    displayHoraireCtrl.displayHoraireStage();
                    break;
                case 3:
                    participantCtrlGestion.gestionParticipant();
                    break;
            }
            showMenu();
            input = user.getInput();
        }
    }

    private void showMenu() {
        System.out.println("" +
                "Veuillez choisir une option.\n" +
                "1. Ajouter une activitée à un stage.\n" +
                "2. Afficher les activitées d'un stage\n" +
                "3. Gérer un participant\n"+
                // afficher participant
                "q. Quitter l'application.");
    }

    /*
    SETTER AND GETTER
     */

    public void setDisplayHoraireCtrl(DisplayHoraireCtrl displayHoraireCtrl) {
        this.displayHoraireCtrl = displayHoraireCtrl;
    }

    public void setActivityCtrlCreateActivity(ActivityCtrlCreateActivity activityCtrlCreateActivity) {
        this.activityCtrlCreateActivity = activityCtrlCreateActivity;
    }

    public void setParticipantCtrlGestion(ParticipantCtrlGestion participantCtrlGestion) {
        this.participantCtrlGestion = participantCtrlGestion;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setUtility(Utility utility) {
        this.utility = utility;
    }
}
