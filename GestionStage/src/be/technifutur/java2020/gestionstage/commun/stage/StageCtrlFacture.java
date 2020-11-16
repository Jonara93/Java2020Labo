package be.technifutur.java2020.gestionstage.commun.stage;

import be.technifutur.java2020.gestionstage.commun.Utility;
import be.technifutur.java2020.gestionstage.commun.Vue;
import be.technifutur.java2020.gestionstage.commun.participation.Participation;

public class StageCtrlFacture {
    /*
    FIELD
    */
    private Utility utility;
    private Vue vue;

    
    /*
    METHOD
    */

    public void run(Stage stage) {
        String nom, prenom, idPersonne;

        nom = utility.saisirName("Veuillez saisir le nom de la personne a facturé. \"Q\" pour annuler.");
        if (!nom.isEmpty()) {
            prenom = utility.saisirName("Veuillez saisir le prénom de la personne a facturé. \"Q\" pour annuler.");
            if (!prenom.isEmpty()) {
                idPersonne = nom.concat(prenom).toUpperCase();
                if (stage.containsKeyParticipant(idPersonne)) {
                    Participation participation = stage.getParticipation(idPersonne);
                    System.out.println(participation.getTarif().calculTarif(participation.getListActivity()));
                }else {
                    vue.afficheMessage("Ce participant n'existe pas dans ce stage.");
                }
            }
        }
    }
    
    /*
    SETTER AND GETTER
    */

    public void setUtility(Utility utility) {
        this.utility = utility;
    }

    public void setVue(Vue vue) {
        this.vue = vue;
    }
}
