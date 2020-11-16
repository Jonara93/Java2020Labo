package be.technifutur.java2020.gestionstage.commun.tarif;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TarifList implements Serializable {
    /*
    FIELD
    */
    List<Tarif> tarifList;

    /*
    CONSTRUCTOR
    */
    public TarifList() {
        tarifList = new ArrayList<>();
        tarifList.add(new TarifCelibataire());
        tarifList.add(new TarifCouple());
        tarifList.add(new TarifDE());
        tarifList.add(new TarifEnfant());
        tarifList.add(new TarifEtudiant());
        tarifList.add(new TarifProf());
    }
    
    /*
    METHOD
    */


    
    /*
    SETTER AND GETTER
    */

    public List<Tarif> getTarifList() {
        return tarifList;
    }
}
