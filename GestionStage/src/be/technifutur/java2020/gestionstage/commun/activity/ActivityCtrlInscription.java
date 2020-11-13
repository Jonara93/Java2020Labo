package be.technifutur.java2020.gestionstage.commun.activity;

import be.technifutur.java2020.gestionstage.commun.*;
import be.technifutur.java2020.gestionstage.commun.participant.Participant;
import be.technifutur.java2020.gestionstage.commun.participant.ParticipantCtrlCreate;
import be.technifutur.java2020.gestionstage.commun.participant.ParticipantCtrlModif;
import be.technifutur.java2020.gestionstage.commun.participant.ParticipantList;
import be.technifutur.java2020.gestionstage.commun.stage.Stage;

public class ActivityCtrlInscription {
    /*
    FIELD
     */
    private Vue vue;
    private Utility utility;
    private ParticipantCtrlModif participantCtrlModif;
    private ParticipantCtrlCreate participantCtrlCreate;
    private ParticipantList participantList;
    
    /*
    METHOD
    */

    public void inscriptionActivity(Stage stage, Activity activity) {
        String nom = null, prenom = null, idParticipant = null;
        boolean inscriptionOk;
        //Demander une personne
        nom = utility.saisirName("Veuillez choisir le nom d'un participant.Insérer \"Q\" pour quitter");
        if (!nom.isEmpty()) {
            prenom = utility.saisirName("Veuillez choisir le prenom d'un participant.Insérer \"Q\" pour quitter");
            if (!prenom.isEmpty()) {
                idParticipant = nom.concat(prenom).toUpperCase();
            }
        }
        if (idParticipant != null) {
            //verifier que la personne existe
            if (activity.containsKeyParticipant(idParticipant)) {
                // personne déjà inscrite dans l'activité
                vue.afficheMessage("Ce participant est déjà inscrit à cette activité.");
            } else if (stage.containsKeyParticipant(idParticipant)) {
                //Si la personne existe :
                // demander si les informations sont correctes (pouvoir les changer)
                Participant participant = stage.getParticipant(idParticipant);
                vue.afficheMessage("Le participant est inscrit à ce stage.");
                participantCtrlModif.modifParticipant(participant, "Information du participant : ");
                // Demander si on veut bien l'inscrire à l'activités
                inscriptionOk = utility.returnBoolTrueFalse("Voulez-vous inscrire le participant à cette activité ? O/N");
                if (inscriptionOk) {
                    activity.addParticipantToMap(idParticipant, participant);
                }
            } else if (participantList.verifParticipantInList(idParticipant)) {
                Participant participant = participantList.getParticipant(idParticipant);
                // le participant n'est pas dans le stage mais existe
                // Demander si elle veut s'inscrire au stage et à l'activité.
                inscriptionOk = utility.returnBoolTrueFalse("" + "" +
                        "N 'existe pas dans la liste des participants du stage.\n" +
                        "Voulez-vous vous inscrire au stage et à cette activité ? O/N"
                );
                // Si oui : verif info + inscrire stage et activité
                if (inscriptionOk) {
                    //verif info
                    participantCtrlModif.modifParticipant(participant, "Information du participant : ");
                    // inscription dans le stage
                    stage.addParticipant(participant);
                    // inscription dans l'activité
                    activity.addParticipantToMap(idParticipant, participant);
                }
            } else {
                //Si la personne n'existe pas :
                // Demander si elle veut s'inscrire au stage et à l'activité.
                inscriptionOk = utility.returnBoolTrueFalse("" + "" +
                        "N 'existe pas dans la liste des participants.\n" +
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

    public void setParticipantList(ParticipantList participantList) {
        this.participantList = participantList;
    }
}

