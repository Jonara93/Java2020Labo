package be.technifutur.java2020.gestionstage.commun.participant;

import be.technifutur.java2020.gestionstage.commun.stage.Stage;
import be.technifutur.java2020.gestionstage.commun.stage.StageList;
import be.technifutur.java2020.gestionstage.commun.Vue;
import be.technifutur.java2020.gestionstage.commun.comparator.MyComparatorParticipant;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ParticipantCtrlDisplay {
    /*
    FIELD
     */
    private ParticipantList participantList;
    private Vue vue;

    /*
    METHOD
     */

    public void displayParticipant() {
        Collection<Participant> participantCollection = participantList.getCollectionParticipant();
        List<Participant> participantList = new ArrayList<>(participantCollection);
        participantList.sort(new MyComparatorParticipant());
        for (Participant participant : participantList) {
            vue.afficheParticipant(participant);
        }
    }

    public void displayParticipant(Stage stage) {
        List<Participant> participantList =  new ArrayList<>(stage.getAllParticipant());
        participantList.sort(new MyComparatorParticipant());
        for (Participant participant : participantList ) {
            vue.afficheParticipantSimple(participant);
        }
        System.out.println();
    }

    public void displayParticipant(StageList stageList) {
        Collection<Participant> participantCollection = participantList.getCollectionParticipant();
        List<Participant> participantList = new ArrayList<>(participantCollection);
        participantList.sort(new MyComparatorParticipant());
        for (Participant participant : participantList) {
            vue.afficheParticipant(participant, stageList);
        }
    }

    /*
    SETTER AND GETTER
     */

    public void setParticipantList(ParticipantList participantList) {
        this.participantList = participantList;
    }

    public void setVue(Vue vue) {
        this.vue = vue;
    }

}
