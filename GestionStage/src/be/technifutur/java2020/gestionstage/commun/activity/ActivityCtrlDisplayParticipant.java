package be.technifutur.java2020.gestionstage.commun.activity;

import be.technifutur.java2020.gestionstage.commun.participant.Participant;
import be.technifutur.java2020.gestionstage.commun.Vue;
import be.technifutur.java2020.gestionstage.commun.participation.Participation;
import be.technifutur.java2020.gestionstage.commun.stage.Stage;

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
        Stage stage = activity.getStage();
        Participation participation;
        List<Participant> participantList = stage.getAllParticipant();
        for (Participant participant : participantList) {
            participation = stage.getParticipation(participant.getIDParticipant());
            if (participation.mapActivityContainsKey(activity.getNameActivity())) {
                vue.afficheParticipantSimple(participant);
            }
        }
        System.out.println();
    }
    
    /*
    SETTER AND GETTER
    */

    public void setVue(Vue vue) {
        this.vue = vue;
    }
}
