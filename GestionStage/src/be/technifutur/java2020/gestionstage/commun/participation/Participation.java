package be.technifutur.java2020.gestionstage.commun.participation;

import be.technifutur.java2020.gestionstage.commun.activity.Activity;
import be.technifutur.java2020.gestionstage.commun.participant.Participant;
import be.technifutur.java2020.gestionstage.commun.stage.Stage;
import be.technifutur.java2020.gestionstage.commun.tarif.Tarif;

import java.io.Serializable;
import java.util.*;

public class Participation implements Serializable {
    /*
    FIELD
    */
    private Participant participant;
    private Tarif tarif;
    private Map<String, Activity> activityMap;// Key = nameActivity

    /*
    CONSTRUCTOR
    */
    public Participation(Participant participant, Tarif tarif) {
        this.participant = participant;
        this.tarif = tarif;
        activityMap = new HashMap<>();
    }


    /*
    METHOD
    */

    public boolean mapActivityContainsKey(String nameActivity) {
        return this.getActivityMap().containsKey(nameActivity);
    }

    public void addActivity(Activity activity) {
        this.getActivityMap().putIfAbsent(activity.getNameActivity(), activity);
    }

    public void removeActivity(Activity activity) {
        activityMap.remove(activity.getNameActivity());
    }

    public Collection<Activity> getListActivity() {
        Collection<Activity> activityCollection = getActivityMap().values();
        List<Activity> activityList = new ArrayList<>(activityCollection);

        return activityList;
    }

    
    /*
    SETTER AND GETTER
    */

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    public Tarif getTarif() {
        return tarif;
    }

    public void setTarif(Tarif tarif) {
        this.tarif = tarif;
    }

    public Map<String, Activity> getActivityMap() {
        return activityMap;
    }

    public void setActivityMap(Map<String, Activity> activityMap) {
        this.activityMap = activityMap;
    }

    public String getIDParticipant() {
        return participant.getIDParticipant();
    }


}
