package be.technifutur.java2020.gestionstage.commun.tarif;

import be.technifutur.java2020.gestionstage.commun.activity.Activity;

import java.util.Collection;

public class TarifProf implements Tarif {
    private String name = "Tarif Prof.";

    /*
    FIELD
    */

    /*
        METHOD
        */
    @Override
    public int calculTarif(Collection<Activity> activityCollection) {
        // calcul complexe et savant
        return 200;
    }


    /*
    SETTER AND GETTER
    */

    @Override
    public String getName() {
        return name;
    }
}
