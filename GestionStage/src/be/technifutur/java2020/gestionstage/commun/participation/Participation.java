package be.technifutur.java2020.gestionstage.commun.participation;

import be.technifutur.java2020.gestionstage.commun.activity.Activity;
import be.technifutur.java2020.gestionstage.commun.participant.Participant;
import be.technifutur.java2020.gestionstage.commun.prix.Tarif;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

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
    public Participation(Participant participant/*,tarif*/) {
        this.participant = participant;
        //this.tarif = tarif;
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

    public static void main(String[] args) {
        Participation participation = new Participation(new Participant("jojo", "otot", "4", "4"));
        Map<String, Activity> activityMap = participation.getActivityMap();
        activityMap.containsKey("JOJOOTOT");
    }


}
