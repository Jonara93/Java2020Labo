package be.technifutur.java2020.gestionstage.commun;

public class ParticipantCtrlCreate {
    /*
    FIELD
    */
    private ParticipantList participantList;
    private Utility utility;

    
    /*
    METHOD
    */

    //Creation d'un participant
    public void createParticipant(String IDParticipant, String nomParticipant, String prenomParticipant, Stage stage) {
        String mailParticipant, clubParticipant;
        clubParticipant = utility.saisirName("Veuillez saisir le nom du club du participant ou insérer \"q\" pour laisser le champ vide.");
        mailParticipant = utility.saisirMail("Veuillez saisir l'adresse mail du participant ou insérer \"q\" pour laisser le champ vide.");
        Participant participant = stage.createParticipant(IDParticipant, nomParticipant, prenomParticipant, clubParticipant, mailParticipant);
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
}
