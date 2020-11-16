package be.technifutur.java2020.gestionstage.commun.stage;

import be.technifutur.java2020.gestionstage.DataBase;
import be.technifutur.java2020.gestionstage.commun.User;
import be.technifutur.java2020.gestionstage.commun.Utility;
import be.technifutur.java2020.gestionstage.commun.Vue;
import be.technifutur.java2020.gestionstage.commun.tarif.Tarif;
import be.technifutur.java2020.gestionstage.commun.tarif.TarifBase;
import be.technifutur.java2020.gestionstage.commun.tarif.TarifList;
import be.technifutur.java2020.gestionstage.exception.ExceptionGestionStage;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class StageCtrlCreateStage {
    /*
    FIELD
     */

    private Vue vue;
    private Utility utility;
    private StageList stageList;
    private User user;
    private DataBase dataBase;
    private TarifList tarifList;
    /*
    METHOD
     */

    public void createStage() {
        String name;
        LocalDateTime dateDebut, dateFin = null;
        boolean insertStage = true;

        name = utility.saisirName("Veuillez choisir un nom de stage ou insérer \"q\" pour quitter");
        if (!name.isEmpty()) {
            vue.ajoutDateDebut();
            dateDebut = utility.saisirDate();
            if (dateDebut == null) {
                insertStage = false;
            }
            if (insertStage) {
                vue.ajoutDateFin();
                dateFin = utility.saisirDate();
                if (dateFin == null) {
                    insertStage = false;
                }
            }
            if (insertStage) {
                try {
                    stageList.addStage(dateDebut, dateFin, name);
                    Stage stage = stageList.getStage(name);
                    stage.getTarifAppliquable().add(new TarifBase());
                    utility.choiceTarifToAdd(tarifList, stage);
                    vue.afficheStage(stage);
                    dataBase.saveData();
                } catch (ExceptionGestionStage | IOException e) {
                    vue.setError(e.getMessage());
                }
            }
        }
    }

    /*
    SETTER
     */
    public void setUser(User user) {
        this.user = user;
    }

    public void setStageList(StageList stageList) {
        this.stageList = stageList;
    }

    public void setUtility(Utility utility) {
        this.utility = utility;
    }

    public void setVue(Vue vue) {
        this.vue = vue;
    }

    public void setDataBase(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public void setTarifList(TarifList tarifList) {
        this.tarifList = tarifList;
    }
}
