package be.technifutur.java2020.gestionstage.commun.prix;

import be.technifutur.java2020.gestionstage.commun.activity.Activity;

import java.util.Collection;

public class TarifCouple implements Tarif {
    /*
    FIELD
    */
    private String name = "Tarif Couple";
    
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
