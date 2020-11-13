package be.technifutur.java2020.gestionstage.commun.stage.modifstage;

import be.technifutur.java2020.gestionstage.commun.Utility;
import be.technifutur.java2020.gestionstage.commun.Vue;
import be.technifutur.java2020.gestionstage.commun.stage.Stage;

import java.time.LocalDateTime;
import java.util.Date;

public class StageCtrlModifDateDebut {

    /*
    FIELD
    */
    private Vue vue;
    private Utility utility;


    /*
    METHOD
    */
    public void run(Stage stage) {
        LocalDateTime oldDate, newDate;
        boolean confirmModif;
        oldDate = stage.getDateDebut();
        vue.afficheMessage("Date de début actuelle : ");
        vue.afficheDate(oldDate);
        vue.ajoutDateDebut();
        newDate = utility.saisirDate();
        if (newDate.isBefore(oldDate)) {
            if (!newDate.isEqual(oldDate)) {
                if (newDate.isBefore(stage.getDateFin())) {
                    vue.afficheMessage("Ancienne date : ");
                    vue.afficheDate(oldDate);
                    vue.afficheMessage("Nouvelle date : ");
                    vue.afficheDate(newDate);
                    confirmModif = utility.returnBoolTrueFalse("Voulez-vous modifier la date ? O/N");
                    if (confirmModif) {
                        stage.setDateDebut(newDate);
                    }
                } else {
                    vue.afficheMessage("Date non valide.\n La date de début doit être avant la date de fin.");
                }
            } else {
                vue.afficheMessage("Les dates sont les mêmes");
            }
        }
        else {
            System.out.println("Fonctionnatilée prévue pour plus tard ! Merci de patience !");
        }

    }


    /*
    SETTER AND GETTER
    */

    public void setVue(Vue vue) {
        this.vue = vue;
    }

    public void setUtility(Utility utility) {
        this.utility = utility;
    }

}
