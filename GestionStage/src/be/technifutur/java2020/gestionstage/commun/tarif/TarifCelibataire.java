package be.technifutur.java2020.gestionstage.commun.tarif;

import be.technifutur.java2020.gestionstage.commun.activity.Activity;

import java.util.Collection;

public class TarifCelibataire implements Tarif {
    /*
    FIELD
    */
    private String name = "Tarif Celibataire.";
    
    /*
    CONSTRUCTOR
    */
    
    /*
    METHOD
    */
    @Override
    public int calculTarif(Collection<Activity> activityCollection) {
        return 23;
    }


    /*
    SETTER AND GETTER
    */
    @Override
    public String getName() {
        return this.name;
    }
}
