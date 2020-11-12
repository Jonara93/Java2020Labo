package be.technifutur.java2020.gestionstage.commun;

public class ParticipantCtrlModif {

    /*
    FIELD
     */
    private Vue vue;
    private Utility utility;

    /*
    METHOD
     */

    //modif un participant
    public void modifParticipant(Participant participant, String message) {
        String inputChoice;
        vue.afficheMessage(message);
        vue.afficheParticipant(participant);
        boolean modif = utility.returnBoolOuiNon("Voulez-vous modifier les informations du participants ? O/N");
        while (modif) {
            inputChoice = utility.saisirName(vue.displayModifParticipant());
            if (!inputChoice.isEmpty()) {
                String club;
                String mail;
                switch (inputChoice) {
                    case "1":
                        mail = utility.saisirMail("Veuillez saisir une adresse email ou \"q\" pour mettre à vide");
                        participant.setAdresseMail(mail);
                        break;
                    case "2":
                        club = utility.saisirName("Veuillez saisir un nom de club ou \"q\" pour mettre à vide");
                        participant.setNomClub(club);
                        break;
                }
            }
            vue.afficheParticipant(participant);
            vue.afficheMessage("Voulez-vous modifier les informations ?");
            modif = utility.returnBoolOuiNon("Voulez-vous modifier les informations du participants ? O/N");
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
