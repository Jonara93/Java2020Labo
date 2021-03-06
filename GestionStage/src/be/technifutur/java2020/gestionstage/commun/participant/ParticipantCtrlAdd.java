package be.technifutur.java2020.gestionstage.commun.participant;

import be.technifutur.java2020.gestionstage.DataBase;
import be.technifutur.java2020.gestionstage.commun.stage.Stage;
import be.technifutur.java2020.gestionstage.commun.User;
import be.technifutur.java2020.gestionstage.commun.Utility;
import be.technifutur.java2020.gestionstage.commun.Vue;
import be.technifutur.java2020.gestionstage.commun.tarif.Tarif;

import java.io.IOException;
import java.io.Serializable;

public class ParticipantCtrlAdd implements Serializable {

    /*
    FIELD
     */
    private User user;
    private Utility utility;
    private Vue vue;
    private ParticipantList participantList;
    private ParticipantCtrlModif participantCtrlModif;
    private ParticipantCtrlCreate participantCtrlCreate;
    private DataBase dataBase;


    /*
    METHOD
     */
    public void ajouterParticipant(Stage stage) {
        String nomParticipant, prenomParticipant;
        nomParticipant = utility.saisirName("Veuillez saisir le nom du participant. Insérer \"q\" pour quitter");
        if (!nomParticipant.isEmpty()) {
            prenomParticipant = utility.saisirName("Veuillez saisir le prénom du participant. Insérer \"q\" pour quitter");
            if (!prenomParticipant.isEmpty()) {
                String IDParticipant = nomParticipant.concat(prenomParticipant).toUpperCase();
                Participant participant = participantList.getParticipant(IDParticipant);
                if (stage.containsKeyParticipant(IDParticipant)) { // déjà inscrit au stage
                    participantCtrlModif.modifParticipant(participant, "Le participant est déjà inscrit à ce stage.");
                } else if (participantList.verifParticipantInList(IDParticipant) && !stage.containsKeyParticipant(IDParticipant)) {// existe dans la liste mais pas inscrit dans le stage.
                    participantCtrlModif.modifParticipant(participant, "Le participant existe mais n'est pas inscrit à ce stage.");
                    if (utility.returnBoolTrueFalse("Voulez-vous ajouter le participant dans ce stage ? O/N")) {
                        Tarif tarif = utility.choiceOneTarifFromStage(stage);
                        stage.addParticipantion(participant, tarif);
                    }
                } else {  // 1 : le participant n'existe pas faut le créer + ajout du participant au stage
                    vue.afficheMessage("Le participant n'existe pas.");
                    participantCtrlCreate.createParticipant(IDParticipant, nomParticipant, prenomParticipant, stage);
                }
            }
        }
        try {
            dataBase.saveData();
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    public void setParticipantCtrlModif(ParticipantCtrlModif participantCtrlModif) {
        this.participantCtrlModif = participantCtrlModif;
    }

    public void setDataBase(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public void setParticipantCtrlCreate(ParticipantCtrlCreate participantCtrlCreate) {
        this.participantCtrlCreate = participantCtrlCreate;
    }
}
