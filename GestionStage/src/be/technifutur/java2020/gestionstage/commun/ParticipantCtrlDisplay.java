package be.technifutur.java2020.gestionstage.commun;

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
        List<Participant> participantList =  new ArrayList<>(stage.getMapParticipant().values());
        participantList.sort(new MyComparatorParticipant());
        for (Participant participant : participantList ) {
            vue.afficheParticipant(participant);
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
