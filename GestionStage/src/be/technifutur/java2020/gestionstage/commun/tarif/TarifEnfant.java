package be.technifutur.java2020.gestionstage.commun.tarif;

import be.technifutur.java2020.gestionstage.commun.activity.Activity;

import java.io.Serializable;
import java.util.Collection;

public class TarifEnfant implements Tarif , Serializable {
    private String name = "Tarif Enfant.";
    /*
    FIELD
    */
    
    /*
    CONSTRUCTOR
    */
    
    /*
    METHOD
    */


    @Override
    public int calculTarif(Collection<Activity> activityCollection) {
        return 154;
    }
    /*
    SETTER AND GETTER
    */
    @Override
    public String getName() {
        return name;
    }

}
