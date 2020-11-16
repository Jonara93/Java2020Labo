package be.technifutur.java2020.gestionstage.commun.stage;

import be.technifutur.java2020.gestionstage.exception.ExceptionGestionStage;
import be.technifutur.java2020.gestionstage.exception.ExceptionGestionStageNomInvalide;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

public class StageList implements Serializable {
    /*
    FIELD
     */

    private Map<String, Stage> mapStage = new HashMap<>();

    /*
    METHOD
     */


    public void addStage(LocalDateTime dateDebut, LocalDateTime dateFin, String intituleStage) throws ExceptionGestionStage {
        if (mapStage.containsKey(intituleStage)) {
            throw new ExceptionGestionStageNomInvalide("Impossible de créer ce stage.\nUn stage porte déjà ce nom.");
        } else {
            mapStage.put(intituleStage, new Stage(dateDebut, dateFin, intituleStage));
        }
    }

    public void removeStage() {

    }

    public void searchStage() {

    }

    public boolean containsKey(String key) {
        return mapStage.containsKey(key);
    }

    /*
    GETTER AND SETTER
     */

    public Stage getStage(String name) {
        return mapStage.get(name);
    }

    public Map getMapStageUnmodifiable() {
        return Collections.unmodifiableMap(mapStage);
    }

    public Map getMapStageModifiable() {
        return mapStage;
    }

    public Collection<String> getStringCollection() {
        return Collections.unmodifiableCollection(mapStage.keySet());
    }

    public void setMapStage(Map<String, Stage> mapStage) {
        this.mapStage = mapStage;
    }
}
