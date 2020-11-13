package be.technifutur.java2020.gestionstage.commun.prix;

import java.util.List;

public class TarifList {
    /*
    FIELD
    */
    List<Tarif> tarifList;

    /*
    CONSTRUCTOR
    */
    public TarifList() {
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
}
