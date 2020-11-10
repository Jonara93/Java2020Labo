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
    private ParticipantCtrlModif participantCtrlModif;


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
                // 2 et 3 demander si les informations sont correctes et possibilités de modifiés.
                Participant participant = participantList.getParticipant(IDParticipant);
                if (stage.containsKey(IDParticipant)) { // 3 : il est déjà inscrit au stage
                    modifParticipant(participant);
                } else if (participantList.verifParticipantInList(IDParticipant) && !stage.containsKey(IDParticipant)) {// 2 : il existe dans la liste mais n'est pas inscrit dans le stage.
                    modifParticipant(participant);
                    if (utility.returnBoolOuiNon("Voulez-vous ajouter le participant dans ce stage ? O/N")) {
                        stage.addParticipant(participant);
                    }
                } else {  // 1 : le participant n'existe pas faut le créer + ajout du participant au stage
                    vue.afficheMessage("Le participant n'existe pas dans ce stage.");
                    createParticipant(IDParticipant, nomParticipant, prenomParticipant, stage);
                }
            }
        }
    }

    //modif un participant
    private void modifParticipant(Participant participant) {
        vue.afficheMessage("Le participant est déjà inscrit dans ce stage.");
        vue.afficheParticipant(participant);
        boolean modif = utility.returnBoolOuiNon("Voulez-vous modifier les informations du participants ? O/N");
        while (modif) {
            participantCtrlModif.modifParticipant(participant);
            vue.afficheMessage("Voulez-vous modifier les informations ?");
            modif = utility.returnBoolOuiNon("Voulez-vous modifier les informations du participants ? O/N");
        }
    }

    //Creation d'un participant
    private void createParticipant(String IDParticipant, String nomParticipant, String prenomParticipant, Stage stage) {
        String mailParticipant, clubParticipant;
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

    public void setParticipantCtrlModif(ParticipantCtrlModif participantCtrlModif) {
        this.participantCtrlModif = participantCtrlModif;
    }
}
