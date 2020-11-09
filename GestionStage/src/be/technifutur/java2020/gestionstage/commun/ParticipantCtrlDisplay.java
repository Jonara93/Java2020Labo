package be.technifutur.java2020.gestionstage.commun;

import java.util.Collection;

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
        for (Participant participant : participantCollection) {
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
