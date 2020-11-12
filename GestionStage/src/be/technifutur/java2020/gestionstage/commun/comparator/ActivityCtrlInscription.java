package be.technifutur.java2020.gestionstage.commun.comparator;

import be.technifutur.java2020.gestionstage.commun.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ActivityCtrlInscription {
    /*
    FIELD
     */
    private Vue vue;
    private Utility utility;
    
    /*
    METHOD
    */

    public void inscriptionActivity(Stage stage) {
        String nameActivity, nom, prenom, idParticipant = null;
        //récupération des données utiles
        Map<String, Activity> activityMap = stage.getMapActivity();
        List<Activity> activityList = new ArrayList<>(stage.getActivityCollection());
        activityList.sort(new MyComparatorActivity());
        List<Participant> participantList = stage.getSortListParticipantByName();
        //Afficher la liste des activités
        vue.afficheHoraire(stage, activityList);
        //Choisir une activité
        nameActivity = utility.saisirName("Veuillez choisir une activité.Insérer \"Q\" pour quitter");
        while (!activityMap.containsKey(nameActivity) && !nameActivity.isEmpty()) {
            nameActivity = utility.saisirName("Veuillez choisir une activité.Insérer \"Q\" pour quitter");
        }
        //Demander une personne
        if (!nameActivity.isEmpty()) {
            nom = utility.saisirName("\"Veuillez choisir le nom d'un participant.Insérer \\\"Q\\\" pour quitter\"");
            if (!nom.isEmpty()) {
                prenom = utility.saisirName("\"Veuillez choisir le prenom d'un participant.Insérer \\\"Q\\\" pour quitter\"");
                if (!prenom.isEmpty()) {
                    idParticipant = nom.concat(prenom).toUpperCase();
                }
            }
        }
        if (idParticipant != null) {
            //verifier que la personne existe
            if (participantList.contains(idParticipant)) {
                //Si elle existe :
                // demander si les informations sont correctes (pouvoir les changer)
                vue.afficheMessage("Le participant est inscrit à ce stage.");
                Participant participant = stage.getParticipant(idParticipant);
                vue.afficheParticipant(stage.getParticipant(idParticipant));

                // Demander si on veut bien l'inscrire à l'activités

            } else {
                //Si elle n'existe pas :
                // Demander si elle veut s'inscrire au stage et à l'activité.
                //SI oui : demande information complémentaire + inscrire AU !!!!!!STAGE!!!!!! et !!!!!ACTIVITE!!!!!

            }
        }
    }
    
    /*
    SETTER AND GETTER
    */

    public void setVue(Vue vue) {
        this.vue = vue;
    }

    public void setUtility(Utility utility) {
        this.utility = utility;
    }
}
