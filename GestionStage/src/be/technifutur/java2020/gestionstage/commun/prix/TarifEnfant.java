package be.technifutur.java2020.gestionstage.commun.prix;

import be.technifutur.java2020.gestionstage.commun.activity.Activity;

import java.util.Collection;

public class TarifEnfant implements Tarif {
    private String name = "Tarif Enfant";
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
    public String getName() {
        return name;
    }

    @Override
    public int calculTarif(Collection<Activity> activityCollection) {
        return 0;
    }
    /*
    SETTER AND GETTER
    */
}
