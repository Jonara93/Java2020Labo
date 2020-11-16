package be.technifutur.java2020.gestionstage.commun.tarif;

import be.technifutur.java2020.gestionstage.commun.activity.Activity;

import java.io.Serializable;
import java.util.Collection;

public class TarifDE implements Tarif , Serializable {
    /*
    FIELD
    */
    private String name = "Tarif DE.";

    /*
    CONSTRUCTOR
    */

    /*
    METHOD
    */


    @Override
    public int calculTarif(Collection<Activity> activityCollection) {
        return 365;
    }
    /*
    SETTER AND GETTER
    */
    @Override
    public String getName() {
        return name;
    }

}
