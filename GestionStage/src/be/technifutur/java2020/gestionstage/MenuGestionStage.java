package be.technifutur.java2020.gestionstage;

import be.technifutur.java2020.gestionstage.commun.*;
import be.technifutur.java2020.gestionstage.commun.activity.ActivityCtrlCreateActivity;
import be.technifutur.java2020.gestionstage.commun.participant.ParticipantCtrlAdd;
import be.technifutur.java2020.gestionstage.commun.participant.ParticipantCtrlDisplay;
import be.technifutur.java2020.gestionstage.commun.participant.ParticipantCtrlRemove;
import be.technifutur.java2020.gestionstage.commun.stage.DisplayHoraireCtrl;
import be.technifutur.java2020.gestionstage.commun.stage.Stage;
import be.technifutur.java2020.gestionstage.commun.stage.StageCtrlModif;
import be.technifutur.java2020.gestionstage.commun.stage.StageList;

import java.io.IOException;

public class MenuGestionStage {

    /*
    FIELD
     */
    private StageList stageList;
    private Vue vue;
    private User user;
    private Utility utility;
    private DataBase dataBase;
    private DisplayHoraireCtrl displayHoraireCtrl;
    private ActivityCtrlCreateActivity activityCtrlCreateActivity;
    private ParticipantCtrlAdd participantCtrlAdd;
    private ParticipantCtrlDisplay participantCtrlDisplay;
    private ParticipantCtrlRemove participantCtrlRemove;
    private MenuGestionActivity menuGestionActivity;
    private StageCtrlModif stageCtrlModif;



    /*
    METHOD
     */

    public void menu() {
        String nomStage, input;
        Stage stage;
        nomStage = utility.saisirName("Veuillez saisir le nom du stage à gérer. Insérer \"q\" pour quitter.");
        while (!stageList.containsKey(nomStage) && !nomStage.isEmpty()) {
            nomStage = utility.saisirName("Ce stage n'existe pas.\nVeuillez saisir le nom du stage à gérer. Insérer \"q\" pour quitter.");
        }
        if (!nomStage.isEmpty()) {
            stage = stageList.getStage(nomStage);
            vue.afficheMessage("Gestion du stage : " + stage.getIntituleStage());
            showMenu();
            input = user.getInput();
            while (!(input.equalsIgnoreCase("q"))) {
                switch (input) {
                    case "1":
                        stageCtrlModif.modifStage(stage);
                        break;
                    case "2":
                        activityCtrlCreateActivity.createActivity(stage);
                        break;
                    case "3":
                        displayHoraireCtrl.displayHoraireStage(stage);
                        break;
                    case "4":
                        //TODO modifier activité
                        break;
                    case "5":
                        participantCtrlAdd.ajouterParticipant(stage);
                        break;
                    case "6":
                        participantCtrlRemove.removeParticipant(stage);
                        break;
                    case "7":
                        participantCtrlDisplay.displayParticipant(stage);
                        break;
                    case "8":
                        menuGestionActivity.DisplayMenu(stage);
                        break;

                }
                vue.afficheMessage("Gestion du stage : " + stage.getIntituleStage());
                showMenu();
                input = user.getInput();
            }
        }
        try {
            dataBase.saveData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showMenu() {
        System.out.println("" +
                "Veuillez choisir une option.\n" +
                "1. Modifier le stage.\n" +
                "2. Ajouter une activitée au stage.\n" +
                "3. Afficher l'horaire du stage.\n" +
                "4. Modifier une activité du stage.\n" +
                "5. Ajouter un participant au stage.\n" +
                "6. Retirer un participant du stage.\n" +
                "7. Liste des participant du stage.\n" +
                "8. Gestion des activité du stage.\n" +
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

    public void setMenuGestionActivity(MenuGestionActivity menuGestionActivity) {
        this.menuGestionActivity = menuGestionActivity;
    }

    public void setDataBase(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public void setVue(Vue vue) {
        this.vue = vue;
    }

    public void setStageCtrlModif(StageCtrlModif stageCtrlModif) {
        this.stageCtrlModif = stageCtrlModif;
    }
}
