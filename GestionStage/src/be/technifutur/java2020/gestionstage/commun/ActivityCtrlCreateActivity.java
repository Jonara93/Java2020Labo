package be.technifutur.java2020.gestionstage.commun;

import be.technifutur.java2020.gestionstage.DataBase;
import be.technifutur.java2020.gestionstage.exception.ExceptionGestionStage;
import be.technifutur.java2020.gestionstage.exception.ExceptionGestionStageNomInvalide;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Collection;
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
        String nameActivity = null;
        int duration = 0;
        LocalDateTime dateDebut = null;
        boolean addActivityToStage = true;


        vue.afficheMessage("Veuillez choisir un nom d'activitée ou insérer \"q\" pour quitter");
        nameActivity = user.getInput();
        while (nameActivity.isEmpty()) {
            vue.afficheMessage("Veuillez choisir un nom d'activitée ou insérer \"q\" pour quitter");
            nameActivity = user.getInput();
        }

        if (nameActivity.equalsIgnoreCase("q")) {
            addActivityToStage = false;
        }

        if (addActivityToStage) {
            vue.ajoutDateDebut();
            dateDebut = utility.saisirDate();
            if (dateDebut == null) {
                addActivityToStage = false;
            }
        }

        if (addActivityToStage) {
            OptionalInt inputDuration;
            vue.consigneAjoutDuree();
            inputDuration = utility.saisirDuree();
            if (inputDuration.isEmpty()) {
                addActivityToStage = false;
            } else {
                duration = inputDuration.getAsInt();
            }
        }

        if (addActivityToStage) {
            try {
                stage.addActivity(dateDebut, duration, nameActivity);
                dataBase.saveData();
            } catch (ExceptionGestionStage e) {
                vue.setError(e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
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
