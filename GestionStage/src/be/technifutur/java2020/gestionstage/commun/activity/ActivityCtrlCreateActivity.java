package be.technifutur.java2020.gestionstage.commun.activity;

import be.technifutur.java2020.gestionstage.DataBase;
import be.technifutur.java2020.gestionstage.commun.stage.Stage;
import be.technifutur.java2020.gestionstage.commun.User;
import be.technifutur.java2020.gestionstage.commun.Utility;
import be.technifutur.java2020.gestionstage.commun.Vue;
import be.technifutur.java2020.gestionstage.exception.ExceptionGestionStage;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.OptionalInt;

public class ActivityCtrlCreateActivity {
    /*
    FIELD
     */
    private Utility utility;
    private Vue vue;
    private User user;
    private DataBase dataBase;

    /*
    METHOD
     */

    public void createActivity(Stage stage) {
        vue.afficheStage(stage);
        String nameActivity;
        int duration = 0;
        LocalDateTime dateDebut;
        nameActivity = utility.saisirName("Veuillez choisir un nom d'activitée ou insérer \"q\" pour quitter");
        if (!nameActivity.isEmpty()) {
            vue.ajoutDateDebut();
            dateDebut = utility.saisirDate();
            if (dateDebut != null) {
                OptionalInt inputDuration;
                vue.consigneAjoutDuree();
                inputDuration = utility.saisirDuree();
                if (!inputDuration.isEmpty()) {
                    duration = inputDuration.getAsInt();
                }

                if (!inputDuration.isEmpty()) {
                    try {
                        stage.addActivity(dateDebut, duration, nameActivity);
                        dataBase.saveData();
                    } catch (ExceptionGestionStage | IOException e) {
                        vue.setError(e.getMessage());
                    }
                }
            }
        }
    }

    /*
    SETTER AND GETTER
     */

    public void setUtility(Utility utility) {
        this.utility = utility;
    }

    public void setVue(Vue vue) {
        this.vue = vue;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setDataBase(DataBase dataBase) {
        this.dataBase = dataBase;
    }
}
