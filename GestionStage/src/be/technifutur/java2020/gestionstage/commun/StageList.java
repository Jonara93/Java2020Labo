package be.technifutur.java2020.gestionstage.commun;

import be.technifutur.java2020.gestionstage.exception.ExceptionGestionStageDate;

import java.time.LocalDateTime;
import java.util.*;

public class StageList {
    /*
    FIELD
     */
    private Map<String, Stage> mapStage = new HashMap<>();

    /*
    METHOD
     */

    public void addStage(LocalDateTime dateDebut, LocalDateTime dateFin, String intituleStage) throws ExceptionGestionStageDate {
        mapStage.put(intituleStage, new Stage(dateDebut, dateFin, intituleStage));
    }

    public void removeStage() {

    }

    public void searchStage() {

    }

    public boolean containsKey(String key){
        return mapStage.containsKey(key);
    }

    /*
    GETTER AND SETTER
     */

    public Stage getStage(String name) {
        return mapStage.get(name);
    }

    public Map getMap() {
        return Collections.unmodifiableMap(mapStage);
    }

    public Collection<String> getStringCollection() {
        return Collections.unmodifiableCollection(mapStage.keySet());
    }

    public void setMapStage(Map<String, Stage> mapStage) {
        this.mapStage = mapStage;
    }


}
