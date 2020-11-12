package be.technifutur.java2020.gestionstage.commun;

import be.technifutur.java2020.gestionstage.commun.comparator.MyComparatorParticipant;

import java.util.ArrayList;
import java.util.List;

public class ActivityCtrlDisplayParticipant {
    /*
    FIELD
    */
    private Vue vue;

    
    /*
    METHOD
    */

    public void DisplayParticipant(Activity activity) {
        List<Participant> participantList = new ArrayList<>(activity.getCollectionOfParticipant());
        participantList.sort(new MyComparatorParticipant());
        for (Participant participant : participantList) {
            vue.afficheParticipant(participant);
        }
    }
    
    /*
    SETTER AND GETTER
    */

    public void setVue(Vue vue) {
        this.vue = vue;
    }
}
