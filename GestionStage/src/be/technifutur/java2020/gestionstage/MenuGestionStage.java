package be.technifutur.java2020.gestionstage;

import be.technifutur.java2020.gestionstage.commun.*;

public class MenuGestionStage {

    /*
    FIELD
     */
    private String input = null;
    private DisplayHoraireCtrl displayHoraireCtrl;
    private ActivityCtrlCreateActivity activityCtrlCreateActivity;
    private ParticipantCtrlAdd participantCtrlAdd;
    private ParticipantCtrlDisplay participantCtrlDisplay;
    private ParticipantCtrlRemove participantCtrlRemove;
    private StageList stageList;
    private User user;
    private Utility utility;



    /*
    METHOD
     */

    public void menu() {
        String nomStage;
        Stage stage;
        nomStage = utility.saisirName("Veuillez saisir le nom du stage à gérer. Insérer \"q\" pour quitter.");
        while (!stageList.containsKey(nomStage) && !nomStage.isEmpty()) {
            nomStage = utility.saisirName("Ce stage n'existe pas.\nVeuillez saisir le nom du stage à gérer. Insérer \"q\" pour quitter.");
        }
        if (!nomStage.isEmpty()) {
            stage = stageList.getStage(nomStage);
            showMenu();
            input = user.getInput();
            while (!(input.equalsIgnoreCase("q"))) {
                switch (input) {
                    case "1":
                        activityCtrlCreateActivity.createActivity(stage);
                        break;
                    case "2":
                        displayHoraireCtrl.displayHoraireStage(stage);
                        break;
                    case "3":
                        participantCtrlAdd.ajouterParticipant(stage);
                        break;
                    case "4":
                        participantCtrlRemove.removeParticipant(stage);
                        break;
                    case "5":
                        participantCtrlDisplay.displayParticipant(stage);
                        break;

                }
                showMenu();
                input = user.getInput();
            }
        }
    }

    private void showMenu() {
        System.out.println("" +
                "Veuillez choisir une option.\n" +
                "1. Ajouter une activitée à un stage.\n" +
                "2. Afficher les activitées d'un stage\n" +
                "3. Ajouter un participant\n" +
                "4. Retirer un participant\n" +
                "5. Liste des participant\n" +
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

    public void setParticipantCtrlAdd(ParticipantCtrlAdd participantCtrlAdd) {
        this.participantCtrlAdd = participantCtrlAdd;
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

    public void setParticipantCtrlDisplay(ParticipantCtrlDisplay participantCtrlDisplay) {
        this.participantCtrlDisplay = participantCtrlDisplay;
    }

    public void setStageList(StageList stageList) {
        this.stageList = stageList;
    }


    public void setParticipantCtrlRemove(ParticipantCtrlRemove participantCtrlRemove) {
        this.participantCtrlRemove = participantCtrlRemove;
    }
}
