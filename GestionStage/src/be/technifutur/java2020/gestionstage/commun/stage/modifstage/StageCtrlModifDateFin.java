package be.technifutur.java2020.gestionstage.commun.stage.modifstage;


import be.technifutur.java2020.gestionstage.commun.Utility;
import be.technifutur.java2020.gestionstage.commun.Vue;
import be.technifutur.java2020.gestionstage.commun.stage.Stage;

import java.time.LocalDateTime;

public class StageCtrlModifDateFin {
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
        oldDate = stage.getDateFin();

        vue.afficheMessage("Date de fin actuelle : ");
        vue.afficheDate(oldDate);

        vue.ajoutDateFin();
        newDate = utility.saisirDate();
        if (newDate.isAfter(oldDate)) {
            if (!newDate.isEqual(oldDate)) {
                if (newDate.isAfter(stage.getDateFin())) {
                    vue.afficheMessage("Ancienne date : ");
                    vue.afficheDate(oldDate);
                    vue.afficheMessage("Nouvelle date : ");
                    vue.afficheDate(newDate);
                    confirmModif = utility.returnBoolTrueFalse("Voulez-vous modifier la date ? O/N");
                    if (confirmModif) {
                        stage.setDateFin(newDate);
                    }
                } else {
                    vue.afficheMessage("Date non valide.\nLa date de fin doit être après la date de fin originale.");
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
