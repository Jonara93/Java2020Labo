package be.technifutur.java2020.gestionstage.commun.participant;

import be.technifutur.java2020.gestionstage.commun.Vue;
import be.technifutur.java2020.gestionstage.commun.stage.Stage;
import be.technifutur.java2020.gestionstage.commun.Utility;
import be.technifutur.java2020.gestionstage.commun.tarif.Tarif;
import be.technifutur.java2020.gestionstage.commun.tarif.TarifBase;
import be.technifutur.java2020.gestionstage.commun.tarif.TarifList;

public class ParticipantCtrlCreate {
    /*
    FIELD
    */
    private ParticipantList participantList;
    private Utility utility;
    private Vue vue;

    
    /*
    METHOD
    */

    //Creation d'un participant
    public void createParticipant(String IDParticipant, String nomParticipant, String prenomParticipant, Stage stage) {
        String mailParticipant, clubParticipant;
        Tarif tarif;
        clubParticipant = utility.saisirName("Veuillez saisir le nom du club du participant ou insérer \"q\" pour laisser le champ vide.");
        mailParticipant = utility.saisirMail("Veuillez saisir l'adresse mail du participant ou insérer \"q\" pour laisser le champ vide.");
        vue.afficheMessage("Veuillez choisir un tarif pour le participant. \"Q\" pour le tarif de base");
        tarif = utility.choiceOneTarifFromStage(stage);
        Participant participant = stage.createParticipation(IDParticipant, nomParticipant, prenomParticipant, clubParticipant, mailParticipant, tarif);
        participantList.addParticipant(IDParticipant, participant);
    }
    
    /*
    SETTER AND GETTER
    */

    public void setParticipantList(ParticipantList participantList) {
        this.participantList = participantList;
    }

    public void setUtility(Utility utility) {
        this.utility = utility;
    }

    public void setVue(Vue vue) {
        this.vue = vue;
    }
}
