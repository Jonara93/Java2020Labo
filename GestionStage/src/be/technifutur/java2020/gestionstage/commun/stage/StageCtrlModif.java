package be.technifutur.java2020.gestionstage.commun.stage;

import be.technifutur.java2020.gestionstage.DataBase;
import be.technifutur.java2020.gestionstage.commun.Utility;
import be.technifutur.java2020.gestionstage.commun.Vue;
import be.technifutur.java2020.gestionstage.commun.stage.modifstage.StageCtrlModifDateDebut;
import be.technifutur.java2020.gestionstage.commun.stage.modifstage.StageCtrlModifDateFin;
import be.technifutur.java2020.gestionstage.commun.stage.modifstage.StageCtrlModifName;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class StageCtrlModif {
    /*
    FIELD
    */
    private Utility utility;
    private Vue vue;
    private StageCtrlModifDateDebut stageCtrlModifDateDebut;
    private StageCtrlModifDateFin stageCtrlModifDateFin;
    private StageCtrlModifName stageCtrlModifName;
    private DataBase dataBase;

    /*
    METHOD
    */

    public void modifStage(Stage stage) {
        String inputChoice;
        boolean modifOk;
        vue.afficheStage(stage);
        modifOk = utility.returnBoolTrueFalse("Voulez-vous modifier les données du stage ? O/N");
        while (modifOk) {
            inputChoice = utility.saisirName(menuModif());
            if (!inputChoice.isEmpty() && !inputChoice.equalsIgnoreCase("q")) {
                switch (inputChoice) {
                    case "1":
                        stageCtrlModifName.run(stage);
                        break;
                    case "2":
                        stageCtrlModifDateDebut.run(stage);
                        break;
                    case "3":
                        stageCtrlModifDateFin.run(stage);
                        break;
                    default:
                        vue.afficheMessage("La valeur insérer ne correspond pas au menu.");
                }
            }
            vue.afficheStage(stage);
            modifOk = utility.returnBoolTrueFalse("Voulez-vous modifier les données du stage ? O/N");
        }
        try {
            dataBase.saveData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String menuModif() {
        return "" +
                "1. Modifier le nom.\n" +
                "2. Modifier la date de début.\n" +
                "3. Modifier la date de fin.\n" +
                "Q. Quitter.\n"
                ;
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

    public void setStageCtrlModifDateDebut(StageCtrlModifDateDebut stageCtrlModifDateDebut) {
        this.stageCtrlModifDateDebut = stageCtrlModifDateDebut;
    }

    public void setStageCtrlModifDateFin(StageCtrlModifDateFin stageCtrlModifDateFin) {
        this.stageCtrlModifDateFin = stageCtrlModifDateFin;
    }

    public void setStageCtrlModifName(StageCtrlModifName stageCtrlModifName) {
        this.stageCtrlModifName = stageCtrlModifName;
    }

    public void setDataBase(DataBase dataBase) {
        this.dataBase = dataBase;
    }
}
