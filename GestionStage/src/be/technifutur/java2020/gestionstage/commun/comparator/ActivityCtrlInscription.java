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
    private ParticipantCtrlModif participantCtrlModif;
    private ParticipantCtrlCreate participantCtrlCreate;
    
    /*
    METHOD
    */

    public void inscriptionActivity(Stage stage) {
        String nameActivity, nom = null, prenom = null, idParticipant = null;
        boolean inscriptionOk;
        //récupération des données utiles
        Map<String, Activity> activityMap = stage.getMapActivity();
        List<Activity> activityList = new ArrayList<>(stage.getActivityCollection());
        activityList.sort(new MyComparatorActivity());
        List<Participant> participantListFromStage = stage.getSortListParticipantByName();
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
            Activity activity = activityMap.get(nameActivity);
            //verifier que la personne existe
            if (participantListFromStage.contains(idParticipant)) {
                //Si la personne existe :
                // demander si les informations sont correctes (pouvoir les changer)
                Participant participant = stage.getParticipant(idParticipant);
                participantCtrlModif.modifParticipant(participant, "\"Le participant est inscrit à ce stage.\"");
                // Demander si on veut bien l'inscrire à l'activités
                inscriptionOk = utility.returnBoolTrueFalse("Voulez-vous inscrire le participant à cette activité ? O/N");
                if (inscriptionOk) {
                    activity.addParticipantToMap(idParticipant, participant);
                }
            } else {
                //Si la personne n'existe pas :
                // Demander si elle veut s'inscrire au stage et à l'activité.
                inscriptionOk = utility.returnBoolTrueFalse("" + "" +
                        "N 'existe pas dans la liste des participans.\n" +
                        "Voulez-vous vous inscrire au stage et à cette activité ? O/N"
                );
                //SI oui : demande information complémentaire + inscrire AU !!!!!!STAGE!!!!!! et !!!!!ACTIVITE!!!!!
                if (inscriptionOk) {
                    // inscription dans le stage
                    participantCtrlCreate.createParticipant(idParticipant, nom, prenom, stage);
                    Participant participant = stage.getParticipant(idParticipant);
                    // inscription dans l'activité
                    activity.addParticipantToMap(idParticipant, participant);
                }
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

    public void setParticipantCtrlModif(ParticipantCtrlModif participantCtrlModif) {
        this.participantCtrlModif = participantCtrlModif;
    }

    public void setParticipantCtrlCreate(ParticipantCtrlCreate participantCtrlCreate) {
        this.participantCtrlCreate = participantCtrlCreate;
    }

}
