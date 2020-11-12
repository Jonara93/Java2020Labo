package be.technifutur.java2020.gestionstage;

import be.technifutur.java2020.gestionstage.commun.*;
import be.technifutur.java2020.gestionstage.commun.ActivityCtrlInscription;
import be.technifutur.java2020.gestionstage.commun.comparator.MyComparatorActivity;

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
            showMenu();
            input = user.getInput();
            while (!(input.equalsIgnoreCase("q"))) {
                switch (input) {
                    case "1":
                        activityCtrlInscription.inscriptionActivity(stage, activity);
                        break;
                    case "2":
                        activityCtrlDisplayParticipant.DisplayParticipant(activity);
                        break;
                }
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
                "1. Inscrire un participant du stage à une activité.\n" +
                "2. Afficher les participants de l'activité.\n" +
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
}
