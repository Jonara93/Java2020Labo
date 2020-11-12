package be.technifutur.java2020.gestionstage.commun;

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
            int index = 0, choice = 0;
            String inputChoice;
            for (Participant participant : participantListSortedByName) {
                System.out.println("" +
                        (index + 1) + " : " + participant.getNomParticipant() + " " + participant.getPrenomParticipant()
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
                System.out.println("ParticipantCtrlRemove.removeParticipant");
                stage.removeParticipant(participantListSortedByName.get(choice - 1));
            } else {
                vue.afficheMessage("Votre choix ne correspond à aucun participant.");
            }
        } else {
            vue.afficheMessage("Il n'y a pas de participant à ce stage.");
        }

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
