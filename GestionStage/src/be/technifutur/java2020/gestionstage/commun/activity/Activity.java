package be.technifutur.java2020.gestionstage.commun.activity;

import be.technifutur.java2020.gestionstage.commun.participant.Participant;
import be.technifutur.java2020.gestionstage.commun.stage.Stage;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Activity implements Serializable {
    /*
    FIELD
     */
    private String nameActivity;
    private LocalDateTime dateDebut;
    private int duration;
    private Map<String, Participant> mapParticipantActivity = new HashMap<>();//key = idParticipant
    private Stage stage;

    /*
    CONSTRUCTOR
     */

    public Activity(LocalDateTime dateDebut, int duration, String nameActivity, Stage stage) {
        setNameActivity(nameActivity);
        setDateDebut(dateDebut);
        setDuration(duration);
        setStage(stage);
    }

    /*
    METHOD
     */

    public void addParticipantToMap(String idParticipant, Participant participant) {
        mapParticipantActivity.putIfAbsent(idParticipant, participant);
    }


    public void removeParticipant(Participant participant) {
        mapParticipantActivity.remove(participant.getIDParticipant());
    }

    public boolean containsKeyParticipant(String idParticipant) {
        return mapParticipantActivity.containsKey(idParticipant);
    }

    /*
    SETTER AND GETTER
     */

    public String getNameActivity() {
        return nameActivity;
    }

    public void setNameActivity(String nameActivity) {
        this.nameActivity = nameActivity;
    }

    public LocalDateTime getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDateTime dateDebut) {
        this.dateDebut = dateDebut;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Map<String, Participant> getMapParticipantActivity() {
        return mapParticipantActivity;
    }

    public void setMapParticipantActivity(Map<String, Participant> mapParticipantActivity) {
        this.mapParticipantActivity = mapParticipantActivity;
    }

    public Collection<Participant> getCollectionOfParticipant() {
        return Collections.unmodifiableCollection(mapParticipantActivity.values());
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}