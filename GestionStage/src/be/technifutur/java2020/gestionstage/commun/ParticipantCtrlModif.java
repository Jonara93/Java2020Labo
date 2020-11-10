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

    //Modification d'information d'un participant
    public void modifParticipant(Participant participant) {
        String inputChoice;
        int choice;
        inputChoice = utility.saisirName(vue.displayModifParticipant());
        if (!inputChoice.isEmpty()) {
            choice = Integer.parseInt(inputChoice);
            String club;
            String mail;
            switch (choice) {
                case 1:
                    mail = utility.saisirMail("Veuillez saisir une adresse email ou \"q\" pour mettre à vide");
                    participant.setAdresseMail(mail);
                    break;
                case 2:
                    club = utility.saisirName("Veuillez saisir un nom de club ou \"q\" pour mettre à vide");
                    participant.setNomClub(club);
                    break;
            }
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
