package be.technifutur.java2020.gestionstage.commun.tarif;

import be.technifutur.java2020.gestionstage.commun.activity.Activity;

import java.io.Serializable;
import java.util.Collection;


public class TarifEtudiant implements Tarif, Serializable {
    private String name = "Tarif Etudiant.";

    /*
    FIELD
    */

    /*
    METHOD
    */


    @Override
    public int calculTarif(Collection<Activity> activityCollection) {
        // calcul complexe et savant
        return 100;
    }

    /*
    SETTER AND GETTER
    */

    @Override
    public String getName() {
        return name;
    }
}
