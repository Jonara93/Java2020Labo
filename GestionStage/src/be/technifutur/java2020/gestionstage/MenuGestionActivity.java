package be.technifutur.java2020.gestionstage;

import be.technifutur.java2020.gestionstage.commun.*;
import be.technifutur.java2020.gestionstage.commun.activity.Activity;
import be.technifutur.java2020.gestionstage.commun.activity.ActivityCtrlDisplayParticipant;
import be.technifutur.java2020.gestionstage.commun.activity.ActivityCtrlInscription;
import be.technifutur.java2020.gestionstage.commun.activity.ActivityCtrlRemoveParticipant;
import be.technifutur.java2020.gestionstage.commun.comparator.MyComparatorActivity;
import be.technifutur.java2020.gestionstage.commun.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MenuGestionActivity {
    /*
    FIELD
    */
    private Utility utility;
    private User user;
    private Vue vue;
    private DataBase dataBase;
    private ActivityCtrlInscription activityCtrlInscription;
    private ActivityCtrlDisplayParticipant activityCtrlDisplayParticipant;
    private ActivityCtrlRemoveParticipant activityCtrlRemoveParticipant;
    /*
    METHOD
    */

    public void DisplayMenu(Stage stage) {
        String nameActivity, input;
        Activity activity;
        List<Activity> activityList = new ArrayList<>(stage.getActivityCollection());
        activityList.sort(new MyComparatorActivity());
        // afficher les activités disponnible pour ce stage
        vue.afficheHoraire(stage, activityList);
        // choix de l'activité
        nameActivity = utility.saisirName("Veuillez saisir le nom de l'activité à gérer. Insérer \"q\" pour quitter.");
        while (!stage.containsKeyActivity(nameActivity) && !nameActivity.isEmpty()) {
            nameActivity = utility.saisirName("Cette activité n'existe pas.\nVeuillez saisir le nom l'activité à gérer. Insérer \"q\" pour quitter.");
        }
        if (!nameActivity.isEmpty()) {
            activity = stage.getActivity(nameActivity);
            vue.afficheMessage("Gestion de l'activité : " + activity.getNameActivity());
            showMenu();
            input = user.getInput();
            while (!(input.equalsIgnoreCase("q"))) {
                switch (input) {
                    case "1":
                        activityCtrlInscription.inscriptionActivity(stage, activity);
                        break;
                    case "2":
                        activityCtrlRemoveParticipant.removeParticipant(activity);
                        break;
                    case "3":
                        activityCtrlDisplayParticipant.DisplayParticipant(activity);
                        break;
                }
                vue.afficheMessage("Gestion de l'activité : " + activity.getNameActivity());
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
                "1. Inscrire un participant à cette activité.\n" +
                "2. Supprimer un participant de l'activité.\n" +
                "3. Afficher les participants de l'activité.\n" +
                "q. Quitter l'application.");
    }
    
    /*
    SETTER AND GETTER
    */

    public void setUtility(Utility utility) {
        this.utility = utility;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setActivityCtrlInscription(ActivityCtrlInscription activityCtrlInscription) {
        this.activityCtrlInscription = activityCtrlInscription;
    }

    public void setVue(Vue vue) {
        this.vue = vue;
    }

    public void setActivityCtrlDisplayParticipant(ActivityCtrlDisplayParticipant activityCtrlDisplayParticipant) {
        this.activityCtrlDisplayParticipant = activityCtrlDisplayParticipant;
    }

    public void setDataBase(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public void setActivityCtrlRemoveParticipant(ActivityCtrlRemoveParticipant activityCtrlRemoveParticipant) {
        this.activityCtrlRemoveParticipant = activityCtrlRemoveParticipant;
    }
}
