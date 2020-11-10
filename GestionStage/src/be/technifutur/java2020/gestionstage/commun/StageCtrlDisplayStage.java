package be.technifutur.java2020.gestionstage.commun;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class StageCtrlDisplayStage {
    private Vue vue;
    private StageList stageList;

    public void displayStage() {
        Map<String, Stage> map = stageList.getMap();
        String name;
        LocalDateTime dateDebut, dateFin;
        Collection<Stage> stage = map.values();
        List<Stage> stageList = new ArrayList<>(stage);
        stageList.sort(new MyComparatorStage());
        for (Stage value : stageList) {
            name = (value.getIntituleStage());
            dateDebut = (value.getDateDebut());
            dateFin = (value.getDateFin());
            vue.afficheStage(name,dateDebut,dateFin);
        }
    }

    public void setStageList(StageList stageList) {
        this.stageList = stageList;
    }

    public void setVue(Vue vue) {
        this.vue = vue;
    }

}

