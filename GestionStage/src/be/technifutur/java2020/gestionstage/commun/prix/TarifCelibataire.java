package be.technifutur.java2020.gestionstage.commun.prix;

import be.technifutur.java2020.gestionstage.commun.activity.Activity;

import java.util.Collection;

public class TarifCelibataire implements Tarif {
    /*
    FIELD
    */
    private String name = "Tarif Celibataire";
    
    /*
    CONSTRUCTOR
    */
    
    /*
    METHOD
    */

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int calculTarif(Collection<Activity> activityCollection) {
        return 0;
    }
    /*
    SETTER AND GETTER
    */
}
