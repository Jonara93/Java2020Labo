package be.technifutur.java2020.gestionstage.commun.stage.modifstage;


import be.technifutur.java2020.gestionstage.commun.Utility;
import be.technifutur.java2020.gestionstage.commun.Vue;
import be.technifutur.java2020.gestionstage.commun.stage.Stage;
import be.technifutur.java2020.gestionstage.commun.stage.StageList;

import java.util.Map;

public class StageCtrlModifName {
    /*
    FIELD
    */
    private Vue vue;
    private Utility utility;
    private StageList stageList;


    /*
    METHOD
    */
    public void run(Stage stage) {
        Map<String, Stage> stageMap = stageList.getMapStageModifiable();
        String oldName, newName;
        boolean confirmModif;
        oldName = stage.getIntituleStage();

        vue.afficheMessage("Nom actuel du stage : " + oldName);
        newName = utility.saisirName("Veuillez saisir le nouveau nom. \"Q\" pour quitter.");
        if (!newName.equalsIgnoreCase("Q") && !newName.isEmpty()) {
            if (!stageList.containsKey(newName)) {
                vue.afficheMessage("" +
                        "Ancien nom : " + oldName + "\n"+
                        "Nouveau nom : " + newName
                );
                confirmModif = utility.returnBoolTrueFalse("Etes-vous sûr de vouloir changer le nom ? O/N");
                if (confirmModif) {
                    stageMap.putIfAbsent(newName, stageMap.remove(oldName));
                    stage.setIntituleStage(newName);
                }
            } else {
                vue.afficheMessage("Impossible, ce nom de stage existe déjà.");
            }
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

    public void setStageList(StageList stageList) {
        this.stageList = stageList;
    }
}
