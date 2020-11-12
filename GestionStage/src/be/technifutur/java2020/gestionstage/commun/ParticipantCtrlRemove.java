package be.technifutur.java2020.gestionstage.commun;

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
        List<Participant> participantListSortedByName = stage.getSortListParticipantByName();
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
                if (!participantInActivity(stage, participant)) {
                    stage.removeParticipant(participant);
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

    private boolean participantInActivity(Stage stage, Participant participant) {
        boolean inActivity = false;
        List<Activity> activityList = new ArrayList<>(stage.getActivityCollection());
        Iterator<Activity> activityIterator = activityList.iterator();
        while (activityIterator.hasNext() && !inActivity) {
            inActivity = activityIterator.next().containsKeyParticipant(participant.getIDParticipant());
        }
        return inActivity;
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
