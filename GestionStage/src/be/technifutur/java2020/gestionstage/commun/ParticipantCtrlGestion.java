package be.technifutur.java2020.gestionstage.commun;

public class ParticipantCtrlGestion {

    /*
    FIELD
     */
    private User user;
    private Utility utility;
    private Vue vue;
    private ParticipantList participantList;
    private StageList stageList;


    /*
    METHOD
     */

    public void ajouterParticipant(Stage stage) {
        String nomParticipant, prenomParticipant;
        nomParticipant = utility.saisirName("Veuillez saisir le nom du participant. Insérer \"q\" pour quitter");
        if (!nomParticipant.isEmpty()) {
            prenomParticipant = utility.saisirName("Veuillez saisir le prénom du participant. Insérer \"q\" pour quitter");
            if (!prenomParticipant.isEmpty()) {
                String IDParticipant = nomParticipant.concat(prenomParticipant);
                // 1 : le participant n'existe pas faut le créer
                // 2 : il existe dans la liste mais n'est pas inscrit dans le stage.
                // 3 : il est déjà inscrit au stage
                // 2 et 3 demander si les informations sont correctes et possibilités de modifiés.






                /*if (participantList.verifParticipantInList(IDParticipant)) {
                    modifParticipant(participantList.getParticipant(IDParticipant), stage);
                } else {
                    createParticipant(IDParticipant, nomParticipant, prenomParticipant, stage);
                }*/
            }
        }
    }

   /* //Modification d'information d'un participant
    private void modifParticipant(Participant participant, Stage stage) {
        String inputChoice;
        int choice;
        vue.afficheMessage("Le participant existe déjà.");
        do {
            vue.afficheMessage("Données du Participant : ");
            vue.afficheParticipant(participant);
            inputChoice = utility.saisirName(vue.displayModifParticipant());
            if (!inputChoice.isEmpty()) {
                choice = Integer.parseInt(inputChoice);
                String club;
                String mail;
                String nameStage;
                switch (choice) {
                    case 1:
                        mail = utility.saisirMail("Veuillez saisir une adresse email ou \"q\" pour mettre à vide");
                        participant.setAdresseMail(mail);
                        break;
                    case 2:
                        club = utility.saisirName("Veuillez saisir un nom de club ou \"q\" pour mettre à vide");
                        participant.setNomClub(club);
                        break;
                    case 3: // ajouter le stagiaire au stage
                        stage.addParticipant(participant);
                        break;
                    case 4: // retirer le stagiaire du stage
                        stage.removeParticipant(participant);
                        break;
                }
            }
        } while (!inputChoice.isEmpty());
    }*/

    //Creation d'un participant
    private void createParticipant(String IDParticipant, String nomParticipant, String prenomParticipant, Stage stage) {
        String mailParticipant, clubParticipant, nameStage;
        vue.afficheMessage("L'utilisateur n'existe pas.");
        clubParticipant = utility.saisirName("Veuillez saisir le nom du club du participant ou insérer \"q\" pour laisser le champ vide.");
        mailParticipant = utility.saisirMail("Veuillez saisir l'adresse mail du participant ou insérer \"q\" pour laisser le champ vide.");
        Participant participant = stage.createParticipant(IDParticipant, nomParticipant, prenomParticipant, clubParticipant, mailParticipant);
        participantList.addParticipant(IDParticipant, participant);

    }


    /*
    SETTER AND GETTER
     */

    public void setUser(User user) {
        this.user = user;
    }

    public void setUtility(Utility utility) {
        this.utility = utility;
    }

    public void setVue(Vue vue) {
        this.vue = vue;
    }

    public void setParticipantList(ParticipantList participantList) {
        this.participantList = participantList;
    }

    public void setStageList(StageList stageList) {
        this.stageList = stageList;
    }
}
