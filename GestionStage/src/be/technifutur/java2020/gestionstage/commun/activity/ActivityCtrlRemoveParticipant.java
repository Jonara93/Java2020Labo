package be.technifutur.java2020.gestionstage.commun.activity;

import be.technifutur.java2020.gestionstage.commun.participant.Participant;
import be.technifutur.java2020.gestionstage.commun.Utility;
import be.technifutur.java2020.gestionstage.commun.Vue;
import be.technifutur.java2020.gestionstage.commun.comparator.MyComparatorParticipant;
import be.technifutur.java2020.gestionstage.commun.participation.Participation;
import be.technifutur.java2020.gestionstage.commun.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class ActivityCtrlRemoveParticipant {
    /*
    FIELD
    */
    private Vue vue;
    private Utility utility;

    /*
    METHOD
    */
    public void removeParticipant(Activity activity) {
        //utilitaire
        Stage stage = activity.getStage();
        List<Participant> participantList = new ArrayList<>(stage.getAllParticipant());
        participantList.sort(new MyComparatorParticipant());
        String inputChoice;
        int indexParticipant = 1, choice = 0;
        //verif s'il y a des participants
        if (!participantList.isEmpty()) {
            //liste des participants de l'activity
            for (Participant participant : participantList) {
                System.out.println(indexParticipant + " : " + participant.getNomParticipant() + " " + participant.getPrenomParticipant());
                indexParticipant++;
            }
            //choisir le participant
            inputChoice = utility.saisirName("Veuillez choisir le numéro de la personne à supprimer de l'activité. Insérer \"q\" pour quitter.");
            try {
                choice = Integer.parseInt(inputChoice);
            } catch (NumberFormatException e) {
                vue.afficheMessage("Vous n'avez pas insérer un nombre.");
            }
            if (choice >= 1 && choice <= indexParticipant) {
                //retirer de la liste de l'activity
                Participant participant = participantList.get(indexParticipant-1);
                Participation participation = stage.getParticipation(participant.getIDParticipant());
                participation.removeActivity(activity);
            } else {
                vue.afficheMessage("Votre choix ne correspond à aucun participant.");
            }
        }else {
            vue.afficheMessage("Il n'y a pas de personnes inscrites à ce stage.");
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
