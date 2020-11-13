package be.technifutur.java2020.gestionstage.commun.participant;

import be.technifutur.java2020.gestionstage.commun.comparator.MyComparatorParticipant;
import be.technifutur.java2020.gestionstage.commun.participation.Participation;
import be.technifutur.java2020.gestionstage.commun.stage.Stage;
import be.technifutur.java2020.gestionstage.commun.Utility;
import be.technifutur.java2020.gestionstage.commun.Vue;
import be.technifutur.java2020.gestionstage.commun.activity.Activity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ParticipantCtrlRemove {
    /*
    FIELD
     */
    private Vue vue;
    private Utility utility;

    /*
    METHOD
     */
    public void removeParticipant(Stage stage) {
        List<Participant> participantListSortedByName = stage.getAllParticipant();
        participantListSortedByName.sort(new MyComparatorParticipant());
        if (!participantListSortedByName.isEmpty()) {
            int index = 1, choice = 0;
            String inputChoice;
            for (Participant participant : participantListSortedByName) {
                System.out.println("" +
                        (index) + " : " + participant.getNomParticipant() + " " + participant.getPrenomParticipant()
                );
                index++;
            }
            inputChoice = utility.saisirName("Veuillez choisir un numéro d'index valide. Insérer \"q\" pour quitter.");
            try {
                choice = Integer.parseInt(inputChoice);
            } catch (NumberFormatException e) {
                vue.afficheMessage("Vous n'avez pas insérer un nombre.");
            }
            if (choice >= 1 && choice <= index) {
                Participant participant = participantListSortedByName.get(choice - 1);
                // si participant inscrit dans une activity du stage : refuse
                if (!participantHaveActivity(stage, participant)) {
                    stage.removeParticipantion(participant);
                    vue.afficheMessage(participant.getNomParticipant() + " " + participant.getPrenomParticipant() + " : a bien été supprimé.");
                }else{
                    vue.afficheMessage("Impossible de supprimer le participant, il est inscrit dans une activité du stage.");
                }

            } else {
                vue.afficheMessage("Votre choix ne correspond à aucun participant.");
            }
        } else {
            vue.afficheMessage("Il n'y a pas de participant à ce stage.");
        }

    }

    private boolean participantHaveActivity(Stage stage, Participant participant) {
        boolean haveActivity = false;
        Participation participation = stage.getParticipation(participant.getIDParticipant());
        if (!participation.getActivityMap().isEmpty()){
            haveActivity = true;
        }
        return haveActivity;
    }

    /*
    SETTER
     */

    public void setVue(Vue vue) {
        this.vue = vue;
    }

    public void setUtility(Utility utility) {
        this.utility = utility;
    }
}
