package be.technifutur.java2020.gestionstage.commun.tarif;

import be.technifutur.java2020.gestionstage.commun.activity.Activity;

import java.util.Collection;

public class TarifBase implements Tarif {
    /*
    FIELD
    */
    private String name = "Prix de base.";
    
    /*
    METHOD
    */

    @Override
    public int calculTarif(Collection<Activity> activityCollection) {
        return 1;
    }
    
    /*
    SETTER AND GETTER
    */

    @Override
    public String getName() {
        return null;
    }
}
